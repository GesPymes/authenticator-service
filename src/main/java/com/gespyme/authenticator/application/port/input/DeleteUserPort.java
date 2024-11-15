package com.gespyme.authenticator.application.port.input;

import com.gespyme.authenticator.application.usecase.DeleteUserUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.commons.exeptions.NotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserPort implements DeleteUserUseCase {
  private final UserRepository repository;

  public void deleteUser(String userId) {
    Optional<User> user = repository.getUserById(userId);
    if (user.isEmpty()) {
      throw new NotFoundException("User " + userId + " not found");
    }
    repository.deleteById(userId);
  }
}
