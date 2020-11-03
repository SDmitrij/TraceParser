package app.shared;

import java.util.ArrayList;

public class Config {

    private ArrayList<String> operators;
    private String delimiter;
    private String dbConnection;

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
    public String getDbConnection() {
        return dbConnection;
    }
    public void setDbConnection(String dbConnection) {
        this.dbConnection = dbConnection;
    }
}
