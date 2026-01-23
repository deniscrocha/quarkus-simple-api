package rocha.denis.service.user;

import rocha.denis.domain.entities.User;

import java.util.Optional;

public interface FindUserService {
    Optional<User> findByUsername(String username);
}
