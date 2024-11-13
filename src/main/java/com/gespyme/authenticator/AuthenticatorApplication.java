package com.gespyme.authenticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.gespyme.rest","com.gespyme.authenticator"})
//@ComponentScan(basePackages = "com.gespyme.security")
public class AuthenticatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthenticatorApplication.class, args);
  }
}
