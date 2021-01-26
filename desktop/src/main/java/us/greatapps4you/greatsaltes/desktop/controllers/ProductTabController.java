/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsaltes.desktop.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductTabController {

    @FXML
    private TextField description;
    @FXML
    private TextField sku;
    @FXML
    private ListView<Product> products;

    @Autowired
    private ProductService productService;
    private Product selectedProduct;

    @FXML
    public void save() {
        System.out.println(createProduct(initProduct()));
    }

    @FXML
    public void productSelected(MouseEvent mouseEvent) {
        selectedProduct = products.getSelectionModel().getSelectedItem();
        System.out.println("Selected Product: " + selectedProduct);
        description.setText(selectedProduct.getDescription());
        sku.setText(selectedProduct.getSku());
    }

    public void initialize() {
        List<Product> allProductsFound = new ArrayList<>();
        productService.findAll().iterator().forEachRemaining(allProductsFound::add);
        ObservableList<Product> productsObservable = FXCollections.observableArrayList(allProductsFound);
        products.setItems(productsObservable);
    }

    /**
     * The ultimate source of truth is the screen
     */
    private Product initProduct() {
        UUID uuid = null;
        if (selectedProduct != null) {
            uuid = selectedProduct.getUuid();
        }
        return Product.builder()
                .uuid(uuid)
                .sku(sku.getText())
                .description(description.getText())
                .build();
    }

    public Product createProduct(Product product) {
        return productService.save(product);
    }


}
