package app.base;

import app.shared.Match;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

    public List<Match> matches;
    protected String block;

    public void to(String block) {
        this.block = block;
        parse();
    }

    protected Parser() {
        matches = new ArrayList<>();
    }
    protected abstract void parse();
}
