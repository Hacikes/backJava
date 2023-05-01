package org.ruslan.investingapp.service;

import lombok.RequiredArgsConstructor;
import org.ruslan.investingapp.payload.response.SignInResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtEncoder encoder;

    public SignInResponse getToken(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        Instant expiration = now.plusSeconds(expiry);
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expiration)
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        String token = encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new SignInResponse(token, now, expiration);
    }
}
