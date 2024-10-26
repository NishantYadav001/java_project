package com.lms.model;

public class Student {
    private String name;
    private String email;

    // Constructor
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
