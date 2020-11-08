package app.db;

import app.base.Parser;
import app.initialize.ConfigInitializer;
import app.shared.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interaction {

    private Parser parser;
    private final Connection connection = Connect.getInstance().getConnection();
    private final Config config = ConfigInitializer.getInstance().getConfig();

    public Interaction() {  }

    public void save(Parser parser) {
        this.parser = parser;
        insert();
    }
    public void perform() { select(); }

    public void seed() {
        var sql = "CREATE TABLE IF NOT EXISTS 'matches' ('id' INTEGER PRIMARY KEY, 'operator' TEXT NOT NULL," +
            "'time' REAL NOT NULL);";
        executeUpdate(sql);
    }

    public void clear() {
        var sql = "DELETE FROM 'matches';";
        executeUpdate(sql);
    }

    public void finish() {
        try {
            connection.close();
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

    private void select() {

        for (String operator : config.getOperators()) {
            var sql = (String.format("SELECT SUM(time) AS 'total_time' " +
                    "FROM matches WHERE operator = '%s';", operator));
            var res = executeQuery(sql);
            try {
                if (res == null) return;
                res.next();
                System.out.printf("Total time for %s: %s%n", operator, res.getDouble("total_time"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    private ResultSet executeQuery(String sql) {
        try {
            var stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
