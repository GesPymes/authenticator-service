package com.gespyme.authenticator.controller;

import com.gespyme.authenticator.service.TokenAdministratorService;
import com.gespyme.commons.model.auth.TokenEntity;
import com.gespyme.commons.model.auth.UserAccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AtuhenticatorController {
  private final TokenAdministratorService service;

  @PostMapping
  private ResponseEntity<TokenEntity> getToken(
      @RequestBody UserAccountDetails userAccountDetailsModelApi) {
    String token =
        service.getToken(
            userAccountDetailsModelApi.getEmail(), userAccountDetailsModelApi.getPassword());
    return ResponseEntity.ok(TokenEntity.builder().token(token).build());
  }

  @PostMapping("/validate")
  private ResponseEntity<TokenEntity> validateToken(@RequestBody TokenEntity tokenEntity) {
    boolean isValid = service.validateToken(tokenEntity.getToken());
    return ResponseEntity.ok(TokenEntity.builder().isValid(isValid).build());
  }
}
