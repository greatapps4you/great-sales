/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import us.greatapps4you.greatsaltes.desktop.services.MissionsService;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderTabController {

    @FXML private TextArea missionOverviewText;
    @FXML private ListView<String> missionsList;
    
    @Autowired @Qualifier("stringPrintWriter")
    private PrintWriter stackTraceWriter;
    
    @Autowired
    MissionsService service;
    private TabPaneManger tabManager;

    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Apollo", "Shuttle", "Skylab");
        missionsList.setItems(missions);
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        missionOverviewText.clear();
        final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
        missionOverviewText.positionCaret(0);
        missionOverviewText.appendText(getInfo(selectedItem));
    }
    
    @Autowired
    private void setTabManager(TabPaneManger tabManager){
        this.tabManager = tabManager;
    }
 
    public String getInfo(String selectedItem) {
        String missionInfo = null ;
                
        try {
            missionInfo = service.getMissionInfo(selectedItem); 
            getLog().appendText("Sucessfully retrieved mission info for " + selectedItem + "\n");
        } catch (IOException exception) {
            exception.printStackTrace (stackTraceWriter);
            getLog().appendText(stackTraceWriter.toString() + "\n");
        }
        
        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return missionOverviewText;
    }

    public ListView<String> getMissionsList() {
        return missionsList;
    }
    
    private TextArea getLog(){
        return tabManager.getVisualLog();
    }

}
