package com.gespyme.authenticator.application.usecase;

import com.gespyme.authenticator.domain.model.User;

public interface CreateUserUseCase {
  User createUser(User user);
}
