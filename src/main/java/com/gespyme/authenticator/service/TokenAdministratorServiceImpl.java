package com.gespyme.authenticator.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenAdministratorServiceImpl implements TokenAdministratorService {

    private static final String password = "GesPyme.uoc.SecureKey.2024!2025__!";

    /*
     @Value("{jwt.token.validity}") // 60 * 60
     private final int tokenValidity;

     @Value("{jwt.secret.key}") // 60 * 60
     private final String secretKey;
 */
    public String getToken(String email, String password) {
        return Jwts.builder()
                .subject(email)
                //.setExpiration(new Date(System.currentTimeMillis() + tokenValidity * 1000))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey()).compact();
    }

    public boolean validateToken(String token, String username) {
        Claims tokenExtracted = extractClaim(token);
        return (tokenExtracted.getSubject().equals(username) && !isTokenExpired(tokenExtracted.getExpiration()));
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractClaim(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(Date expirationDate) {
        return expirationDate.before(new Date());
    }

}
