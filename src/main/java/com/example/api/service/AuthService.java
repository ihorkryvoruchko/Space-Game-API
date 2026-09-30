package com.example.api.service;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String name, String rawPassword) {
        if (userRepository.existsByName(name)) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = User.builder()
                .name(name)
                .password(passwordEncoder.encode(rawPassword))
                .build();

        return userRepository.save(user);
    }
}