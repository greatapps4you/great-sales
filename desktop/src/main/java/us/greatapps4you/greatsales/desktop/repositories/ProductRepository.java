/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.repositories;

import org.springframework.data.repository.CrudRepository;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}