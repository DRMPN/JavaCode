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
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "haru");
        props.setProperty("dataSource.password", "haru");
        props.setProperty("dataSource.databaseName", "haru");

        config = new HikariConfig(props);
        source = new HikariDataSource(config);
    }

    private DataSourceFactory() {}

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
