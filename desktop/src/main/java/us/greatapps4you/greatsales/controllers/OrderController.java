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
import us.greatapps4you.greatsales.entities.order.Order;
import us.greatapps4you.greatsales.entities.order.OrderItem;
import us.greatapps4you.greatsales.repositories.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;
    @Value("${greatsales.order.home}")
    private String ORDER_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order save(Order order) {
        System.out.println("Order Data Received: " + order);

        if (order != null) {
            if (order.getUuid() == null) {
                order.setUuid(UUID.randomUUID());
            }
        }

        if (order != null) {
            if (order.getCustomer() != null) {
                if (order.getCustomer().getUuid() == null) {
                    order.getCustomer().setUuid(UUID.randomUUID());
                }
            }
        }

        if (order != null) {
            if (order.getSalesman() != null) {
                if (order.getSalesman().getUuid() == null) {
                    order.getSalesman().setUuid(UUID.randomUUID());
                }
            }
        }

        if (order != null) {
            if (order.getCarrier() != null) {
                if (order.getCarrier().getUuid() == null) {
                    order.getCarrier().setUuid(UUID.randomUUID());
                }
            }
        }

        if (order != null) {
            if (order.getDeliveryAddress() != null) {
                if (order.getDeliveryAddress().getUuid() == null) {
                    order.getDeliveryAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        if (order != null) {
            if (order.getBillingAddress() != null) {
                if (order.getBillingAddress().getUuid() == null) {
                    order.getBillingAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        List<OrderItem> itemsWithUuid = new ArrayList<>();
        order.getItems().stream().forEach(item -> {
            if (item.getUuid() == null) {
                item.setUuid(UUID.randomUUID());
            }
            itemsWithUuid.add(item);
        });

        order.setItems(itemsWithUuid);
        return repository.save(order);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Order.builder().build());
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() {
        List<Order> allOrders = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allOrders::add);
        return allOrders;
    }

    @DELETE
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + ORDER_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }


}