package rocha.denis.mapper.user;

import lombok.experimental.UtilityClass;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.enumerated.Role;
import rocha.denis.dto.user.UserDto;

import java.util.List;

@UtilityClass
public class UserMapper {

    public UserDto toUserDto(User user) {
        return toUserDto(user, List.of());
    }

    public UserDto toUserDto(User user, List<Role> roles) {
        return UserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .creationDate(user.getCreationDate())
            .modificationDate(user.getModificationDate())
            .roles(roles)
            .build();
    }
}
