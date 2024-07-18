package com.ngekost.dto.request;

import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/18/2024
 */
@Data
public class RoomUpdateRequestDTO {
    private String roomNumber;
    private Double price;
    private Integer floor;
    private String facilities;
}
