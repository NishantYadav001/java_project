package com.lms.models;

import java.sql.Timestamp;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private Timestamp enrollmentDate;

    // Getters and setters
    public int getEnrollmentId() {
        return enrollmentId;
    }
    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public Timestamp getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(Timestamp enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
