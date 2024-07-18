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

    @PostMapping
    public void add(@RequestBody @Valid RoomRequestDTO request) {
        roomService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid RoomUpdateRequestDTO request) {
        roomService.update(id, request);
    }
}
