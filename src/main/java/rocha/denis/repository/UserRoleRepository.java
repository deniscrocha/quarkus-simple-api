package rocha.denis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import rocha.denis.domain.entities.User;
import rocha.denis.domain.entities.UserRole;

import java.util.List;

@ApplicationScoped
public class UserRoleRepository implements PanacheRepositoryBase<UserRole, Long> {
    List<UserRole> findByUser(User user) {
        return this.find("user", user)
            .list();
    }
}
