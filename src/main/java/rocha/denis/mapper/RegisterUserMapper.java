package rocha.denis.mapper;

import io.quarkus.elytron.security.common.BcryptUtil;
import lombok.experimental.UtilityClass;
import rocha.denis.domain.entities.User;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.dto.auth.RegisterUserResponseDto;

@UtilityClass
public class RegisterUserMapper {

    public User toEntity(RegisterUserRequestDto requestDto) {
        return User.builder()
            .username(requestDto.getUsername())
            .email(requestDto.getEmail())
            .password(BcryptUtil.bcryptHash(requestDto.getPassword()))
            .build();
    }

    public RegisterUserResponseDto toResponse(User user) {
        return RegisterUserResponseDto.builder()
            .id(user.getId())
            .email(user.getEmail())
            .username(user.getUsername())
            .build();
    }
}
