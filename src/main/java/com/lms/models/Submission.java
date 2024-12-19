package com.lms.models;

import java.sql.Timestamp;

public class Submission {
    private int submissionId;
    private int assignmentId;
    private int studentId;
    private Timestamp submissionDate;
    private String fileUrl;

    // Getters and setters
    public int getSubmissionId() {
        return submissionId;
    }
    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }
    public int getAssignmentId() {
        return assignmentId;
    }
    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public Timestamp getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
