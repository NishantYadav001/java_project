package com.lms;

import com.lms.controller.StudentController;
import com.lms.model.Student;
import com.lms.service.StudentService;

public class Main {
    public static void main(String[] args) {
        // Create instances
        StudentService studentService = new StudentService();
        StudentController studentController = new StudentController(studentService);

        // Create a new student
        Student student = new Student("John Doe", "john.doe@example.com");

        // Register the student and print the result
        String result = studentController.registerStudent(student);
        System.out.println(result);
    }
}
