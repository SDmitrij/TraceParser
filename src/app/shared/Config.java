package app.shared;

import java.util.List;

public class Config {

    private List<String> operators;
    private String delimiter;
    private String database;

    public List<String> getOperators() {
        return operators;
    }
    public void setOperators(List<String> operators) {
        this.operators = operators;
    }
    public String getDelimiter() {
        return delimiter;
    }
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    public String getDatabase() {
        return database;
    }
    public void setDatabase(String database) {
        this.database = database;
    }
}
