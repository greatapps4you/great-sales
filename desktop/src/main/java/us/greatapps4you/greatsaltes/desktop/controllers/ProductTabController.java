/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsaltes.desktop.services.ProductService;

@Component
public class ProductTabController {

    @FXML
    private TextField description;
    @FXML
    private TextField sku;
    @FXML
    public void save() {
        Product product = initProduct();
        System.out.println(createProduct(product));
    }

    @Autowired
    private ProductService productService;

    private Product initProduct() {
        return Product.builder()
                .sku(sku.getText())
                .description(description.getText())
                .build();
    }

    public Product createProduct(Product product) {
        return productService.save(product);
    }

}
