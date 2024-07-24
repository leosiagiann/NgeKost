package com.ngekost.service.impl;

import com.ngekost.dto.request.TenantRequestDTO;
import com.ngekost.dto.request.TenantUpdateRequestDTO;
import com.ngekost.dto.response.TenantResponseDTO;
import com.ngekost.entity.Tenant;
import com.ngekost.repository.RoomRepository;
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
    private final RoomRepository roomRepository;

    @Override
    public List<TenantResponseDTO> getAllTenants() {
        List<Tenant> tenants = tenantRepository.findByIsActiveTrue();
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
    public List<TenantResponseDTO> getAllHistoryTenants() {
        List<Tenant> tenants = tenantRepository.findByIsActiveFalse();
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
        roomRepository.findByIdAndIsActiveTrue(request.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Tenant tenantExists = tenantRepository.findByRoomIdAndIsActiveTrue(request.getRoomId()).orElse(null);
        if (Objects.nonNull(tenantExists)) {
            throw new RuntimeException("Room already have a tenant");
        }
        tenantRepository.save(new Tenant()
                .setRoomId(request.getRoomId())
                .setFullName(request.getFullName())
                .setPhoneNumber(request.getPhoneNumber())
                .setIdNumber(request.getIdNumber())
                .setLastPayment(now));
    }

    @Override
    public void update(Long id, TenantUpdateRequestDTO request) {
        Tenant tenant = tenantRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new RuntimeException("Tenant not found"));
        if (Objects.nonNull(request.getFullName())) {
            tenant.setFullName(request.getFullName());
        }
        if (Objects.nonNull(request.getPhoneNumber())) {
            tenant.setPhoneNumber(request.getPhoneNumber());
        }
        if (Objects.nonNull(request.getRoomId())) {
            roomRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new RuntimeException("Room not found"));
            Tenant tenantExists = tenantRepository.findByRoomIdAndIsActiveTrue(request.getRoomId()).orElse(null);
            if (Objects.nonNull(tenantExists)) {
                throw new RuntimeException("Room already have a tenant");
            }
            tenant.setRoomId(request.getRoomId());
        }
        if (Objects.nonNull(request.getAddRoomPeriod())) {
            if (Objects.isNull(tenant.getLastPayment())) {
                throw new RuntimeException("Last payment is null");
            }
            tenant.setLastPayment(tenant.getLastPayment().plusMonths(request.getAddRoomPeriod()));
        }
        tenantRepository.save(tenant);
    }

    @Override
    public void delete(Long id) {
        Tenant tenant = tenantRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new RuntimeException("Tenant not found"));
        tenant.setActive(Boolean.FALSE);
        tenantRepository.save(tenant);
    }

}
