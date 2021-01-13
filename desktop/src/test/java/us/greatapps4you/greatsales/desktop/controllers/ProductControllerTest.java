/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.greatapps4you.greatsales.desktop.repositories.ProductRepository;
import us.greatapps4you.greatsales.entities.inventory.Product;
import java.util.UUID;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductController productController;

    @Test
    public void whenRequestOrder_ThenCreateNewOrder() {
        UUID uuid = UUID.randomUUID();
        Product product = Product.builder()
                .uuid(uuid)
                .sku("PRODUCT_SKU")
                .description("Borracha GEB")
                .build();

        // Return the same object passed as parameter
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());

        Product actual = productController.createProduct(product);
        System.out.println(actual);

        assertThat(actual).isNotNull();
        assertThat(actual.getUuid()).isEqualTo(uuid);
    }

}