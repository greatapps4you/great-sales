package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.greatapps4you.greatsales.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
