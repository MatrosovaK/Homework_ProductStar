package org.example;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:students.db";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS students(
                id INTEGER PRIMARY KEY AUTOINCREMENT, 
                gender TEXT NOT NULL,
                race_ethnicity TEXT NOT NULL,
                parental_level_of_education TEXT NOT NULL,
                lunch TEXT NOT NULL,
                test_preparation_course TEXT NOT NULL,
                math_score INTEGER NOT NULL, 
                reading_score INTEGER NOT NULL,
                writing_score INTEGER NOT NULL)
                                
                """;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица students готова.");

        }
    }

    public static int getStudentsCount() throws SQLException{
        String sql = "SELECT COUNT(*) FROM students";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            return 0;
        }
    }



}


