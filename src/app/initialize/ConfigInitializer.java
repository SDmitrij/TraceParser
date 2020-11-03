package app.initialize;

import app.shared.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigInitializer {

    private static final String configFile = System.getProperty("user.dir") + "\\src\\app\\config.json";
    private Config config;

    public ConfigInitializer() { serialize(); }
    public Config getConfig() { return config; }

    private void serialize() {
        try {
            config = new ObjectMapper().readValue(new File(configFile), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
