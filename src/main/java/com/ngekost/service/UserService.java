package com.ngekost.service;

import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.entity.User;
import com.ngekost.enums.Role;
import com.ngekost.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequestDTO request) {
        User user = new User()
                .setFirstname(request.getFirstname())
                .setLastname(request.getLastname())
                .setEmail(request.getEmail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRole(Role.RENT_KEEPER);
        userRepository.save(user);
    }

}
