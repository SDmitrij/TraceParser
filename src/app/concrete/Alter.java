package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Alter extends Parser {

    private final Pattern pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=OK)");
    public Alter() {
        super();
    }

    @Override
    protected void parse() {
        var lines = blockLines.iterator();
        while(lines.hasNext()) {
            var line = lines.next();
            if (line.contains("ALTER")) {
                var selectStat = lines.next();
                var matcher = pattern.matcher(selectStat);
                if (matcher.find()) {
                    var time = matcher.group().trim().replace(",", ".");
                    matches.add(new Match().setOperator("Alter").setTime(Double.parseDouble(time)));
                }
            }
        }
    }
}
