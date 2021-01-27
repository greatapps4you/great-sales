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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    private TableView<Product> productsData;

    @Autowired
    private ProductService productService;
    private Product selectedProduct;

    @FXML
    public void save() {
        if (isEmptyMandatoryFields()) {
            return;
        }
        productService.save(initProduct());
        clearScreen();
        initialize();
    }

    private boolean isEmptyMandatoryFields() {
        return sku.getText().isEmpty()
                || description.getText().isEmpty();
    }

    @FXML
    public void create() {
        clearScreen();
        initialize();
    }

    @FXML
    public void delete() {
        if (selectedProduct == null) {
            return;
        }
        productService.delete(selectedProduct.getUuid());
        clearScreen();
        initialize();
    }

    @FXML
    public void selectedByMouse(MouseEvent mouseEvent) {
        handleProductSelection();
    }

    @FXML
    public void selectedByKey(KeyEvent keyEvent) {
        handleProductSelection();
    }

    private void handleProductSelection() {
        selectedProduct = productsData.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            return;
        }
        description.setText(selectedProduct.getDescription());
        sku.setText(selectedProduct.getSku());
    }

    public void initialize() {
        List<Product> allProductsFound = new ArrayList<>();
        productService.findAll().iterator().forEachRemaining(allProductsFound::add);
        ObservableList<Product> productsObservable = FXCollections.observableArrayList(allProductsFound);
        productsData.setItems(productsObservable);
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

    private void clearScreen() {
        productsData.getSelectionModel().clearSelection();
        selectedProduct = null;
        sku.clear();
        description.clear();
    }

}
