package com.roua.roua.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roua.roua.domain.Role;
import com.roua.roua.domain.User;
import com.roua.roua.register.AuthenticationRequest;
import com.roua.roua.register.AuthenticationResponse;
import com.roua.roua.register.RegisterRequest;
import com.roua.roua.repository.UserRepository;
import com.roua.roua.security.utility.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    // private final AuthenticationRequest authenticationRequest;
    // private final AuthenticationResponse authenticationResponse;
    // private final RegisterRequest registerRequest;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        userRepository.save(user);
        String jwtToken = jwtProvider.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String  jwtToken = jwtProvider.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }
}
