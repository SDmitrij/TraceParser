package app.db;

import app.base.Parser;
import app.initialize.ConfigInitializer;
import app.shared.Config;
import app.shared.Match;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Interaction {

    private Parser parser;
    private final Connection connection = Connect.getInstance().getConnection();
    private final ObjectMapper mapper = new ObjectMapper();
    private final Config config = ConfigInitializer.getInstance().getConfig();
    private Statement statement;

    public Interaction() { setStatement(); }

    public void save(Parser parser) {
        this.parser = parser;
        insert();
    }

    public void perform() { }

    public void seed() {
        var sql = new StringBuilder();
        for (String operator : config.getOperators()) {
            sql.append(String.format("CREATE TABLE IF NOT EXISTS %s.%s " +
                "(match_id INTEGER PRIMARY KEY, match_obj TEXT NOT NULL);", config.getDatabase(), operator));
        }
        execute(sql.toString());
    }

    private void insert() {
        var sql = new StringBuilder();
        sql.append(String.format("INSERT INTO %s.%s (match_object) VALUES ",
            config.getDatabase(), parser.getClass().getSimpleName()));
        for(Match match : parser.matches) {
            try {
                sql.append(String.format("(%s),", mapper.writeValueAsString(match)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        sql.append(";");
        execute(sql.toString());
    }

    private void select() {

    }

    private void execute(String sql) {
        try {
            statement.execute(sql);
            statement.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
