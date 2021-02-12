package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.inventory.Inventory;

import java.util.UUID;

public interface InventoryRepository extends CrudRepository<Inventory, UUID> {
}
