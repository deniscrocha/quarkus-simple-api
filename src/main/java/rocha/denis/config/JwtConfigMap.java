package rocha.denis.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;

@StaticInitSafe
@ConfigMapping(prefix = "jwt")
public interface JwtConfigMap {
    String issuer();

    int tokenDurationHours();
}
