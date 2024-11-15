package com.gespyme.authenticator.domain.repository;

import com.gespyme.authenticator.domain.model.User;
import java.util.Optional;

public interface UserRepository {
  void deleteById(String id);

  Optional<User> getUserById(String id);

  Optional<User> getUserByEmail(String email);

  User save(User user);

  User merge(User newUser, User user);
}
