package rocha.denis.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RegisterUserRequestDto {
    String username;
    String password;
    String email;
}
