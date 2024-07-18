package com.ngekost.dto.request;

import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/18/2024
 */
@Data
public class UserUpdateRequestDTO {
    private String firstname;
    private String lastname;
    private String email;
}
