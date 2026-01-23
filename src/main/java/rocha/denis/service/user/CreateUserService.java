package rocha.denis.service.user;

import rocha.denis.domain.entities.User;
import rocha.denis.dto.user.UserDto;

public interface CreateUserService {
    UserDto createUser(User user);
}
