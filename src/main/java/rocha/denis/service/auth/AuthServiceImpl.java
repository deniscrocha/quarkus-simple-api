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
import rocha.denis.mapper.RegisterUserMapper;
import rocha.denis.repository.UserRepository;
import rocha.denis.validator.auth.AuthValidator;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    @Override
    @Transactional
    public RegisterUserResponseDto register(RegisterUserRequestDto requestDto) {
        AuthValidator.validateRegisterUserRequestDto(requestDto);
        val user = RegisterUserMapper.toEntity(requestDto);
        userRepository.persist(user);

        return RegisterUserMapper.toResponse(user);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        AuthValidator.validateLoginRequestDto(requestDto);
        val user = userRepository.findByUsername(requestDto.getUsername())
            .orElseThrow(LoginValidationException::new);

        if(!BcryptUtil.matches(requestDto.getPassword(), user.getPassword()))
            throw new LoginValidationException();

        val tokenDto = jwtTokenService.generateToken(user);

        return LoginResponseDto.builder()
            .accessToken(tokenDto.getAccessToken())
            .expiresIn(tokenDto.getExpiresIn())
            .build();
    }
}
