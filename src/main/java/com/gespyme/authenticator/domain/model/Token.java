package com.gespyme.authenticator.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Token {
  private String token;
  private Boolean isValid;
  private String userId;
}
