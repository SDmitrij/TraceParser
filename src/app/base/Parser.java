package app.base;

import app.shared.Match;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

    public List<Match> matches;
    protected List<String> blockLines;

    public void to(List<String> blockLines) {
        this.blockLines = blockLines;
        parse();
    }

    protected Parser() {
        matches = new ArrayList<>();
    }
    protected abstract void parse();
}
