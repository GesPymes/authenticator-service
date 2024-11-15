package com.gespyme.authenticator.infrastructure.adapters.output.repository.jpa;

import com.gespyme.authenticator.infrastructure.adapters.output.model.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorySpringJpa extends JpaRepository<UserEntity, String> {
  Optional<UserEntity> findByEmail(String email);
}
