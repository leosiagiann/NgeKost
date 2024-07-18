package com.ngekost.controller.user;

import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.dto.request.UserUpdateRequestDTO;
import com.ngekost.helper.GlobalResponseHandler;
import com.ngekost.service.UserService;
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
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> test() {
        return GlobalResponseHandler.buildSuccessResponse("Test Okay", HttpStatus.OK);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequestDTO request) {
        userService.register(request);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDTO request) {
        userService.update(id, request);
    }
}
