package rocha.denis.domain.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("User"),
    ADMIN("Admin");

    private final String name;
}
