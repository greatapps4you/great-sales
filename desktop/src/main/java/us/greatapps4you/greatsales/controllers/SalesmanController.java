package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.entities.order.Salesman;
import us.greatapps4you.greatsales.repositories.SalesmanRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/salesmen")
public class SalesmanController {

    @Autowired
    private SalesmanRepository repository;
    @Value("${greatsales.salesman.home}")
    private String SALESMAN_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Salesman save(Salesman salesman) {
        System.out.println("Salesman Data Received: " + salesman);

        if (salesman != null) {
            if (salesman.getUuid() == null) {
                salesman.setUuid(UUID.randomUUID());
            }
        }

        if (salesman != null) {
            if(salesman.getIdentification() != null) {
                if( salesman.getIdentification().getUuid() == null) {
                    salesman.getIdentification().setUuid(UUID.randomUUID());
                }
            }
        }

        if (salesman != null) {
            if(salesman.getAddress() != null) {
                if( salesman.getAddress().getUuid() == null) {
                    salesman.getAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        return repository.save(salesman);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Salesman find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Salesman.builder().build());
    }

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + SALESMAN_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Salesman> list() {
        List<Salesman> allSalesmen = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allSalesmen::add);
        return allSalesmen;
    }
}
