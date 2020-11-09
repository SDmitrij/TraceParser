package app.initialize;

import app.shared.Config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectInstance {

    private static final Config config = ConfigInstance.getInstance().getConfig();
    private static final ConnectInstance instance = new ConnectInstance();
    private Connection connection;

    public static ConnectInstance getInstance() { return instance; }
    public Connection getConnection() { return connection; }

    private ConnectInstance() {
        try {
            connection = DriverManager
                .getConnection(String.format("jdbc:sqlite:%s%s%s.db",
                    System.getProperty("user.dir"), File.separator, config.getDatabase()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
