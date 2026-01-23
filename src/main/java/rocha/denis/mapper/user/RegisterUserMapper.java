package rocha.denis.mapper.user;

import io.quarkus.elytron.security.common.BcryptUtil;
import lombok.experimental.UtilityClass;
import rocha.denis.domain.entities.User;
import rocha.denis.dto.auth.RegisterUserRequestDto;
import rocha.denis.dto.auth.RegisterUserResponseDto;
import rocha.denis.dto.user.UserDto;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public class RegisterUserMapper {

    public User toEntity(RegisterUserRequestDto requestDto) {
        return User.builder()
            .username(requestDto.getUsername())
            .email(requestDto.getEmail())
            .password(BcryptUtil.bcryptHash(requestDto.getPassword()))
            .roles(List.of())
            .isActive(true)
            .creationDate(LocalDateTime.now())
            .modificationDate(LocalDateTime.now())
            .build();
    }

    public RegisterUserResponseDto toResponse(UserDto dto) {
        return RegisterUserResponseDto.builder()
            .id(dto.getId())
            .email(dto.getEmail())
            .username(dto.getUsername())
            .build();
    }
}
