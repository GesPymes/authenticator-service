package com.gespyme.authenticator.application.usecase;

import com.gespyme.authenticator.domain.model.Token;

public interface ValidateTokenUseCase {
  Token validateToken(Token token);
}
