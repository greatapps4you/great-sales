/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.greatapps4you.greatsales.entities.inventory.Inventory;
import us.greatapps4you.greatsales.entities.inventory.Product;
import java.math.BigDecimal;
import java.util.UUID;

class CreateNewProductTest {

    private CreateNewProduct createNewProduct;
    private Product product;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        createNewProduct = (p) -> {
            Product product = new Product();
            product.setDescription(p.getDescription());
            product.setSequential(p.getSequential());
            product.setUuid(p.getUuid());
            product.setSku(p.getSku());

            inventory.setProduct(product);
            inventory.setQuantity(inventory.getQuantity().add(BigDecimal.ONE));
            return inventory;
        };

        product = new Product();
        product.setDescription("Borracha GEB");
        product.setSequential(1L);
        product.setUuid(UUID.randomUUID());
        product.setSku("1234567898765");
    }

    @Test
    void whenCreateProduct_ThenReturnProduct() {
        Product actual = createNewProduct.create(product).getProduct();
        Assertions.assertEquals(product,actual);
    }

    @Test
    void whenCreateProduct_ThenIncreaseInventory() {
        createNewProduct.create(product);
        createNewProduct.create(product);
        createNewProduct.create(product);
        createNewProduct.create(product);
        createNewProduct.create(product);
        Assertions.assertEquals(new BigDecimal("5"),inventory.getQuantity());
    }

}