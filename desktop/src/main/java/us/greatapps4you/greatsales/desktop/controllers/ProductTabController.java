/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import us.greatapps4you.greatsales.desktop.repositories.ProductRepository;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.util.UUID;

@Component
@Qualifier("productTabController")
public class ProductTabController {

    private ProductRepository productRepository;
    private Product product;

    @Autowired
    public ProductTabController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @FXML
    public void save(ActionEvent event) {
        product = Product.builder()
                .uuid(UUID.randomUUID())
                .sku("TEST_PRODUCT_SKU")
                .description("TEST PRODUCT DESCRIPTION")
                .build();
        System.out.println("" + createProduct(product));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
