package com.gespyme.authenticator.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
  private String userId;
  private String email;
  private String password;
  private String role;
  private LocalDateTime lastTimeLoggedIn;
  private LocalDateTime creationDate;
  private LocalDateTime lastModificationDate;
}
