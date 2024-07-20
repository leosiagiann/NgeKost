package com.ngekost.service.impl;

import com.ngekost.dto.request.AuthenticateRequestDTO;
import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.dto.response.AuthenticationResponseDTO;
import com.ngekost.entity.User;
import com.ngekost.enums.Role;
import com.ngekost.repository.UserRepository;
import com.ngekost.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        if (Objects.nonNull(request.getKey()) && Objects.equals(request.getKey(), "coba")) {
            User user = new User()
                    .setFirstname(request.getFirstname())
                    .setLastname(request.getLastname())
                    .setEmail(request.getEmail())
                    .setPassword(passwordEncoder.encode(request.getPassword()))
                    .setRole(Role.OWNER);
            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            return AuthenticationResponseDTO.builder()
                    .token(jwtToken)
                    .build();
        }
        return AuthenticationResponseDTO.builder().build();
    }

    @Override
    public AuthenticationResponseDTO login(AuthenticateRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmailAndIsActiveTrue(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
