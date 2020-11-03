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
    private final Scanner scanner = new Scanner(new File(config.traceFile));

    public Trace() throws FileNotFoundException { parsers = new ParserInitializer().getList(); }
    public void analyze() { apply(); }

    private void apply() {
        for (Parser parser : parsers) {
            parser.parse();
        }
    }

    private void getBlock() {
        var line = readLineByLine();
        if (!line.equals(config.delimiter)) {
            block.add(readLineByLine());
        }
    }

    private String readLineByLine() {
       if (!scanner.hasNext()) {
           scanner.close();
       }
       return scanner.nextLine();
    }
}
