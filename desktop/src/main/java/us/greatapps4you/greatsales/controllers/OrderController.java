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
import us.greatapps4you.greatsales.entities.order.Order;
import us.greatapps4you.greatsales.entities.order.OrderItem;
import us.greatapps4you.greatsales.entities.registration.Email;
import us.greatapps4you.greatsales.repositories.OrderRepository;
import us.greatapps4you.greatsales.services.EmailService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private EmailService emailService;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order save(Order order) {
        System.out.println("*********************************");
        System.out.println("MAIL TO: " + order.getMailOrderTo());
        System.out.println("*********************************");
        System.out.println("INVOICE TO: " + order.getMailInvoiceTo());
        System.out.println("*********************************");
        System.out.println("MESSAGE: " + order.getMailMessage());


        if (order != null) {
            if (order.getUuid() == null) {
                order.setUuid(UUID.randomUUID());
            }
        }

        if (order != null) {
            if (order.getOrderDate() == null) {
                order.setOrderDate(LocalDate.now());
            }
        }

        if (order != null) {
            if (order.getOrderNumber() == null) {
                order.setOrderNumber(nextOrderNumber());
            }
        }

        if (order != null) {
            if (order.getCustomer() != null) {
                if (order.getCustomer().getUuid() == null) {
                    //FIXME: THIS OBJECT SHOULD BE FETCHED FROM DATABASE
                    return null;
                }
            }
        }

        if (order != null) {
            if (order.getSalesman() != null) {
                if (order.getSalesman().getUuid() == null) {
                    //FIXME: THIS OBJECT SHOULD BE FETCHED FROM DATABASE
                    return null;
                }
            }
        }

        if (order != null) {
            if (order.getCarrier() != null) {
                if (order.getCarrier().getUuid() == null) {
                    //FIXME: THIS OBJECT SHOULD BE FETCHED FROM DATABASE
                    return null;
                }
            }
        }

        if (order != null) {
            if (order.getDeliveryAddress() != null) {
                if (order.getDeliveryAddress().getUuid() == null) {
                    /**
                     * New address must be created for new orders
                     */
                    order.getDeliveryAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        if (order != null) {
            if (order.getBillingAddress() != null) {
                if (order.getBillingAddress().getUuid() == null) {
                    /**
                     * New address must be created for new orders
                     */
                    order.getBillingAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        setItemsUuid(order);

        Order saved = repository.save(order);
        // Email order
        if (saved != null) {
            emailOrder(saved);
        }
        return saved;
    }

    private void setItemsUuid(Order order) {
        List<OrderItem> itemsWithUuid = new ArrayList<>();
        order.getItems().stream().forEach(item -> {
            if (item.getUuid() == null) {
                item.setUuid(UUID.randomUUID());
            }
            itemsWithUuid.add(item);
        });
        order.setItems(itemsWithUuid);
    }

    private void emailOrder(Order order) {
        Email email = Email.builder()
                .uuid(UUID.randomUUID())
                .toEmails(Arrays.asList(new String[]{order.getMailOrderTo()}))
                .emailSubject(order.getCustomer().getIdentification().getName()
                        + " | " + order.getOrderNumber())
                .emailText(order.getMailMessage())
                .timeSent(LocalDateTime.now())
                .build();
        emailService.send(email);
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

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            return id.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    private String nextOrderNumber() {
        String orderNumber = "";
        orderNumber += LocalDate.now().getYear();
        orderNumber += "-";
        orderNumber += LocalDate.now().getMonthValue();
        orderNumber += "-";
        orderNumber += LocalDate.now().getDayOfMonth();
        orderNumber += "-";
        orderNumber += LocalDateTime.now().getNano() / 1000;
        return orderNumber;
    }

}