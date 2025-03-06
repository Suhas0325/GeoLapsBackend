package com.example.FeedBack.controller;

import com.example.FeedBack.dto.LoginRequest;
import com.example.FeedBack.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticate(loginRequest.getStuId(), loginRequest.getPassword());
        if (token != null) {
            return token; // Return JWT token
        }
        return "Authentication failed"; // Return error message
    }
}