package app.entity;

import app.base.Parser;
import app.initialize.ConfigInitializer;
import app.initialize.ParserInitializer;
import app.shared.Block;
import app.shared.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Trace {

    private final Block block = new Block();
    private final Config config = new ConfigInitializer().getConfig();
    private final List<Parser> parsers;
    private final Scanner scanner;

    public Trace() throws FileNotFoundException {
        parsers = new ParserInitializer().getList();
        scanner = new Scanner(new File(System.getProperty("user.dir") + "\\SQLTrace.log"));
    }

    public void analyze() {
        apply();
        generateStat();
    }

    private void apply() {
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            if (!line.equals(config.getDelimiter())) {
                block.add(line);
            } else {
                for (Parser parser : parsers) {
                    parser.to(block.getLines());
                }
                block.clear();
            }
        }
        scanner.close();
    }

    private void generateStat() {

    }
}
