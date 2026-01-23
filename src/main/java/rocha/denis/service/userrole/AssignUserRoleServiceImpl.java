package rocha.denis.service.userrole;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.entities.UserRole;
import rocha.denis.domain.enumerated.Role;
import rocha.denis.mapper.userrole.UserRoleMapper;
import rocha.denis.repository.UserRoleRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class AssignUserRoleServiceImpl implements AssignUserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public void assignRoleToUser(User user, Role role) {
        if (Objects.isNull(user.getRoles())) user.setRoles(List.of());

        val userRole = this.getRoleOrCreate(user, role);
        if (Boolean.FALSE.equals(userRole.getIsActive()))
            userRole.setIsActive(true);

        userRoleRepository.persist(userRole);
    }

    @Override
    @Transactional
    public void assignRolesToUser(User user, List<Role> roles) {
        roles.forEach(role -> this.assignRoleToUser(user, role));
    }

    private UserRole getRoleOrCreate(User user, Role role) {
        return this.getRoleUserIfUserHas(user, role)
            .orElse(UserRoleMapper.toUserRole(user, role));
    }

    private Optional<UserRole> getRoleUserIfUserHas(User user, Role role) {
        return user.getRoles()
            .stream()
            .filter(userRole -> userRole.getRole() == role)
            .findAny();
    }
}
