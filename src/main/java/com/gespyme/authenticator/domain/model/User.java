package com.gespyme.authenticator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private String userId;
  private String email;
  private String password;
  private String role;
  private LocalDateTime lastTimeLoggedIn;
  private LocalDateTime creationDate;
  private LocalDateTime lastModificationDate;
}
