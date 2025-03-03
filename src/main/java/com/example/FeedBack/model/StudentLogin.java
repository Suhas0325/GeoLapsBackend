package com.example.FeedBack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_login")
public class StudentLogin {

    @Id
    @Column(name = "stu_id", length = 20)
    private String stuId;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and Setters
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}