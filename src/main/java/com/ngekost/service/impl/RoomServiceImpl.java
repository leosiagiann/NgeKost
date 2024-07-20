package com.ngekost.service.impl;

import com.ngekost.dto.request.RoomRequestDTO;
import com.ngekost.dto.request.RoomUpdateRequestDTO;
import com.ngekost.dto.response.RoomResponseDTO;
import com.ngekost.entity.Room;
import com.ngekost.repository.RoomRepository;
import com.ngekost.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<RoomResponseDTO> getAllRooms() {
        List<RoomResponseDTO> responses = new ArrayList<>();
        List<Room> rooms = roomRepository.findByIsActiveTrue();
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

    @Override
    public RoomResponseDTO getRoomById(Long id) {
        Room room = roomRepository.findByIdAndIsActiveTrue(id).orElse(null);
        if (Objects.isNull(room)) {
            return null;
        }
        RoomResponseDTO responseDTO = new RoomResponseDTO();
        responseDTO.setId(room.getId());
        responseDTO.setRoomNumber(room.getRoomNumber());
        responseDTO.setFloor(room.getFloor());
        responseDTO.setPrice(room.getPrice());
        responseDTO.setFacilities(room.getFacilities());
        responseDTO.setStatus(room.getStatus());
        return responseDTO;
    }

    @Override
    public void add(RoomRequestDTO request) {
        roomRepository.save(new Room().builder()
                .roomNumber(request.getRoomNumber())
                .price(request.getPrice())
                .floor(request.getFloor())
                .facilities(request.getFacilities())
                .build());
    }

    @Override
    public void update(Long id, RoomUpdateRequestDTO request) {
        Room room = roomRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new RuntimeException("Room not found"));
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

    @Override
    public void delete(Long id) {
        Room room = roomRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setActive(Boolean.FALSE);
        roomRepository.save(room);
    }

}
