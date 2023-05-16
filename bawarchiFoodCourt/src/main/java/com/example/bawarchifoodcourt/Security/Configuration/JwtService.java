package com.example.bawarchifoodcourt.Security.Configuration;

import com.example.bawarchifoodcourt.model.SuperAuth;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String createToken(SuperAuth superAuth) {
        var claims= JwtClaimsSet.builder().issuer("self").issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 24))
                .subject(superAuth.getUsername()).claim("scope", createScope(superAuth))
                .build();
        JwtEncoderParameters parameters= JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(SuperAuth superAuth) {
        return superAuth.getAuthorities().stream().map(a-> a.getAuthority()).collect(Collectors.joining(" "));
    }
}
