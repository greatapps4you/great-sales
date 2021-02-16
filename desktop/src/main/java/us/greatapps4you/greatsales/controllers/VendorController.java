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
import us.greatapps4you.greatsales.entities.purchase.Vendor;
import us.greatapps4you.greatsales.repositories.VendorRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/vendors")
public class VendorController {

    @Autowired
    private VendorRepository repository;
    @Value("${greatsales.vendor.home}")
    private String VENDOR_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vendor save(Vendor vendor) {
        System.out.println("Vendor Data Received: " + vendor);

        if (vendor != null) {
            if (vendor.getUuid() == null) {
                vendor.setUuid(UUID.randomUUID());
            }
        }

         if (vendor != null) {
            if(vendor.getIdentification() != null) {
                if( vendor.getIdentification().getUuid() == null) {
                    vendor.getIdentification().setUuid(UUID.randomUUID());
                }
            }
        }

        if (vendor != null) {
            if(vendor.getAddress() != null) {
                if( vendor.getAddress().getUuid() == null) {
                    vendor.getAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        return repository.save(vendor);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vendor find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Vendor.builder().build());
    }

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + VENDOR_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vendor> list() {
        List<Vendor> allVendors = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allVendors::add);
        return allVendors;
    }
}
