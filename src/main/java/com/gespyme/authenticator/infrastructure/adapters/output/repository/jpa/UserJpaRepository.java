package com.gespyme.authenticator.infrastructure.adapters.output.repository.jpa;

import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.authenticator.infrastructure.adapters.output.model.entities.UserEntity;
import com.gespyme.authenticator.infrastructure.mapper.UserMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepository implements UserRepository {

  private final UserRepositorySpringJpa userRepositorySpringJpa;
  private final UserMapper mapper;

  @Override
  public void deleteById(String id) {
    userRepositorySpringJpa.deleteById(id);
  }

  @Override
  public Optional<User> getUserById(String id) {
    return userRepositorySpringJpa.findById(id).map(mapper::map);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    Optional<UserEntity> userEntity = userRepositorySpringJpa.findByEmail(email);
    return userEntity.map(mapper::map);
  }

  @Override
  public User save(User user) {
    UserEntity userEntity = userRepositorySpringJpa.save(mapper.mapToEntity(user));
    return mapper.map(userEntity);
  }

  @Override
  public User merge(User newUserData, User user) {
    User merged = mapper.merge(newUserData, user);
    UserEntity savedEntity = userRepositorySpringJpa.save(mapper.mapToEntity(merged));
    return mapper.map(savedEntity);
  }
}
