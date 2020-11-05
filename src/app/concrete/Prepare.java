package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Prepare extends Parser {

    public Prepare() {
        super();
    }

    @Override
    protected void parse() {
        var pattern = Pattern.compile("(?<=PREPARE:)\\s*(\\d+,\\d+)\\s*(?=[)])");
        for (String line : blockLines) {
            if (line.contains("PREPARE:")) {
                var matcher = pattern.matcher(line);
                if (matcher.find()) {
                    var time = matcher.group();
                    matches.add(new Match().setOperator("Prepare").setTime(time));
                }
            }
        }
    }
}
