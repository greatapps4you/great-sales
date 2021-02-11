package us.greatapps4you.greatsales.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.purchase.Vendor;

import java.util.UUID;

public interface VendorRepository extends CrudRepository<Vendor, UUID> {
}
