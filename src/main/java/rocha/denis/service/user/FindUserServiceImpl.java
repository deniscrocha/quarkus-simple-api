package rocha.denis.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import rocha.denis.domain.entities.User;
import rocha.denis.repository.UserRepository;

import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
