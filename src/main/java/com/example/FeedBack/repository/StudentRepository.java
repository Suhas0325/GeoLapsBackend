package com.example.FeedBack.repository;


import com.example.FeedBack.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}