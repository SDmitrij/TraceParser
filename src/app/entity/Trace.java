package app.entity;

import app.base.Parser;
import app.db.Interaction;
import app.initialize.ConfigInitializer;
import app.initialize.ParserInitializer;
import app.shared.Config;

import java.io.File;
import java.io.FileNotFoundException;
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
        var blockLines = new ArrayList<String>();
        interaction.seed();
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            if (!line.equals(config.getDelimiter())) {
                blockLines.add(line);
            } else {
                for (Parser parser : parsers) {
                    parser.to(blockLines);
                    interaction.save(parser);
                    parser.matches.clear();
                }
                blockLines.clear();
            }
        }
        scanner.close();
    }

    private void setScanner() {
        try {
            var path = String.format("%s%sSQLTrace.log", System.getProperty("user.dir"), File.separator);
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void statistics() {

    }
}
