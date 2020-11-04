package app.base;

import app.db.Interaction;
import app.shared.Match;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

    public List<Match> match;
    protected List<String> blockLines;
    private final Interaction interaction;

    public void to(List<String> blockLines) {
        this.blockLines = blockLines;
        parse();
    }

    protected Parser() {
        match = new ArrayList<>();
        interaction = new Interaction(this);
    }
    protected abstract void parse();

    protected void write() {
        interaction.save();
        match.clear();
    }
}
