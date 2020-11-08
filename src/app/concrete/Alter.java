package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Alter extends Parser {

    private static final Pattern pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=OK)");
    public Alter() {
        super();
    }

    @Override
    protected void parse() {
        if (block.contains("ALTER")) {
            var matcher = pattern.matcher(block);
            while (matcher.find()) {
                matches.add(new Match()
                    .setOperator("Alter")
                    .setTime(Double.parseDouble(prepareTimeToConvert(matcher.group()))));
            }
        }
    }
}
