package com.gespyme.authenticator.application.port.input;

import com.gespyme.authenticator.application.usecase.CreateUserUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.commons.exeptions.BadRequestException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserPort implements CreateUserUseCase {
  private final UserRepository repository;

  public User createUser(User user) {
    Optional<User> foundUser = repository.getUserByEmail(user.getEmail());
    if (foundUser.isPresent()) {
      throw new BadRequestException("User " + user.getEmail() + " already exists");
    }
    return repository.save(user);
  }
}
