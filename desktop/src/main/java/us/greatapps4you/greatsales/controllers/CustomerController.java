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
import us.greatapps4you.greatsales.entities.order.Customer;
import us.greatapps4you.greatsales.repositories.CustomerRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Value("${greatsales.customer.home}")
    private String CUSTOMER_HOME;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer save(Customer customer) {
        System.out.println("Customer Data Received: " + customer);

        if (customer != null) {
            if (customer.getUuid() == null) {
                customer.setUuid(UUID.randomUUID());
            }
        }

        if (customer != null) {
            if (customer.getRegistrationDate() == null) {
                customer.setRegistrationDate(LocalDate.now());
            }
        }

        if (customer != null) {
            if(customer.getIdentification() != null) {
               if( customer.getIdentification().getUuid() == null) {
                   customer.getIdentification().setUuid(UUID.randomUUID());
               }
            }
        }

        if (customer != null) {
            if(customer.getAddress() != null) {
                if( customer.getAddress().getUuid() == null) {
                    customer.getAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        if (customer != null) {
            if(customer.getBillingAddress() != null) {
                if( customer.getBillingAddress().getUuid() == null) {
                    customer.getBillingAddress().setUuid(UUID.randomUUID());
                }
            }
        }

        return repository.save(customer);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Customer.builder().build());
    }

    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            //FIXME: When we have a serious view framework like React this concern goes away
            return "<script>window.location.replace('" + CUSTOMER_HOME + "')</script>";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> list() {
        List<Customer> allCustomers = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allCustomers::add);
        return allCustomers;
    }
}
