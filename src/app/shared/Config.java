package app.shared;

import java.util.ArrayList;

public class Config {

    public String traceFile;
    public ArrayList<String> operators;
    public String delimiter;
    public String dbConnection;
    public String outStatFile;

    public String getTraceFile() {
        return traceFile;
    }

    public void setTraceFile(String traceFile) {
        this.traceFile = traceFile;
    }

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

    public String getOutStatFile() {
        return outStatFile;
    }

    public void setOutStatFile(String outStatFile) {
        this.outStatFile = outStatFile;
    }
}
