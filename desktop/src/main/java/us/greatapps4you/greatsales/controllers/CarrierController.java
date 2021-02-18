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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.entities.shipping.Carrier;
import us.greatapps4you.greatsales.repositories.CarrierRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/carriers")
public class CarrierController {

    @Autowired
    private CarrierRepository repository;
    @Value("${greatsales.carrier.home}")
    private String CARRIER_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier save(Carrier carrier) {
        System.out.println("Carrier Data Received: " + carrier);

        if (carrier != null) {
            if (carrier.getUuid() == null) {
                carrier.setUuid(UUID.randomUUID());
            }
        }

        if (carrier != null) {
            if(carrier.getIdentification() != null) {
                if( carrier.getIdentification().getUuid() == null) {
                    carrier.getIdentification().setUuid(UUID.randomUUID());
                }
            }
        }

        if (carrier != null) {
            if(carrier.getAddress() != null) {
                if( carrier.getAddress().getUuid() == null) {
                    carrier.getAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        return repository.save(carrier);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Carrier.builder().build());
    }

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + CARRIER_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carrier> list() {
        List<Carrier> allCarriers = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allCarriers::add);
        return allCarriers;
    }
}