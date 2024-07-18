package com.ngekost.service;

import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.dto.request.UserUpdateRequestDTO;
import com.ngekost.dto.response.UserResponseDTO;
import com.ngekost.entity.User;
import com.ngekost.enums.Role;
import com.ngekost.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> getAllUserRentKeeper() {
        List<User> users = userRepository.findByRoleAndIsActiveTrue(Role.RENT_KEEPER);
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        users.forEach(user -> userResponseDTOs.add(new UserResponseDTO()
                .setId(user.getId())
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setCreatedAt(user.getCreatedAt())
                .setModifiedAt(user.getModifiedAt())));
        return userResponseDTOs;
    }

    public void register(RegisterRequestDTO request) {
        User user = new User()
                .setFirstname(request.getFirstname())
                .setLastname(request.getLastname())
                .setEmail(request.getEmail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRole(Role.RENT_KEEPER);
        userRepository.save(user);
    }

    public void update(Long id, UserUpdateRequestDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (!Objects.equals(user.getRole(), Role.RENT_KEEPER)) {
            throw new RuntimeException("Cannot update OWNER account");
        }
        if (Objects.nonNull(request.getFirstname())) {
            user.setFirstname(request.getFirstname());
        }
        if (Objects.nonNull(request.getLastname())) {
            user.setLastname(request.getLastname());
        }
        if (Objects.nonNull(request.getEmail())) {
            user.setEmail(request.getEmail());
        }
        userRepository.save(user);
    }

}
