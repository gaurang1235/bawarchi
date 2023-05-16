package com.example.bawarchirestaurant.Security.Configuration;

import com.example.bawarchirestaurant.model.Auth;
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

    public String createToken(Auth auth) {
        var claims= JwtClaimsSet.builder().issuer("self").issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 24))
                .subject(auth.getUsername()).claim("scope", createScope(auth))
                .build();
        JwtEncoderParameters parameters= JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Auth auth) {
        return auth.getAuthorities().stream().map(a-> a.getAuthority()).collect(Collectors.joining(" "));
    }
}
