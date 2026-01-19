package rocha.denis.config;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import rocha.denis.exception.LoginValidationException;
import rocha.denis.exception.ValidationException;

public class ExceptionMapper {

    @ServerExceptionMapper
    public Response mapValidationException(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(exception.getMessage())
            .build();
    }

    @ServerExceptionMapper
    public Response mapLoginValidationException (LoginValidationException exception) {
        return Response.status(Response.Status.FORBIDDEN)
            .entity(exception.getMessage())
            .build();
    }
}
