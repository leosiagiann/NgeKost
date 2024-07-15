package com.ngekost.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Data
public class TenantResponseDTO {
    private String fullName;
    private String phoneNumber;
    private String idNumber;
    private LocalDateTime lastPayment;
}
