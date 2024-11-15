package com.gespyme.authenticator.application.port.input;

import com.gespyme.authenticator.application.usecase.ModifyUserUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.commons.exeptions.NotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyUserPort implements ModifyUserUseCase {
  private final UserRepository repository;

  public User modifyUser(String userId, User newUserData) {
    Optional<User> user = repository.getUserById(userId);
    if (user.isEmpty()) {
      throw new NotFoundException("User " + userId + " not found");
    }
    return repository.merge(newUserData, user.get());
  }
}
