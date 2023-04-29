package org.ruslan.investingapp.service;

import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.payload.JwtResponse;
import org.ruslan.investingapp.payload.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;

    public JwtResponse signUp(SignUpRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            String msg = String.format("Email %s already exists", userRequest.getEmail());
            throw new UserAlreadyExistsException(msg);
        }

        if (userService.existsByUsername(request.getUsername())) {
            String msg = String.format("Username %s already exists", request.getUsername());
            throw new UserAlreadyExistsException(msg);
        }

        User user = mapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(defaultRole);
        user = userService.save(user);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
