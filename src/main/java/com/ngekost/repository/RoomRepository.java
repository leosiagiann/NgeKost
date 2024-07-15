package com.ngekost.repository;

import com.ngekost.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
}
