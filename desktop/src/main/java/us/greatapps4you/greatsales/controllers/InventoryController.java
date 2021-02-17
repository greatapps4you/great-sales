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
import us.greatapps4you.greatsales.entities.inventory.InventoryItem;
import us.greatapps4you.greatsales.repositories.InventoryRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository repository;
    @Value("${greatsales.inventory.home}")
    private String INVENTORY_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InventoryItem save(InventoryItem inventoryItem) {
        System.out.println("InventoryItem Data Received: " + inventoryItem);

        if (inventoryItem != null) {
            if (inventoryItem.getUuid() == null) {
                inventoryItem.setUuid(UUID.randomUUID());
            }
        }
        return repository.save(inventoryItem);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public InventoryItem find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(InventoryItem.builder().build());
    }

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + INVENTORY_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventoryItem> list() {
        List<InventoryItem> allInventoryItems = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allInventoryItems::add);
        return allInventoryItems;
    }
}