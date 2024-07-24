package com.ngekost.repository;

import com.ngekost.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Optional<Tenant> findByIdAndIsActiveTrue(Long id);

    Optional<Tenant> findByRoomIdAndIsActiveTrue(Long roomId);

    List<Tenant> findByIsActiveTrue();

    List<Tenant> findByIsActiveFalse();

}
