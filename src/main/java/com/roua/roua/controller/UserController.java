package com.roua.roua.controller;

import org.springframework.web.bind.annotation.RestController;

import com.roua.roua.register.AuthenticationRequest;
import com.roua.roua.register.AuthenticationResponse;
import com.roua.roua.register.RegisterRequest;
import com.roua.roua.service.AuthenticationService;
import com.roua.roua.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService service;
    private final UserService userService;

    @PostMapping(value="/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(value="/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        
        return ResponseEntity.ok(service.authenticate(request));
    }
    @GetMapping("/test")
    public String hello(){
        return "hi there";
    }



    @GetMapping("/all")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("All users");
    }



    
    
    
}
