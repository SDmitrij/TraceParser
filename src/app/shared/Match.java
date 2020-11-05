package app.shared;

public class Match {

    private String operator;
    private String time;

    public String getOperator() { return operator; }

    public Match setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getTime() { return time; }

    public Match setTime(String time) {
        this.time = time;
        return this;
    }
}
