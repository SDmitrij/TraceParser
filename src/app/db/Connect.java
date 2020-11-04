package app.db;

import app.initialize.ConfigInitializer;
import app.shared.Config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final Config config = ConfigInitializer.getInstance().getConfig();
    private static final Connect instance = new Connect();
    private Connection connection;

    private Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") +
                File.separator + config.getDatabase());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connect getInstance() {
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
