package app.base;

import app.shared.Match;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

    public List<Match> matches;
    protected String block;

    protected Parser() {
        matches = new ArrayList<>();
    }

    public void to(String block) { this.block = block; parse(); }
    protected abstract void parse();
    protected String prepareTimeToConvert(String time) { return time.trim().replace(",", "."); }
}
