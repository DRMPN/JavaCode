package application;

import java.sql.*;

import com.zaxxer.hikari.HikariDataSource;

public class DataSourceFactory {
    private static HikariDataSource source;

    static {
        source = new HikariDataSource();
        source.setMaximumPoolSize(5);
        source.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        source.addDataSourceProperty("url", "jdbc:postgresql://192.168.239.130:5432/haru");
		source.addDataSourceProperty("user", "haru");
		source.addDataSourceProperty("password", "haru");
    }

    private DataSourceFactory() {}

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
