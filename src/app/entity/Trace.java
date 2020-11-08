package app.entity;

import app.base.Parser;
import app.db.Interaction;
import app.initialize.ConfigInitializer;
import app.initialize.ParserInitializer;
import app.shared.Config;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trace {

    private final Config config = ConfigInitializer.getInstance().getConfig();
    private final List<Parser> parsers;
    private Scanner scanner;
    private final Interaction interaction;

    public Trace() {
        parsers = new ParserInitializer().getList();
        interaction = new Interaction();
        setScanner();
    }

    public void analyze() {
        apply();
        statistics();
    }

    private void apply() {
        var block = new StringBuilder();
        interaction.clear();
        interaction.seed();
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            if (!line.equals(config.getDelimiter())) {
                block.append(line);
            } else {
                for (Parser parser : parsers) {
                    parser.to(block.toString());
                    interaction.save(parser);
                    parser.matches.clear();
                }
                block = new StringBuilder();
            }
        }
        scanner.close();
    }

    private void setScanner() {
        try {
            var path = String.format("%s%s%s", System.getProperty("user.dir"), File.separator,
                config.getTraceFile());
            scanner = new Scanner(new File(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void statistics() {
        interaction.perform();
        interaction.finish();
    }
}
