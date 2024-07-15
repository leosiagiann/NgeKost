package com.ngekost.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Data
public class TenantRequestDTO {
    @NotBlank
    private String fullName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String idNumber;
    private Integer payment;
    @NotNull
    private Long roomId;
}
