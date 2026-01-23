package rocha.denis.service.auth;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import rocha.denis.dto.auth.LoginRequestDto;
import rocha.denis.dto.auth.LoginResponseDto;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.dto.auth.RegisterUserResponseDto;
import rocha.denis.exception.LoginValidationException;
import rocha.denis.mapper.user.RegisterUserMapper;
import rocha.denis.service.user.CreateUserService;
import rocha.denis.service.user.FindUserService;
import rocha.denis.validator.auth.AuthValidator;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final FindUserService findUserService;
    private final JwtTokenService jwtTokenService;
    private final CreateUserService createUserService;

    @Override
    @Transactional
    public RegisterUserResponseDto register(RegisterUserRequestDto requestDto) {
        AuthValidator.validateRegisterUserRequestDto(requestDto);

        val user = RegisterUserMapper.toEntity(requestDto);
        val userDto = createUserService.createUser(user);

        return RegisterUserMapper.toResponse(userDto);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        AuthValidator.validateLoginRequestDto(requestDto);
        val user = findUserService.findByUsername(requestDto.getUsername())
            .orElseThrow(LoginValidationException::new);

        if (!BcryptUtil.matches(requestDto.getPassword(), user.getPassword()) || !user.isActive()) {
            throw new LoginValidationException();
        }

        val tokenDto = jwtTokenService.generateToken(user);

        return LoginResponseDto.builder()
            .accessToken(tokenDto.getAccessToken())
            .expiresIn(tokenDto.getExpiresIn())
            .build();
    }
}
