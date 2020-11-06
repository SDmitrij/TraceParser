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

    public static Connect getInstance() { return instance; }
    public Connection getConnection() { return connection; }

    private Connect() {
        try {
            connection = DriverManager
                .getConnection(String.format("jdbc:sqlite:%s%s%s.db",
                    System.getProperty("user.dir"), File.separator, config.getDatabase()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
