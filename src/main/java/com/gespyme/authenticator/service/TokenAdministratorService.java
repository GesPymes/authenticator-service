package com.gespyme.authenticator.service;

public interface TokenAdministratorService {
    String getToken(String email, String secret);
    boolean validateToken(String email, String token);
}
