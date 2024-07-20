package com.ngekost.service.impl;

import com.ngekost.dto.request.TenantRequestDTO;
import com.ngekost.dto.response.TenantResponseDTO;
import com.ngekost.entity.Room;
import com.ngekost.entity.Tenant;
import com.ngekost.repository.TenantRepository;
import com.ngekost.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public List<TenantResponseDTO> getAllTenants() {
        List<Tenant> tenants = tenantRepository.findAll();
        List<TenantResponseDTO> tenantResponsDTOS = new ArrayList<>();
        tenants.forEach(tenant -> {
            TenantResponseDTO tenantResponseDTO = new TenantResponseDTO();
            tenantResponseDTO.setFullName(tenant.getFullName());
            tenantResponseDTO.setIdNumber(tenant.getIdNumber());
            tenantResponseDTO.setPhoneNumber(tenant.getPhoneNumber());
            tenantResponseDTO.setLastPayment(tenant.getLastPayment());
            tenantResponsDTOS.add(tenantResponseDTO);
        });
        return tenantResponsDTOS;
    }

    @Override
    public void add(TenantRequestDTO request) {
        LocalDateTime now = LocalDateTime.now();
        if (Objects.nonNull(request.getPayment()) && request.getPayment() > 0) {
            now = now.plusMonths(request.getPayment());
        }
        tenantRepository.save(new Tenant()
                .setRoom(Room.builder().id(request.getRoomId()).build())
                .setFullName(request.getFullName())
                .setPhoneNumber(request.getPhoneNumber())
                .setIdNumber(request.getIdNumber())
                .setLastPayment(now));
    }

}
