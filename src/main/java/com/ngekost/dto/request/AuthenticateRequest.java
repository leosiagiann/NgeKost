package com.ngekost.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Data
public class AuthenticateRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
