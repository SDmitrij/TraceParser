package app;

import app.initialize.ParserInitializer;

public class Main {

    public static void main(String[] args) {
        var parser = new ParserInitializer();
        parser.loop();
        parser.generateStat();
    }
}