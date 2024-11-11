package com.gespyme.authenticator.controller;

import com.gespyme.authenticator.auth.model.TokenResponse;
import com.gespyme.authenticator.auth.model.UserAccountDetails;
import com.gespyme.authenticator.service.TokenAdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AtuhenticatorController {
    private final TokenAdministratorService service;

    @PostMapping
    private ResponseEntity<TokenResponse> getToken(@RequestBody UserAccountDetails userAccountDetailsModelApi) {
        String token = service.getToken(userAccountDetailsModelApi.getEmail(), userAccountDetailsModelApi.getPassword());
        return ResponseEntity.ok(TokenResponse.builder().token(token).build());
    }

    @GetMapping("/validate")
    private ResponseEntity<TokenResponse> validateToken(@RequestParam String email, @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        boolean isValid = service.validateToken(token, email);
        return ResponseEntity.ok(TokenResponse.builder().isValid(isValid).build());
    }
}
