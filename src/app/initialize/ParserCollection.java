package app.initialize;

import app.base.Parser;
import app.shared.Config;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParserCollection {

    private final Config config = ConfigInstance.getInstance().getConfig();
    private final List<Parser> parsers = new ArrayList<>();

    public ParserCollection() { init(); }
    public List<Parser> getList() {
        return parsers;
    }

    private void init() {
        try {
            for (String operator : config.getOperators()) {
                parsers.add((Parser)Class.forName(String.format("app.concrete.%s", operator))
                    .getDeclaredConstructor().newInstance());
            }
        } catch (InstantiationException
                | NoSuchMethodException
                | ClassNotFoundException
                | InvocationTargetException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
