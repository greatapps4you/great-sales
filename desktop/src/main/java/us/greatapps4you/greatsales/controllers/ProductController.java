package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.entities.Product;
import us.greatapps4you.greatsales.repositories.ProductRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GET
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Product save() {
        Product product = new Product();
        product.setDescription(LocalDateTime.now().toString());
        return repository.save(product);
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product find(@PathParam("id") Long id) {
        return repository.findById(id).orElse(new Product());
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> list() {
        List<Product> allProducts = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allProducts::add);
        return allProducts;
    }
}