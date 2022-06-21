package postgre;

import java.sql.*;

public class DevelopersJdbcDemo {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://192.168.239.130:5432/haru";
    static final String USER = "haru";
    static final String PASSWORD = "haru";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        
        statementDemo();
        preparedStatementDemo();
    }

    private static void statementDemo() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM developers";

        ResultSet result = statement.executeQuery(query);

        System.out.println("\nStatement query: ");

        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String specialty = result.getString("specialty");
            int salary = result.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }

        result.close();
        statement.close();
        connection.close();
    }

    private static void preparedStatementDemo() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String query = "Update developers SET salary=? WHERE specialty=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 3000);
        preparedStatement.setString(2, "Java");
        preparedStatement.executeUpdate();

        query = "SELECT * FROM developers";
        preparedStatement = connection.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();

        System.out.println("\nPrepared statement query: ");

        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String specialty = result.getString("specialty");
            int salary = result.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: " + salary);
        }

        result.close();
        preparedStatement.close();
        connection.close();
    }

}