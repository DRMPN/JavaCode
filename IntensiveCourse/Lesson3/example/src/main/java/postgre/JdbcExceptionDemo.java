package postgre;

import java.sql.*;

public class JdbcExceptionDemo {

    final static String JDBC_DRIVER = "org.postgresql.Driver";
    final static String DATABASE_URL = "jdbc:postgresql://192.168.239.130:5432/haru";
    final static String USER = "haru";
    final static String PASSWORD = "haru";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String query = "SELECT * FROM developers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
