package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Select extends Parser {

    private final Pattern pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=[(])");
    public Select() {
        super();
    }

    @Override
    protected void parse() {
        if (block.contains("SELECT")) {
            var matcher = pattern.matcher(block);
            while (matcher.find()) {
                matches.add(new Match()
                    .setOperator("Select")
                    .setTime(Double.parseDouble(prepareTime(matcher.group()))));
            }
        }
    }
}
