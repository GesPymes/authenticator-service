package com.gespyme.authenticator.service;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenAdministratorServiceImpl implements TokenAdministratorService {

  public String getToken(String email, String password) {
    return TokenCreator.createToken(email);
  }

  public boolean validateToken(String token) {
    return (!isTokenExpired(com.gespyme.authenticator.auth.auth.TokenExtractor.getExpirationDate(token)));
  }

  private boolean isTokenExpired(Date expirationDate) {
    return expirationDate.before(new Date());
  }
}
