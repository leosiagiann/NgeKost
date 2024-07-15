package com.ngekost.dto.response;

import lombok.Data;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Data
public class GlobalResponseDTO<T> {
    private String status;
    private T data;
}
