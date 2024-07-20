package com.ngekost.service;

import com.ngekost.dto.request.AuthenticateRequestDTO;
import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.dto.response.AuthenticationResponseDTO;

/**
 * @author : Leonardo Siagian
 * @date : 7/20/2024
 */
public interface AuthenticationService {

    AuthenticationResponseDTO register(RegisterRequestDTO request);
    
    AuthenticationResponseDTO login(AuthenticateRequestDTO request);

}
