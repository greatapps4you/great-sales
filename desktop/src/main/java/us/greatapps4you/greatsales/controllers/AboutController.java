package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/about")
public class AboutController {
    @Value("${greatsales.app.version}")
    private String version;

    @Value("${greatsales.app.name}")
    private String name;

    @GET
    @Path("/version")
    @Produces(MediaType.TEXT_HTML)
    public String version() {
        return version;
    }

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_HTML)
    public String name() {
        return name;
    }
}
