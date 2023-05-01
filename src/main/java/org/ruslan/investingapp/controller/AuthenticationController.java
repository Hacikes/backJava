package org.ruslan.investingapp.controller;

import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.payload.request.SignInRequest;
import org.ruslan.investingapp.payload.request.SignUpRequest;
import org.ruslan.investingapp.payload.response.SignInResponse;
import org.ruslan.investingapp.payload.response.SignUpResponse;
import org.ruslan.investingapp.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        SignUpResponse response = authenticationService.signUp(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {
        SignInResponse response = authenticationService.signIn(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
