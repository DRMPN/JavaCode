package application;

import java.sql.*;
import java.util.*;


public class DaoStudent implements StudentDao{

    private DaoStudent() {}

    private static class SingletonHelper {
        private static final DaoStudent INSTANCE = new DaoStudent();
    }

    public static DaoStudent getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<Student> find(String id) throws SQLException {
        int studentId = 0;
        String lastName = "";
        String firstName = "";

        String query = "SELECT * from sudents where student_id = ?";
        Connection connection = DataSourceFactory.getConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            studentId = resultSet.getInt("student_id");
            lastName = resultSet.getString("last_name");
            firstName = resultSet.getString("first_name");
        }

        return Optional.of(new Student(studentId, lastName, firstName));
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> listStudent = new ArrayList<>();

        String query = "SELECT * FROM students";
        Connection connection = DataSourceFactory.getConnection();
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("student_id");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");

            Student student = new Student(id, lastName, firstName);
            listStudent.add(student);
        }

        return listStudent;
    }

    @Override
    public boolean save(Student student) throws SQLException {
        String query = "INSERT INTO students (last_name, first_name) VALUES (?, ?)";
        boolean rowInserted = false;
        
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
       
        preparedStatement.setString(1, student.getLastName());
        preparedStatement.setString(2, student.getLastName());
        rowInserted = preparedStatement.executeUpdate() > 0;

        return rowInserted;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        String query = "UPDATE students SET last_name = ?, first_name = ? WHERE student_id = ?";
        boolean rowUpdated = false;

        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, student.getLastName());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setInt(3, student.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
    }

    @Override
    public boolean delete(Student student) throws SQLException {
        String query = "DELETE FROM students WHERE student_id = ?";
        boolean rowDeleted = false;

        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, student.getId());
        rowDeleted = preparedStatement.executeUpdate() > 0;

        return rowDeleted;
    }

}
