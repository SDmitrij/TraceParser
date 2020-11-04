package app.initialize;

import app.shared.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigInitializer {

    private static final String
            configFile = System.getProperty("user.dir") + File.separator + "config.json";
    private Config config;
    private static final ConfigInitializer initializer = new ConfigInitializer();

    private ConfigInitializer() { deserialize(); }
    public Config getConfig() { return config; }

    public static ConfigInitializer getInstance() {
        return initializer;
    }

    private void deserialize() {
        try {
            config = new ObjectMapper().readValue(new File(configFile), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
