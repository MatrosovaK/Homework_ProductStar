package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentImporter {

    public void importStudents(List<Student> students) throws SQLException{
        String sql = "INSERT INTO students (" +
                "gender, race_ethnicity, parental_level_of_education, " +
                "lunch, test_preparation_course, math_score, " +
                "reading_score, writing_score) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for (Student student : students) {

                statement.setString(1, student.getGender());
                statement.setString(2, student.getRaceEthnicity());
                statement.setString(3, student.getParentalLevelOfEducation());
                statement.setString(4, student.getLunch());
                statement.setString(5, student.getTestPreparationCourse());
                statement.setInt(6, student.getMathScore());
                statement.setInt(7, student.getReadingScore());
                statement.setInt(8, student.getWritingScore());

                statement.addBatch();
            }

            statement.executeBatch();
        }


    }
}
