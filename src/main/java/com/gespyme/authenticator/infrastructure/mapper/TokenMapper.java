package com.gespyme.authenticator.infrastructure.mapper;

import com.gespyme.authenticator.domain.model.Token;
import com.gespyme.commons.model.auth.TokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING)
public interface TokenMapper {
  Token map(TokenEntity tokenEntity);
}
