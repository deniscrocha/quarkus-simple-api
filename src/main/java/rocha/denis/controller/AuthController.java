package rocha.denis.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import rocha.denis.dto.auth.LoginRequestDto;
import rocha.denis.dto.auth.LoginResponseDto;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.dto.auth.RegisterUserResponseDto;
import rocha.denis.service.auth.AuthService;

@Path("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @POST
    @Path("/register")
    public RegisterUserResponseDto register(RegisterUserRequestDto requestDto) {
        return authService.register(requestDto);
    }

    @POST
    @Path("/login")
    public LoginResponseDto login (LoginRequestDto requestDto) {
        return authService.login(requestDto);
    }
}
