/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.jpa.Product;
import us.greatapps4you.greatsales.repositories.ProductRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Path("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GET
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Product save() {
        Product product = Product
                .builder()
                .uuid(UUID.randomUUID())
                .sku("SKU_" + LocalDateTime.now().toString())
                .description("DESCRIPTION_" + LocalDateTime.now().toString())
                .build();
        return repository.save(product);
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product find(@PathParam("id") UUID id) {
        return repository.findById(id).orElse(Product.builder().build());
    }

    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") UUID id) {
        try {
            repository.deleteById(id);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getLocalizedMessage();
        }
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