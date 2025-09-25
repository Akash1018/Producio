package com.producio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producio.backend.model.User;
import com.producio.backend.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        service.registerUser(user);
        return ResponseEntity.ok("It is working");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        boolean res = service.validateUser(user);
        if(res) {
            return ResponseEntity.ok("Login Complete");
        }
        return ResponseEntity.ok("Invalid email");
    }
    
}
