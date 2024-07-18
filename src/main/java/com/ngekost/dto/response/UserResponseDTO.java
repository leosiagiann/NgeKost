package com.ngekost.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author : Leonardo Siagian
 * @date : 7/19/2024
 */
@Data
@Accessors(chain = true)
public class UserResponseDTO {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
