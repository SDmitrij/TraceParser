package app.shared;

import java.util.ArrayList;

public class Block {

    public ArrayList<String> lines;

    public void add(String line) { this.lines.add(line); }

    public void clear() { this.lines.clear(); }
}
