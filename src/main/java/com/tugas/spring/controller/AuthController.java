package com.tugas.spring.controller;


import com.tugas.spring.dto.LoginRequest;
import com.tugas.spring.dto.RegisterRequest;
import com.tugas.spring.security.JwtUtil;
import com.tugas.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        return jwtUtil.generateToken(request.getUsername());
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return "User registered successfully";
    }
}
