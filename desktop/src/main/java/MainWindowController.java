/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {

    // views
    @FXML private Label label;
    @FXML private TextField field;

    private GreatSales main;

    // connect main class to controller
    public void setMain(GreatSales main) {
        this.main = main;
    }

    // assign text field text to label on button click
    public void handleButton() {
        String text = field.getText();
        label.setText(text);
        field.clear();
    }
}