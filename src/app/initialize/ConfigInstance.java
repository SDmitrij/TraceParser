package app.initialize;

import app.shared.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigInstance {

    private static final String
        configFile = System.getProperty("user.dir") + File.separator + "config.json";
    private Config config;
    private static final ConfigInstance initializer = new ConfigInstance();

    private ConfigInstance() { deserialize(); }
    public Config getConfig() { return config; }

    public static ConfigInstance getInstance() {
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
