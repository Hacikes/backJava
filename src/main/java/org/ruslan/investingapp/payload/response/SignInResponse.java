package org.ruslan.investingapp.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class SignInResponse {

    private String token;
    private Instant createdAt;
    private Instant expiresAt;
}
