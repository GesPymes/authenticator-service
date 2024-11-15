package com.gespyme.authenticator.application.usecase;

public interface GetTokenUseCase {
  String getToken(String email, String password);
}
