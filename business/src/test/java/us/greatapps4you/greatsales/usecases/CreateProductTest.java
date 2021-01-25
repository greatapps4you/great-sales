/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import org.junit.jupiter.api.Test;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.util.UUID;
import java.util.function.Consumer;

public class CreateProductTest {

    private Consumer<Product> consumer;
    private DataProcessor<Product> dataProcessor;

    @Test
    void when_Create_then_Save_with_Consumer() {
        UUID uuid = UUID.randomUUID();
        Product product = Product.builder()
                .uuid(uuid)
                .description("Borracha")
                .sku("SKU_BORRACHA")
                .build();

        dataProcessor = (p, c) -> {
            c.accept(p);
            return p;
        };

        consumer = (p) -> {
            System.out.println("Consuming: " + p);
        };

        Product saved = dataProcessor.save(product, consumer);

        System.out.println("Saved: " + saved);

    }
}
