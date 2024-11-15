package com.gespyme.authenticator.infrastructure.adapters.output.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APP_USER")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String userId;
  private String email;
  private String password;
  private String role;
  private LocalDateTime lastTimeLoggedIn;
  private LocalDateTime creationDate;
  private LocalDateTime lastModificationDate;
}
