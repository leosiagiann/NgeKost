package com.ngekost.service;

import com.ngekost.dto.request.TenantRequestDTO;
import com.ngekost.dto.request.TenantUpdateRequestDTO;
import com.ngekost.dto.response.TenantResponseDTO;

import java.util.List;

/**
 * @author : Leonardo Siagian
 * @date : 7/20/2024
 */
public interface TenantService {

    List<TenantResponseDTO> getAllTenants();

    List<TenantResponseDTO> getAllHistoryTenants();

    void add(TenantRequestDTO request);

    void update(Long id, TenantUpdateRequestDTO request);

    void delete(Long id);

}
