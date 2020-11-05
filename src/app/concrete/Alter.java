package app.concrete;

import app.base.Parser;
import app.shared.Match;

import java.util.regex.Pattern;

public class Alter extends Parser {

    public Alter() {
        super();
    }

    @Override
    protected void parse() {
        var pattern = Pattern.compile("(?<=TIME:)\\s*(\\d+,\\d+)\\s*(?=OK)");
        var lines = blockLines.iterator();
        while(lines.hasNext()) {
            var line = lines.next();
            if (line.contains("ALTER")) {
                var selectStat = lines.next();
                var matcher = pattern.matcher(selectStat);
                if (matcher.find()) {
                    var time = matcher.group();
                    matches.add(new Match().setOperator("Alter").setTime(time));
                }
            }
        }
    }
}
