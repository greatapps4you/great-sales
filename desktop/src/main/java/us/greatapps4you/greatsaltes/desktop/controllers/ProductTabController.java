/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsaltes.desktop.repositories.ProductRepository;

import java.util.UUID;

@Component
public class ProductTabController {

    @FXML
    private TextArea loggerTxtArea;
    @Autowired
    private ProductRepository productRepository;

    @FXML
    public void save() {
        Product product = Product.builder()
                .uuid(UUID.randomUUID())
                .sku("PRODUCT_SKU")
                .description("PRODUCTION_PRODUCT").build();

        System.out.println(createProduct(product));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public TextArea getLoggerTxtArea() {
        return loggerTxtArea;
    }

}
