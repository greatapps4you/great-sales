package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.entities.order.Order;
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
        System.out.println("Product Data Received: " + order);

        if (order != null) {
            if (order.getUuid() == null) {
                order.setUuid(UUID.randomUUID());
            }
        }

        return repository.save(order);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Order.builder().build());
    }

    @GET
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

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() {
        List<Order> allOrders = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allOrders::add);
        return allOrders;
    }
}