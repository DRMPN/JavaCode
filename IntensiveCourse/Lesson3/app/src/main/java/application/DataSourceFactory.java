package application;

import java.sql.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceFactory {
    private static HikariDataSource source;
    private static HikariConfig config;

    private static String configFile = "../resources/database.properties";

    static {
        config = new HikariConfig(configFile);
        source = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
