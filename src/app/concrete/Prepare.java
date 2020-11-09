package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Prepare extends Parser {

    private final Pattern pattern = Pattern.compile("(?<=PREPARE:)\\s*(\\d+,\\d+)\\s*(?=[)])");
    public Prepare() {
        super();
    }

    @Override
    protected void parse() {
        if (block.contains("PREPARE:")) {
            var matcher = pattern.matcher(block);
            while (matcher.find()) {
                matches.add(new Match()
                    .setOperator("Prepare")
                    .setTime(Double.parseDouble(prepareTimeToConvert(matcher.group()))));
            }
        }
    }
}
