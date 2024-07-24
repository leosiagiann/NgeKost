package com.ngekost.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Leonardo Siagian
 * @date : 7/24/2024
 */
@Data
public class TenantUpdateRequestDTO {
    private String fullName;
    private String phoneNumber;
    private String idNumber;
    private Integer addRoomPeriod;
    private Long roomId;
}
