package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Bind extends Parser {

    public Bind() {
        super();
    }

    @Override
    protected void parse() {
        var pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=BIND:)");
        for (String line : blockLines) {
            if (line.contains("BIND:")) {
                var matcher = pattern.matcher(line);
                if (matcher.find()) {
                    var time = matcher.group();
                    matches.add(new Match().setOperator("Bind").setTime(time));
                }
            }
        }
    }
}
