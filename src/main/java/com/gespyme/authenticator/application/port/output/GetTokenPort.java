package com.gespyme.authenticator.application.port.output;

import com.gespyme.authenticator.application.usecase.GetTokenUseCase;
import com.gespyme.authenticator.domain.model.User;
import com.gespyme.authenticator.domain.repository.TokenRepository;
import com.gespyme.authenticator.domain.repository.UserRepository;
import com.gespyme.commons.exeptions.BadRequestException;
import com.gespyme.commons.exeptions.ForbiddenException;
import com.gespyme.commons.exeptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetTokenPort implements GetTokenUseCase {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    @Override
    public String getToken(String email, String password) {
    Optional<User> foundUser = userRepository.getUserByEmail(email);
    if (foundUser.isEmpty()) {
      throw new NotFoundException("User " + email + " not found");
    }
    if (!foundUser.get().getPassword().equals(password)) {
      throw new ForbiddenException("Password not valid");
    }

    return tokenRepository.getToken(email, foundUser.get().getRole());

    }
/*
 private String testToken(String email) {
        return tokenRepository.getToken(email, "ADMIN");
    }

    private void saveUsersToTest(String email) {
        userRepository.save(User.builder()
                .lastTimeLoggedIn(LocalDateTime.now())
                .lastModificationDate(LocalDateTime.now())
                .email(email)
                .password("a")
                .role("ADMIN")
                .creationDate(LocalDateTime.now())
                .build());
        userRepository.save(User.builder()
                .lastTimeLoggedIn(LocalDateTime.now())
                .lastModificationDate(LocalDateTime.now())
                .email("user@mail.com")
                .password("a")
                .role("USER")
                .creationDate(LocalDateTime.now())
                .build());
    }
 */
}
