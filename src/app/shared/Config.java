package app.shared;

import java.util.ArrayList;

public class Config {

    private ArrayList<String> operators;
    private String delimiter;
    private String database;

    public ArrayList<String> getOperators() {
        return operators;
    }
    public void setOperators(ArrayList<String> operators) {
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
