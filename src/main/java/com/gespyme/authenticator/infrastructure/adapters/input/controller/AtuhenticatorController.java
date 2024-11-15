package com.gespyme.authenticator.infrastructure.adapters.input.controller;

import com.gespyme.authenticator.application.usecase.GetTokenUseCase;
import com.gespyme.authenticator.application.usecase.ValidateTokenUseCase;
import com.gespyme.authenticator.domain.model.Token;
import com.gespyme.authenticator.infrastructure.mapper.TokenMapper;
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
  private final GetTokenUseCase getTokenUseCase;
  private final ValidateTokenUseCase validateTokenUseCase;
  private final TokenMapper tokenMapper;

  @PostMapping
  private ResponseEntity<TokenEntity> getToken(
      @RequestBody UserAccountDetails userAccountDetailsModelApi) {
    String token =
        getTokenUseCase.getToken(
            userAccountDetailsModelApi.getEmail(), userAccountDetailsModelApi.getPassword());
    return ResponseEntity.ok(TokenEntity.builder().token(token).build());
  }

  @PostMapping("/validate")
  private ResponseEntity<TokenEntity> validateToken(@RequestBody TokenEntity tokenEntity) {
    Token token = validateTokenUseCase.validateToken(tokenMapper.map(tokenEntity));
    return ResponseEntity.ok(TokenEntity.builder().isValid(token.getIsValid()).build());
  }
}
