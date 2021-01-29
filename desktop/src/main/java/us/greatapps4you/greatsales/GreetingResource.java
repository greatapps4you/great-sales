package us.greatapps4you.greatsales;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/product/save")
public class GreetingResource {

    @Autowired
    private ProductRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product save() {
        Product product = new Product();
        product.setDescription(LocalDateTime.now().toString());
        return repository.save(product);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> list() {
        //return repository.findAll().iterator();
        return null;
    }
}