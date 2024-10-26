package com.lms.service;

import com.lms.model.Student;

public class StudentService {
    public void registerStudent(Student student) {
        // Logic to save the student to the database (e.g., call DAO)
        System.out.println("Student registered: " + student.getName());
        // In a real application, you would interact with a DAO here to save the student
    }
}
