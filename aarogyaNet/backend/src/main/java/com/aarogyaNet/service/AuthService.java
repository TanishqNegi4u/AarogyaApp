package com.aarogyaNet.service;

import com.aarogyaNet.dto.request.LoginRequest;
import com.aarogyaNet.dto.request.RegisterRequest;
import com.aarogyaNet.dto.response.AuthResponse;
import com.aarogyaNet.entity.User;
import com.aarogyaNet.repository.UserRepository;
import com.aarogyaNet.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Change register() signature:
@Transactional
public AuthResponse register(RegisterRequest request) {
    // ... existing code unchanged
}

// Change login() last lookup line:
public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(), request.getPassword()));
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() ->
            new UsernameNotFoundException("User not found: " + request.getEmail()));
    String token = jwtService.generateToken(user);
    return AuthResponse.builder()
        .token(token).userId(user.getId())
        .fullName(user.getFullName())
        .email(user.getEmail()).role(user.getRole())
        .build();
}

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .id(UUID.randomUUID().toString())
            .fullName(request.getFullName())
            .email(request.getEmail())
            .phone(request.getPhone())
            .password(passwordEncoder.encode(request.getPassword()))
            .role("PATIENT")
            .state(request.getState())
            .district(request.getDistrict())
            .village(request.getVillage())
            .preferredLanguage(request.getPreferredLanguage())
            .isActive(true)
            .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
            .token(token).userId(user.getId())
            .fullName(user.getFullName())
            .email(user.getEmail()).role(user.getRole())
            .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
            .token(token).userId(user.getId())
            .fullName(user.getFullName())
            .email(user.getEmail()).role(user.getRole())
            .build();
    }
}