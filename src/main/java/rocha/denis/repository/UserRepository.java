package rocha.denis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import rocha.denis.domain.entities.User;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {
    public Optional<User> findByUsername(String username) {
        return this.find("username", username)
            .firstResultOptional();
    }
}
