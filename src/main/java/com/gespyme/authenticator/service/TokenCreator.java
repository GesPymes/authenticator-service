package com.gespyme.authenticator.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;

public class TokenCreator {
  /*
      @Value("{jwt.token.validity}") // 60 * 60
      private final int tokenValidity;

      @Value("{jwt.secret.key}") // 60 * 60
      private final String secretKey;
  */
  private static final String password = "GesPyme.uoc.SecureKey.2024!2025__!";

  protected static String createToken(String email) {
    return Jwts.builder()
        .subject(email)
        // .setExpiration(new Date(System.currentTimeMillis() + tokenValidity * 1000))
        .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
        .issuedAt(new Date(System.currentTimeMillis()))
        .signWith(getSigningKey())
        .compact();
  }

  private static SecretKey getSigningKey() {
    byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
