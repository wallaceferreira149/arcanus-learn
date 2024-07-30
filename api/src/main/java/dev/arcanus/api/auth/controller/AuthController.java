package dev.arcanus.api.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arcanus.api.auth.useCases.AuthenticationUseCase;

@RestController
public class AuthController {

    private final AuthenticationUseCase authenticationUseCase;

    public AuthController(
            AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    @PostMapping("authenticate")
    public String authenticate(Authentication authentication) {

        return authenticationUseCase.authenticate(authentication);
    }

}
