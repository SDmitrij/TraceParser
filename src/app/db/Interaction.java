package app.db;

import app.base.Parser;
import app.shared.Match;

public class Interaction {
    private final Parser parser;
    private String name;

    public Interaction(Parser parser) {
        this.parser = parser;
        this.name = parser.getClass().getName();
    }

    public void save() {
        insert();
    }
    public void perform() {

    }

    private void insert() {

    }

    private void select() {

    }
}
