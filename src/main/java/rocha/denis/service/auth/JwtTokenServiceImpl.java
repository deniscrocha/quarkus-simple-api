package rocha.denis.service.auth;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.val;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.enumerated.Roles;
import rocha.denis.dto.auth.JwtTokenDto;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;

@ApplicationScoped
public class JwtTokenServiceImpl implements JwtTokenService {

    // TODO: Move this to application.yml
    private static final String ISSUER = "QUARKUS-SIMPLE-API";

    @Override
    public JwtTokenDto generateToken(User user) {
        val issuedAt = Instant.now();
        val duration = Duration.ofHours(1L);

        val token = Jwt.issuer(ISSUER)
            .claim("id", user.getId())
            .groups(new HashSet<>(List.of(Roles.USER.getName())))
            .upn(user.getUsername())
            .issuedAt(issuedAt)
            .expiresIn(duration)
            .sign();

        return new JwtTokenDto(token, duration.toSeconds());
    }
}
