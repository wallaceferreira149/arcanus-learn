package dev.arcanus.api.auth.useCases;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUseCase {

    private final JwtService jwtService;

    public AuthenticationUseCase(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
