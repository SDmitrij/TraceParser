package app.base;

import app.db.Interaction;
import app.shared.Match;

import java.util.List;

public abstract class Parser {

    public Match match;
    private final Interaction interaction;
    protected List<String> blockLines;

    protected Parser() {
        match = new Match();
        interaction = new Interaction(this);
    }

    protected abstract void parse();

    public void to(List<String> blockLines) {
        this.blockLines = blockLines;
        parse();
    }

    protected void write() {
        interaction.save();
        match = new Match();
    }
}
