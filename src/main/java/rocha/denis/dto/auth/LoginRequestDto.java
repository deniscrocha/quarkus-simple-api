package rocha.denis.dto.auth;

import lombok.Value;

@Value
public class LoginRequestDto {
    String username;
    String password;
}
