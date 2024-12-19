package com.lms.dao;

import com.lms.models.Grade;
import com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    // Retrieve all grades
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM grades";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setGradeId(resultSet.getInt("grade_id"));
                grade.setSubmissionId(resultSet.getInt("submission_id"));
                grade.setGrade(resultSet.getInt("grade"));
                grade.setFeedback(resultSet.getString("feedback"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    // Add a new grade
    public boolean addGrade(Grade grade) {
        String query = "INSERT INTO grades (submission_id, grade, feedback) VALUES (?, ?, ?)";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, grade.getSubmissionId());
//            statement.setInt(2, grade.getGrade());
            statement.setString(3, grade.getFeedback());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update grade details
    public boolean updateGrade(Grade grade) {
        String query = "UPDATE grades SET grade = ?, feedback = ? WHERE grade_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

//            statement.setInt(1, grade.getGrade());
            statement.setString(2, grade.getFeedback());
            statement.setInt(3, grade.getGradeId());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a grade
    public boolean deleteGrade(int gradeId) {
        String query = "DELETE FROM grades WHERE grade_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, gradeId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
