package com.ngekost.repository;

import com.ngekost.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByIdAndIsActiveTrue(Long id);

    List<Room> findByIsActiveTrue();
}
