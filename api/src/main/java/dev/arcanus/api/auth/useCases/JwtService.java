package dev.arcanus.api.auth.useCases;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import dev.arcanus.api.auth.entities.User;
import dev.arcanus.api.auth.repositories.UserRepository;

@Service
public class JwtService {

    private final JwtEncoder encoder;
    private final UserRepository userRepository;

    public JwtService(JwtEncoder encoder, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        Instant now = Instant.now();
        long expiration = 360L;
        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("arcanus-learning")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiration))
                .subject(user.get().getId().toString())
                .claim("scopes", scopes)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
