package com.ngekost.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Data
@Builder
public class AuthenticationResponse {
    private String token;
}
