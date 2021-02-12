package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.order.Order;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
