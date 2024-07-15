package com.ngekost.dto.response;

import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Data
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private Double price;
    private Integer floor;
    private String facilities;
    private String status;
}
