package rocha.denis.service.auth;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.val;
import rocha.denis.config.JwtConfigMap;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.entities.UserRole;
import rocha.denis.domain.enumerated.Role;
import rocha.denis.dto.auth.JwtTokenDto;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;

@ApplicationScoped
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtConfigMap jwtConfigMap;

    @Override
    public JwtTokenDto generateToken(User user) {
        val issuedAt = Instant.now();
        val duration = Duration.ofHours(jwtConfigMap.tokenDurationHours());

        val token = Jwt.issuer(jwtConfigMap.issuer())
            .claim("id", user.getId())
            .groups(new HashSet<>(
                user.getRoles().stream().map(UserRole::getRole).map(Role::getName).toList()
            ))
            .upn(user.getUsername())
            .issuedAt(issuedAt)
            .expiresIn(duration)
            .sign();

        return new JwtTokenDto(token, duration.toSeconds());
    }
}
