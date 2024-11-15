package com.gespyme.authenticator.application.port.output;

import com.gespyme.authenticator.application.usecase.ValidateTokenUseCase;
import com.gespyme.authenticator.domain.model.Token;
import com.gespyme.authenticator.domain.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateTokenPort implements ValidateTokenUseCase {
  private final TokenRepository repository;

  @Override
  public Token validateToken(Token token) {
    return repository.validateToken(token);
  }
}
