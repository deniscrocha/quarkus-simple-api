package rocha.denis.service.auth;

import rocha.denis.dto.auth.LoginRequestDto;
import rocha.denis.dto.auth.LoginResponseDto;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.dto.auth.RegisterUserResponseDto;

public interface AuthService {
    RegisterUserResponseDto register(RegisterUserRequestDto requestDto);
    LoginResponseDto login (LoginRequestDto requestDto);
}
