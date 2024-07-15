package com.ngekost.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Data
public class RegisterRequestDTO {
    private String firstname;
    private String lastname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String key;
}
