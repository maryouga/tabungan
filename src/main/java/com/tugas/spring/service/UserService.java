package com.tugas.spring.service;

import com.tugas.spring.dto.RegisterRequest;
import com.tugas.spring.entity.UserEntity;
import com.tugas.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}