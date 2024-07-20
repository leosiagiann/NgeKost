package com.ngekost.service;

import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.dto.request.UserUpdateRequestDTO;
import com.ngekost.dto.response.UserResponseDTO;

import java.util.List;

/**
 * @author : Leonardo Siagian
 * @date : 7/20/2024
 */
public interface UserService {

    List<UserResponseDTO> getAllUserRentKeeper();

    void register(RegisterRequestDTO request);

    void update(Long id, UserUpdateRequestDTO request);

    void delete(Long id);

}
