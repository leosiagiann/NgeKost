package com.ngekost.service;

import com.ngekost.dto.request.RoomRequestDTO;
import com.ngekost.dto.request.RoomUpdateRequestDTO;
import com.ngekost.dto.response.RoomResponseDTO;

import java.util.List;

/**
 * @author : Leonardo Siagian
 * @date : 7/20/2024
 */
public interface RoomService {

    List<RoomResponseDTO> getAllRooms();

    RoomResponseDTO getRoomById(Long id);

    void add(RoomRequestDTO request);

    void update(Long id, RoomUpdateRequestDTO request);

    void delete(Long id);

}
