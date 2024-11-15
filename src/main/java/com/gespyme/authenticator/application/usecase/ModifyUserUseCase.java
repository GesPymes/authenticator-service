package com.gespyme.authenticator.application.usecase;

import com.gespyme.authenticator.domain.model.User;

public interface ModifyUserUseCase {
  User modifyUser(String userId, User newUserData);
}
