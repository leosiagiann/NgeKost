package com.ngekost.repository;

import com.ngekost.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
