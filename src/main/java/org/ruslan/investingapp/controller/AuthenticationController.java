package org.ruslan.investingapp.controller;

import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.payload.SignUpRequest;
import org.ruslan.investingapp.service.AuthenticationService;
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
    public JwtResponse signUp(@RequestBody SignUpRequest request) {

    }
}
