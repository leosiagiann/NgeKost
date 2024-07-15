package com.ngekost.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Data
public class RoomRequestDTO {
    @NotBlank
    private String roomNumber;
    @NotNull
    private Double price;
    @NotNull
    private Integer floor;
    private String facilities;
}
