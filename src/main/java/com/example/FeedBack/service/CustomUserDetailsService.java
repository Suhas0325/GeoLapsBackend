package com.example.FeedBack.service;

import com.example.FeedBack.model.StudentLogin;
import com.example.FeedBack.repository.StudentLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentLoginRepository studentLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String stuId) throws UsernameNotFoundException {
        StudentLogin studentLogin = studentLoginRepository.findByStuId(stuId);
        if (studentLogin == null) {
            throw new UsernameNotFoundException("User not found with stuId: " + stuId);
        }
        return new org.springframework.security.core.userdetails.User(
                studentLogin.getStuId(),
                studentLogin.getPassword(),
                new ArrayList<>()
        );
    }
}