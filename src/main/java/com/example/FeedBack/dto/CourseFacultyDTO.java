package com.example.FeedBack.dto;

public class CourseFacultyDTO {
    private String courseName;
    private String facultyName;

    // Default constructor (required for JSON serialization/deserialization)
    public CourseFacultyDTO() {
    }

    // Parameterized constructor
    public CourseFacultyDTO(String courseName, String facultyName) {
        this.courseName = courseName;
        this.facultyName = facultyName;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "CourseFacultyDTO{" +
                "courseName='" + courseName + '\'' +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}