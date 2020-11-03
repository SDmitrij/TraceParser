package app.base;

import app.db.Interaction;
import app.shared.Block;
import app.shared.Match;

public abstract class Parser {

    protected Block block;
    public Match match;
    private final Interaction interaction;

    protected Parser() {
        block = new Block();
        match = new Match();
        interaction = new Interaction(this);
    }

    public abstract void parse();
    private void write() {
        interaction.save();
        match = new Match();
    }
}
