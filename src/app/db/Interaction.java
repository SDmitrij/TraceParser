package app.db;

import app.base.Parser;
import app.shared.Match;

import java.sql.Connection;

public class Interaction {

    private final Parser parser;
    private Connection connection;
    private String name;

    public Interaction(Parser parser) {
        this.parser = parser;
        this.connection = Connect.getInstance().getConnection();
        this.name = parser.getClass().getSimpleName();
    }

    public void save() { insert(); }
    public void perform() {

    }

    private void insert() {

    }

    private void select() {

    }
}
