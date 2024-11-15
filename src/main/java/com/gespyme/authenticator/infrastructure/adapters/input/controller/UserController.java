package com.gespyme.authenticator.infrastructure.adapters.input.controller;

import com.gespyme.authenticator.application.usecase.CreateUserUseCase;
import com.gespyme.authenticator.application.usecase.DeleteUserUseCase;
import com.gespyme.authenticator.application.usecase.ModifyUserUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.infrastructure.mapper.UserMapper;
import com.gespyme.commons.model.user.UserModelApi;
import com.gespyme.commons.validator.Validator;
import com.gespyme.commons.validator.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final CreateUserUseCase createUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;
  private final ModifyUserUseCase modifyUserUseCase;
  private final ValidatorService<UserModelApi> validatorService;
  private final UserMapper userMapper;
  
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        validatorService.validateId(userId);
        deleteUserUseCase.deleteUser(userId);
    }

    @PostMapping
    public String createUser(@RequestBody UserModelApi userApiModel) {
        validatorService.validate(userApiModel, List.of(Validator.ALL_PARAMS_NOT_NULL));
        User user = createUserUseCase.createUser(userMapper.map(userApiModel));
        return user.getUserId();
    }

    @PatchMapping("/{userId}")
    public UserModelApi modifyUser(@PathVariable("userId") String userId, @RequestBody UserModelApi userApiModel) {
        validatorService.validate(userApiModel, List.of(Validator.ONE_PARAM_NOT_NULL));
        User user = modifyUserUseCase.modifyUser(userId, userMapper.map(userApiModel));
        return userMapper.map(user);
    }
}
