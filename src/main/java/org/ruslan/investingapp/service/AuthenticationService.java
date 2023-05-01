package org.ruslan.investingapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruslan.investingapp.exception.UserAlreadyExistsException;
import org.ruslan.investingapp.mapper.UserMapper;
import org.ruslan.investingapp.model.Role;
import org.ruslan.investingapp.model.User;
import org.ruslan.investingapp.payload.request.SignInRequest;
import org.ruslan.investingapp.payload.request.SignUpRequest;
import org.ruslan.investingapp.payload.response.SignInResponse;
import org.ruslan.investingapp.payload.response.SignUpResponse;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationProvider provider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final UserMapper mapper;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            String msg = String.format("Email %s already exists", request.getEmail());
            throw new UserAlreadyExistsException(msg);
        }

        User user = mapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.getUserRole();
        user.setRoles(Set.of(role));
        userService.save(user);
        return new SignUpResponse("Registration succeed");
    }

    @Transactional
    public SignInResponse signIn(SignInRequest request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = provider.authenticate(token);
        log.info("{}", authentication.getAuthorities().toString());
        return jwtService.getToken(authentication);
    }
}
