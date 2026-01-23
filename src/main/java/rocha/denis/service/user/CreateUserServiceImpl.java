package rocha.denis.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.enumerated.Role;
import rocha.denis.dto.user.UserDto;
import rocha.denis.mapper.user.UserMapper;
import rocha.denis.repository.UserRepository;
import rocha.denis.service.userrole.AssignUserRoleService;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;
    private final AssignUserRoleService assignUserRoleService;

    private static final List<Role> BASIC_ROLES = List.of(Role.USER);

    @Override
    @Transactional
    public UserDto createUser(User user) {
        userRepository.persist(user);
        assignUserRoleService.assignRolesToUser(user, BASIC_ROLES);

        return UserMapper.toUserDto(user, BASIC_ROLES);
    }
}
