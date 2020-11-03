package app.db;

import app.initialize.ConfigInitializer;
import app.shared.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final Config config = new ConfigInitializer().getConfig();
    private static Connection connection;
    private static Connect instance;

    private Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + config.getDbConnection());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }
}
