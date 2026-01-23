package rocha.denis.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rocha.denis.domain.enumerated.Role;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private List<Role> roles;
}
