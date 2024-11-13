package com.gespyme.authenticator.repository;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
  private String userId;
  private String email;
  private String password;
  private String role;
  private LocalDateTime lastTimeLoggedIn;
  private LocalDateTime creationDate;
  private LocalDateTime lastModificationDate;
}
