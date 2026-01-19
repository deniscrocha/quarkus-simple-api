package rocha.denis;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@Path("/")
public class Greeter {

    @GET
    public String hello() {
        return "Hello, World";
    }

    @GET
    @Path("secure")
    @RolesAllowed({"User", "Admin"})
    public String secureHello(@Context SecurityContext ctx) {
        return new StringBuilder()
            .append("Hello ")
            .append(ctx.getUserPrincipal().getName())
            .append("!\n")
            .append("Is user admin: ")
            .append(ctx.isUserInRole("Admin"))
            .toString();
    }
}
