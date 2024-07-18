package com.ngekost.service;

import com.ngekost.dto.request.RoomRequestDTO;
import com.ngekost.dto.request.RoomUpdateRequestDTO;
import com.ngekost.dto.response.RoomResponseDTO;
import com.ngekost.entity.Room;
import com.ngekost.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomResponseDTO> getAllRooms() {
        List<RoomResponseDTO> responses = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();
        rooms.forEach(room -> {
            RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
            roomResponseDTO.setId(room.getId());
            roomResponseDTO.setRoomNumber(room.getRoomNumber());
            roomResponseDTO.setFloor(room.getFloor());
            roomResponseDTO.setPrice(room.getPrice());
            roomResponseDTO.setFacilities(room.getFacilities());
            roomResponseDTO.setStatus(room.getStatus());
            responses.add(roomResponseDTO);
        });
        return responses;
    }

    public void add(RoomRequestDTO request) {
        roomRepository.save(new Room().builder()
                .roomNumber(request.getRoomNumber())
                .price(request.getPrice())
                .floor(request.getFloor())
                .facilities(request.getFacilities())
                .build());
    }

    public void update(Long id, RoomUpdateRequestDTO request) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        if (Objects.nonNull(request.getRoomNumber())) {
            room.setRoomNumber(request.getRoomNumber());
        }
        if (Objects.nonNull(request.getPrice())) {
            room.setPrice(request.getPrice());
        }
        if (Objects.nonNull(request.getFloor())) {
            room.setFloor(request.getFloor());
        }
        if (Objects.nonNull(request.getFacilities())) {
            room.setFacilities(request.getFacilities());
        }
        roomRepository.save(room);
    }

    public void delete(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        roomRepository.delete(room);
    }

}
