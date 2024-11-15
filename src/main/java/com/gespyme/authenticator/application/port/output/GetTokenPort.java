package com.gespyme.authenticator.application.port.output;

import com.gespyme.authenticator.application.usecase.GetTokenUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.TokenRepository;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.commons.exeptions.BadRequestException;
import com.gespyme.commons.exeptions.NotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetTokenPort implements GetTokenUseCase {
  private final UserRepository userRepository;
  private final TokenRepository tokenRepository;

  @Override
  public String getToken(String email, String password) {
    Optional<User> foundUser = userRepository.getUserByEmail(email);
    if (foundUser.isEmpty()) {
      throw new NotFoundException("User " + userRepository + " not found");
    }
    if (!foundUser.get().getPassword().equals(password)) {
      throw new BadRequestException("Password not valid");
    }

    return tokenRepository.getToken(email, foundUser.get().getRole());
  }
}
