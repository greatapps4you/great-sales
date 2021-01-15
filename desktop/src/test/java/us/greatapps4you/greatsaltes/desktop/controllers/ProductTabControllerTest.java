/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsaltes.desktop.Main;
import us.greatapps4you.greatsaltes.desktop.repositories.ProductRepository;
import java.util.UUID;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class ProductTabControllerTest {

    @Autowired
    ProductTabController productTabController;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void givenProductThenPersist() {
        UUID uuid = UUID.randomUUID();

        Product product = Product.builder()
                .uuid(uuid)
                .sku("TEST_PRODUCT_SKU")
                .description("TEST_PRODUCT").build();

        Product persisted = productTabController.createProduct(product);
        Product found = productRepository.findOne(uuid);

        assertEquals(product, persisted);
        Assertions.assertNotNull(found);
        Assertions.assertEquals(uuid, found.getUuid());
    }

}