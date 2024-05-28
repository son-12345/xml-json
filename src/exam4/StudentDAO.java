package exam4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Student")) {

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getDate("DOB"))); // Use java.sql.Date directly
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
