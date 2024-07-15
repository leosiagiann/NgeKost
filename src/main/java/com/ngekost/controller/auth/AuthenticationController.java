package com.ngekost.controller.auth;

import com.ngekost.dto.request.AuthenticateRequestDTO;
import com.ngekost.dto.request.RegisterRequestDTO;
import com.ngekost.helper.GlobalResponseHandler;
import com.ngekost.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Leonardo Siagian
 * @date : 7/9/2024
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<?> test() {
        return GlobalResponseHandler.buildSuccessResponse("Test Okay", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO request) {
        return GlobalResponseHandler.buildSuccessResponse(authenticationService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticateRequestDTO request) {
        return GlobalResponseHandler.buildSuccessResponse(authenticationService.login(request), HttpStatus.CREATED);
    }
}
