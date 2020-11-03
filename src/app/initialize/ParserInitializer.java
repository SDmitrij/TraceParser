package app.initialize;

import app.base.Parser;
import app.shared.Config;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParserInitializer {

    private final Config config = new ConfigInitializer().getConfig();
    private final List<Parser> parsers = new ArrayList<>();

    public ParserInitializer() { init(); }
    public List<Parser> getList() {
        return parsers;
    }

    private void init() {
        try {
            for (String operator : config.getOperators()) {
                parsers.add((Parser)Class.forName("app.concrete." + operator).getDeclaredConstructor().newInstance());
            }
        } catch (InstantiationException
                | NoSuchMethodException
                | ClassNotFoundException
                | InvocationTargetException
                | IllegalAccessException e) { e.printStackTrace(); }
    }
}
