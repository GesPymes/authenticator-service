package com.gespyme.authenticator.infrastructure.mapper;

import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.infrastructure.adapters.output.model.entities.UserEntity;
import com.gespyme.commons.model.user.UserModelApi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  User map(UserModelApi userApiModel);

  UserModelApi map(User model);

  User map(UserEntity userEntity);

  UserEntity mapToEntity(User user);

  User merge(User newUserData, @MappingTarget User user);
}
