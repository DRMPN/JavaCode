package application;

import java.sql.*;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceFactory {
    private static HikariDataSource source;
    private static HikariConfig config;

    static {

        Properties props = new Properties();
        
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGPoolingDataSource");
        props.setProperty("url", "jdbc:postgresql://192.168.239.130:5432/haru");
        props.setProperty("dataSource.user", "haru");
        props.setProperty("dataSource.password", "haru");

        config = new HikariConfig(props);
        source = new HikariDataSource(config);
    }

    private DataSourceFactory() {}

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
