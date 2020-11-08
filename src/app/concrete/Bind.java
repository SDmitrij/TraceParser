package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Bind extends Parser {

    private final Pattern pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=BIND:)");
    public Bind() { super(); }

    @Override
    protected void parse() {
        if (block.contains("BIND:")) {
            var matcher = pattern.matcher(block);
            while (matcher.find()) {
                matches.add(new Match()
                    .setOperator("Bind")
                    .setTime(Double.parseDouble(prepareTimeToConvert(matcher.group()))));
            }
        }
    }
}
