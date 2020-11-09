package app.initialize;

import app.shared.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigInstance {

    private Config config;
    private File file;
    private final String filePath = System.getProperty("user.dir") + File.separator + "config.json";
    private static final ConfigInstance initializer = new ConfigInstance();

    private ConfigInstance() {
        initConfigFile();
        deserialize();
    }
    public Config getConfig() { return config; }

    public static ConfigInstance getInstance() {
        return initializer;
    }

    private void deserialize() {
        try {
            config = new ObjectMapper().readValue(file, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initConfigFile() {
        try {
            if (!new File(filePath).exists()) {
                throw new Exception("Can't find config file.");
            }
            file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
