package rocha.denis.mapper.userrole;

import lombok.experimental.UtilityClass;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.entities.UserRole;
import rocha.denis.domain.enumerated.Role;

@UtilityClass
public class UserRoleMapper {
    public UserRole toUserRole(User user, Role role) {
        return UserRole.builder()
            .user(user)
            .role(role)
            .isActive(true)
            .build();
    }
}
