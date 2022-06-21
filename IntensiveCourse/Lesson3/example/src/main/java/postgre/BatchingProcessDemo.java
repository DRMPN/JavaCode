package postgre;

import java.sql.*;

public class BatchingProcessDemo {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://192.168.239.130:5432/haru";
    static final String USER = "haru";
    static final String PASSWORD = "haru";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        
        String query = "SELECT * FROM developers";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");
            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }

        query = "INSERT INTO developers VALUES (6, 'Ilya', 'Java', 300)";
        statement.addBatch(query);
        query = "INSERT INTO developers VALUES (8, 'Arthur', 'UI/UX', 3000)";
        statement.addBatch(query);
        query = "INSERT INTO developers VALUES (9, 'Alex', 'C++', 2200)";
        statement.addBatch(query);

        statement.executeBatch();
        connection.commit();

        query = "SELECT * FROM developers";
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");
            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
