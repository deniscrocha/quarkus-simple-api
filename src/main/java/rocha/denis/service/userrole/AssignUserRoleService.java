package rocha.denis.service.userrole;

import rocha.denis.domain.entities.User;
import rocha.denis.domain.enumerated.Role;

import java.util.List;

public interface AssignUserRoleService {
    void assignRoleToUser(User user, Role role);

    void assignRolesToUser(User user, List<Role> role);
}
