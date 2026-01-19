package rocha.denis.service.auth;

import rocha.denis.domain.entities.User;
import rocha.denis.dto.auth.JwtTokenDto;

public interface JwtTokenService {
    JwtTokenDto generateToken(User user);
}
