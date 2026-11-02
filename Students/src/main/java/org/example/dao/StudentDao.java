package org.example.dao;

import org.example.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> findAll() throws SQLException;

    List<Student> findPreparedStudents() throws SQLException;

    List<Student> findByMathScore(int score) throws SQLException;

    List<Student> findByGender(String gender) throws SQLException;

    List<Student> findByRaceEthnicity(String race) throws SQLException;
}
