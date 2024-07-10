package com.ngekost.helper;

import com.ngekost.dto.response.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
public class GlobalResponseHandler {
    public static <T> ResponseEntity<GlobalResponse<T>> buildSuccessResponse(T data, HttpStatus httpStatus, Map<String, Object> additionalInfo) {
        if (additionalInfo != null && !additionalInfo.isEmpty()) {
            if (data instanceof Map) { // Check if data is already a Map
                ((Map<String, Object>) data).putAll(additionalInfo);
            } else {
                // If data is not a Map, you might need to create a wrapper object
                Map<String, Object> wrappedData = new HashMap<>();
                wrappedData.put("originalData", data);
                wrappedData.putAll(additionalInfo);
                data = (T) wrappedData; // Cast back to the original type (may need a type-safe approach)
            }
        }

        GlobalResponse<T> response = new GlobalResponse<>();
        response.setStatus("success");
        response.setData(data);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static <T> ResponseEntity<GlobalResponse<T>> buildSuccessResponse(T data, HttpStatus httpStatus) {
        return buildSuccessResponse(data, httpStatus, null);
    }

    public static <T> ResponseEntity<GlobalResponse<Map<String, Object>>> buildErrorResponse(String message, HttpStatus httpStatus, Map<String, Object> additionalInfo) {
        Map<String, Object> errorData = new HashMap<>();
        errorData.put("errorMessage", message);

        if (additionalInfo != null && !additionalInfo.isEmpty()) {
            errorData.putAll(additionalInfo);
        }

        GlobalResponse<Map<String, Object>> response = new GlobalResponse<>();
        response.setStatus("error");
        response.setData(errorData);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static <T> ResponseEntity<GlobalResponse<Map<String, Object>>> buildErrorResponse(String message, HttpStatus httpStatus) {
        return buildErrorResponse(message, httpStatus, null);
    }
}
