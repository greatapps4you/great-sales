/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.util.UUID;
import java.util.function.Function;

public class ProductTest {

    private UUID uuid = UUID.randomUUID();

    @Test
    void when_Create_then_return_Product() {
        DataProcessor<Product, Product> dataProcessor = () -> { };

        Product product = Product.builder()
                .description("Borracha")
                .sku("SKU_BORRACHA")
                .build();

        Function<Product, Product> saveAlgorithm = (p) -> {
            /*if(p.getUuid() == null) {
                p.setUuid(UUID.randomUUID());
            }*/
            System.out.println("Creating: " + p);
            return p;
        };

        Product saved = dataProcessor.process(product, saveAlgorithm);
        //Assertions.assertNotEquals(uuid, saved.getUuid());
    }

    @Test
    void when_Update_then_return_Product() {
        DataProcessor<Product, Product> dataProcessor = () -> {
        };

        Product product = Product.builder()
                //.uuid(uuid)
                .description("Borracha Updated")
                .sku("SKU_BORRACHA")
                .build();

        Function<Product, Product> saveAlgorithm = (p) -> {
           /* if(p.getUuid() == null) {
                p.setUuid(UUID.randomUUID());
            }*/
            System.out.println("Updating: " + p);
            return p;
        };

        Product saved = dataProcessor.process(product, saveAlgorithm);
        //Assertions.assertEquals(uuid, saved.getUuid());
    }

    @Test
    void when_Delete_then_then_return_Product() {
        DataProcessor<UUID, Product> dataProcessor = () -> {
        };

        Function<UUID, Product> deleteAlgorithm = (u) -> {
            System.out.println("Deleting: " + u);
            return fetchProduct(u);
        };

        Product expected = Product.builder()
                //.uuid(uuid)
                .description("Borracha")
                .sku("SKU_BORRACHA")
                .build();

        Product deleted = dataProcessor.process(uuid, deleteAlgorithm);
        Assertions.assertEquals(expected, deleted);
    }

    private Product fetchProduct(UUID uuid) {
        return Product.builder()
                //.uuid(uuid)
                .description("Borracha")
                .sku("SKU_BORRACHA")
                .build();
    }
}
