package com.gespyme.authenticator.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
