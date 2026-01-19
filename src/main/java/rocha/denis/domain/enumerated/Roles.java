package rocha.denis.domain.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Roles {
    USER("User"),
    ADMIN("Admin");

    private final String name;
}
