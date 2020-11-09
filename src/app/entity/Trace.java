package app.entity;

import app.base.Parser;
import app.db.Interaction;
import app.initialize.ConfigInstance;
import app.initialize.ParserCollection;
import app.shared.Config;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Trace {

    private final Config config = ConfigInstance.getInstance().getConfig();
    private final List<Parser> parsers;
    private Scanner scanner;
    private File file;
    private final String filePath = String.format("%s%s%s", System.getProperty("user.dir"), File.separator,
        config.getTraceFile());
    private final Interaction interaction;

    public Trace() {
        parsers = new ParserCollection().getList();
        interaction = new Interaction();
        initSqlTraceFile();
        initScanner();
    }

    public void analyze() {
        applyParsers();
        statistics();
    }

    private void applyParsers() {
        var block = new StringBuilder();
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            if (!line.equals(config.getDelimiter())) {
                block.append(line);
            } else {
                for (Parser parser : parsers) {
                    parser.applyTo(block.toString());
                    interaction.save(parser);
                    parser.matches.clear();
                }
                block = new StringBuilder();
            }
        }
        scanner.close();
    }

    private void initScanner() {
        try {
            scanner = new Scanner(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSqlTraceFile() {
        try {
            if (!new File(filePath).exists()) {
                throw new Exception("Can't find sql-trace file.");
            }
            file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void statistics() {
        interaction.perform();
        interaction.finish();
    }
}
