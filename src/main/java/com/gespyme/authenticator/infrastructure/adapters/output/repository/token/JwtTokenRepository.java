package com.gespyme.authenticator.infrastructure.adapters.output.repository.token;

import com.gespyme.authenticator.auth.TokenExtractor;
import com.gespyme.authenticator.domain.model.Token;
import com.gespyme.authenticator.domain.repository.TokenRepository;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class JwtTokenRepository implements TokenRepository {

  public String getToken(String email, String role) {
    return TokenCreator.createToken(email, role);
  }

  @Override
  public Token validateToken(Token token) {
    boolean isValid = TokenExtractor.getExpirationDate(token.getToken()).before(new Date());
    return token.toBuilder().isValid(isValid).build();
  }
}
