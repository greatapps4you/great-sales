package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.order.Salesman;

import java.util.UUID;

public interface SalesmanRepository extends CrudRepository<Salesman, UUID> {
}
