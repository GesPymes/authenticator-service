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
  @Column(name = "user_id")
  private String userId;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "role")
  private String role;
  @Column(name = "last_time_logged_in")
  private LocalDateTime lastTimeLoggedIn;
  @Column(name = "creation_date")
  private LocalDateTime creationDate;
  @Column(name = "last_modification_date")
  private LocalDateTime lastModificationDate;
 }
