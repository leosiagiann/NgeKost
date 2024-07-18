package com.ngekost.repository;

import com.ngekost.entity.User;
import com.ngekost.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndIsActiveTrue(String email);

    Optional<User> findByIdAndIsActiveTrue(Long id);

    List<User> findByRoleAndIsActiveTrue(Role role);
}
