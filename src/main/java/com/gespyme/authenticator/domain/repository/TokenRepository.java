package com.gespyme.authenticator.domain.repository;

import com.gespyme.authenticator.domain.model.Token;

public interface TokenRepository {
  String getToken(String email, String password);

  Token validateToken(Token token);
}
