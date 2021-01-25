/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 *//*


package us.greatapps4you.greatsaltes.desktop.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {TestingConfig.class, TestingJpaConfig.class})
public class ProductTabControllerTest {

    @Autowired
    private ProductTabController controller;

    @Test
    public void testPersistProduct() {
        UUID uuid = UUID.randomUUID();
        String sku = "TEST_PRODUCT_SKU";
        String description = "BORRACHA_TEST";

        Product given = Product.builder()
                .uuid(uuid)
                .sku(sku)
                .description(description)
                .build();

        Product actual = controller.createProduct(given);
        Assert.assertEquals(actual.getUuid(), uuid);
        assertThat(actual.getUuid()).isEqualTo(uuid);

        System.out.println(actual);
    }
}*/
