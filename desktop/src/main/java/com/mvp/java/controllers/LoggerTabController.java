/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package com.mvp.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

@Component
public class LoggerTabController {

    @FXML private TextArea loggerTxtArea;

    public TextArea getLoggerTxtArea() {
        return loggerTxtArea;
    }
    
}
