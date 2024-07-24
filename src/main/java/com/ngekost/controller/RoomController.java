package com.ngekost.controller;

import com.ngekost.dto.request.RoomRequestDTO;
import com.ngekost.dto.request.RoomUpdateRequestDTO;
import com.ngekost.helper.GlobalResponseHandler;
import com.ngekost.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Leonardo Siagian
 * @date : 7/15/2024
 */
@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<?> getAllRooms() {
        return GlobalResponseHandler.buildSuccessResponse(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/empty")
    public ResponseEntity<?> getAllEmptyRooms() {
        return GlobalResponseHandler.buildSuccessResponse(roomService.getAllEmptyRooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        return GlobalResponseHandler.buildSuccessResponse(roomService.getRoomById(id), HttpStatus.OK);
    }

    @PostMapping
    public void add(@RequestBody @Valid RoomRequestDTO request) {
        roomService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RoomUpdateRequestDTO request) {
        roomService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
