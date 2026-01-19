package rocha.denis.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class JwtTokenDto {
    String accessToken;
    Long expiresIn;
}
