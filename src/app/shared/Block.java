package app.shared;

import java.util.ArrayList;
import java.util.List;

public class Block {

    private final List<String> lines = new ArrayList<>();

    public void add(String line) { this.lines.add(line); }
    public List<String> getLines() { return lines; }
    public void clear() { this.lines.clear(); }
}
