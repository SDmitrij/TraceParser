package app.shared;

public class Match {

    private String operator;
    private Double time;

    public String getOperator() { return operator; }

    public Match setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Double getTime() { return time; }

    public Match setTime(Double time) {
        this.time = time;
        return this;
    }
}
