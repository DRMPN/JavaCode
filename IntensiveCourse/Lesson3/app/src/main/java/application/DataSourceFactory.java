package application;

import java.sql.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceFactory {
    private static HikariDataSource source;
    private static HikariConfig config;

    static {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://192.168.239.130:5432/haru");
        config.setUsername("haru");
        config.setPassword("haru");
        source = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
