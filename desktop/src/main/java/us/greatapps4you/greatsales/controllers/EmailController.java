/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.repositories.EmailRepository;
import us.greatapps4you.greatsales.services.EmailService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/emails")
public class EmailController {

    @Autowired
    private EmailService service;
    //private QuarkusEmailService service;
    private EmailRepository repository;

    @GET
    @Path("send")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendASimpleEmail() {
        service.send("",
                "TESTE GreatSales",
                "Esete e apenas um teste. Deu certo!!");
        return Response.accepted().build();
    }

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser() {
        return Response.accepted().build();
    }
}
