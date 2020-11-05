package app.db;

import app.base.Parser;
import app.initialize.ConfigInitializer;
import app.shared.Config;
import app.shared.Match;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

public class Interaction {

    private Parser parser;
    private final Connection connection = Connect.getInstance().getConnection();
    private final Config config = ConfigInitializer.getInstance().getConfig();

    public Interaction() {  }

    public void save(Parser parser) {
        this.parser = parser;
        insert();
    }

    public void perform() { }

    public void seed() {
        var sql = "CREATE TABLE IF NOT EXISTS 'matches' ('id' INTEGER PRIMARY KEY, 'operator' TEXT NOT NULL," +
            "'time' TEXT NOT NULL);";
        executeUpdate(sql);
    }

    private void executeUpdate(String sql) {
        try {
            var stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() {
        if(parser.matches.isEmpty()) return;
        var sql = new StringBuilder();
        sql.append("INSERT INTO 'matches' ('operator', 'time') VALUES ");

        var matches = parser.matches.iterator();
        while(matches.hasNext()) {
            var match = matches.next();
            sql.append(String.format("('%s', '%s')%s", match.getOperator(), match.getTime(),
                matches.hasNext() ? "," : ";"));
        }

        executeUpdate(sql.toString());
    }

    private void select() { }
}
