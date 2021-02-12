package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.order.Carrier;

import java.util.UUID;

public interface CarrierRepository extends CrudRepository<Carrier, UUID> {
}
