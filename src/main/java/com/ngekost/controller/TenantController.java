package com.ngekost.controller;

import com.ngekost.dto.request.TenantRequestDTO;
import com.ngekost.helper.GlobalResponseHandler;
import com.ngekost.service.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@RestController
@RequestMapping("/api/v1/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @GetMapping
    public ResponseEntity<?> getAllTenants() {
        return GlobalResponseHandler.buildSuccessResponse(tenantService.getAllTenants(), HttpStatus.OK);
    }

    @PostMapping
    public void add(@RequestBody @Valid TenantRequestDTO request) {
        tenantService.add(request);
    }
}
