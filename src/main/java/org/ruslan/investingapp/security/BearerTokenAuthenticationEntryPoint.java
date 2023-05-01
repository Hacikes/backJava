package org.ruslan.investingapp.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BearerTokenAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final String ERROR_MESSAGE_401 = "Full authentication is required to access this resource";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ERROR_MESSAGE_401);
    }
}
