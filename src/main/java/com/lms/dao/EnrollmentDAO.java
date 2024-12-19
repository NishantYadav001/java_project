package com.lms.dao;

import com.lms.models.Enrollment;
import com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    // Retrieve all enrollments
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM enrollments";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setEnrollmentId(resultSet.getInt("enrollment_id"));
                enrollment.setStudentId(resultSet.getInt("student_id"));
                enrollment.setCourseId(resultSet.getInt("course_id"));
                enrollment.setEnrollmentDate(resultSet.getTimestamp("enrollment_date"));
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

    // Add a new enrollment
    public boolean addEnrollment(Enrollment enrollment) {
        String query = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, enrollment.getStudentId());
            statement.setInt(2, enrollment.getCourseId());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete an enrollment
    public boolean deleteEnrollment(int enrollmentId) {
        String query = "DELETE FROM enrollments WHERE enrollment_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, enrollmentId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
