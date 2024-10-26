package com.lms.controller;

import com.lms.exception.ValidationException;
import com.lms.model.Student;
import com.lms.service.StudentService;

public class StudentController {
    private StudentService studentService;

    // Constructor for dependency injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Method to register a student
    public String registerStudent(Student student) {
        try {
            // Validate student data
            validateStudent(student);
            
            // Call the service to register the student
            studentService.registerStudent(student);
            
            // Return success message or redirect to a success page
            return "Registration successful!";
        } catch (ValidationException e) {
            // Handle validation errors
            return "Registration failed: " + e.getMessage();
        } catch (Exception e) {
            // Handle other exceptions
            return "An error occurred during registration: " + e.getMessage();
        }
    }

    // Method to validate student data
    private void validateStudent(Student student) throws ValidationException {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new ValidationException("Student name cannot be empty.");
        }
        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new ValidationException("Invalid email address.");
        }
        // Add more validations as necessary
    }
}
