package com.example.FeedBack.controller; // Updated package

import com.example.FeedBack.model.Student; // Updated import
import com.example.FeedBack.service.StudentService; // Updated import
import com.example.FeedBack.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/me")
    public  Student getStudentDetails(@RequestHeader("Authorization") String token){
        String jwtToken = token.substring(7);
        String stuId = jwtUtil.extractUsername(jwtToken);

        return  studentService.getStudentByStuId(stuId);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}