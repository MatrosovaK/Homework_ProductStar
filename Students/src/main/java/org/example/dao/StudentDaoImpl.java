
package org.example.dao;

import org.example.DatabaseManager;
import org.example.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public List<Student> findAll() throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                students.add(mapStudent(resultSet));
            }
        }

        return students;
    }


    @Override
    public List<Student> findPreparedStudents() throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE test_preparation_course = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "completed");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapStudent(resultSet));
                }
            }
        }

        return students;
    }


    @Override
    public List<Student> findByMathScore(int score) throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE math_score > ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, score);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapStudent(resultSet));
                }
            }
        }

        return students;
    }


    @Override
    public List<Student> findByGender(String gender) throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE gender = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, gender);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapStudent(resultSet));
                }
            }
        }

        return students;
    }


    @Override
    public List<Student> findByRaceEthnicity(String race) throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE race_ethnicity = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, race);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapStudent(resultSet));
                }
            }
        }

        return students;
    }


    private Student mapStudent(ResultSet resultSet) throws SQLException {

        return new Student(
                resultSet.getString("gender"),
                resultSet.getString("race_ethnicity"),
                resultSet.getString("parental_level_of_education"),
                resultSet.getString("lunch"),
                resultSet.getString("test_preparation_course"),
                resultSet.getInt("math_score"),
                resultSet.getInt("reading_score"),
                resultSet.getInt("writing_score")
        );
    }
}
