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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import us.greatapps4you.greatsaltes.desktop.services.OrderFormLayoutService;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class OrderFormTabController {

    @FXML private TextArea orderFormLayout;
    @FXML private ListView<String> vendors;
    
    @Autowired @Qualifier("stringPrintWriter")
    private PrintWriter stackTraceWriter;
    
    @Autowired
    OrderFormLayoutService orderFormLayoutService;
    private TabPaneManger tabManager;

    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Sweetmix", "VOF", "GEB");
        vendors.setItems(missions);
    }

    @FXML
    private void vendorSelected(MouseEvent event) {
        orderFormLayout.clear();
        final String selectedVendor = vendors.getSelectionModel().getSelectedItem();
        orderFormLayout.positionCaret(0);
        orderFormLayout.appendText(getInfo(selectedVendor));
    }

    @FXML
    private void saveLayout(ActionEvent event) {
        final String selectedVendor = vendors.getSelectionModel().getSelectedItem();
        final String layoutContent = orderFormLayout.getText();
        try {
            orderFormLayoutService.saveOrderLayoutForVendor(selectedVendor, layoutContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Autowired
    private void setTabManager(TabPaneManger tabManager){
        this.tabManager = tabManager;
    }
 
    public String getInfo(String selectedVendor) {
        String missionInfo = null ;
                
        try {
            missionInfo = orderFormLayoutService.getOrderLayoutForVendor(selectedVendor);
            getLog().appendText("Sucessfully retrieved layout for " + selectedVendor + "\n");
        } catch (IOException exception) {
            exception.printStackTrace (stackTraceWriter);
            getLog().appendText(stackTraceWriter.toString() + "\n");
        }
        
        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return orderFormLayout;
    }

    public ListView<String> getMissionsList() {
        return vendors;
    }
    
    private TextArea getLog(){
        return tabManager.getVisualLog();
    }

}
