package com.lms.dao;

import com.lms.models.Submission;
import com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubmissionDAO {

    // Retrieve all submissions
    public List<Submission> getAllSubmissions() {
        List<Submission> submissions = new ArrayList<>();
        String query = "SELECT * FROM submissions";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Submission submission = new Submission();
                submission.setSubmissionId(resultSet.getInt("submission_id"));
                submission.setAssignmentId(resultSet.getInt("assignment_id"));
                submission.setStudentId(resultSet.getInt("student_id"));
                submission.setSubmissionDate(resultSet.getTimestamp("submission_date"));
//                submission.setGrade(resultSet.getInt("grade"));
                submissions.add(submission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return submissions;
    }

    // Add a new submission
    public boolean addSubmission(Submission submission) {
        String query = "INSERT INTO submissions (assignment_id, student_id, submission_date) VALUES (?, ?, ?)";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, submission.getAssignmentId());
            statement.setInt(2, submission.getStudentId());
            statement.setTimestamp(3, new Timestamp(submission.getSubmissionDate().getTime()));
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update submission grade
    public boolean updateSubmissionGrade(int submissionId, int grade) {
        String query = "UPDATE submissions SET grade = ? WHERE submission_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, grade);
            statement.setInt(2, submissionId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a submission
    public boolean deleteSubmission(int submissionId) {
        String query = "DELETE FROM submissions WHERE submission_id = ?";

        try (Connection connection = jdbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, submissionId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
