package rocha.denis.validator.auth;

import lombok.experimental.UtilityClass;
import rocha.denis.dto.auth.LoginRequestDto;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.exception.LoginValidationException;
import rocha.denis.exception.ValidationException;

import static java.util.Objects.isNull;

@UtilityClass
public class AuthValidator {

    private static final Integer MAX_SIZE = 255;

    public void validateRegisterUserRequestDto(RegisterUserRequestDto requestDto) {
        if (isNull(requestDto) || isNullOrMaxSize(requestDto.getUsername())) {
            throw new ValidationException("Username", "Invalid username");
        }
        if (isNullOrMaxSize(requestDto.getEmail())) {
            throw new ValidationException("Email", "Invalid email");
        }
        if (isNullOrMaxSize(requestDto.getPassword())) {
            throw new ValidationException("Password", "Invalid password");
        }
    }

    public void validateLoginRequestDto(LoginRequestDto requestDto) {
        if (isNull(requestDto) || isNull(requestDto.getUsername()) || isNull(requestDto.getPassword())) {
            throw new LoginValidationException();
        }
    }

    private boolean isNullOrMaxSize(String field) {
        if (isNull(field)) return true;
        return field.length() >= AuthValidator.MAX_SIZE;
    }
}
