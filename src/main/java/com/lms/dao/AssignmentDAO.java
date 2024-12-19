package com.lms.dao;

import com.lms.models.Assignment;
import com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDAO {

    // Retrieve all assignments
    public List<Assignment> getAllAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        String query = "SELECT * FROM assignments";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setAssignmentId(resultSet.getInt("assignment_id"));
                assignment.setCourseId(resultSet.getInt("course_id"));
                assignment.setTitle(resultSet.getString("title"));
                assignment.setDescription(resultSet.getString("description"));
                assignment.setDueDate(resultSet.getDate("due_date"));
                assignments.add(assignment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    // Add a new assignment
    public boolean addAssignment(Assignment assignment) {
        String query = "INSERT INTO assignments (course_id, title, description, due_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, assignment.getCourseId());
            statement.setString(2, assignment.getTitle());
            statement.setString(3, assignment.getDescription());
            statement.setDate(4, new java.sql.Date(assignment.getDueDate().getTime()));
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete an assignment
    public boolean deleteAssignment(int assignmentId) {
        String query = "DELETE FROM assignments WHERE assignment_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, assignmentId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
