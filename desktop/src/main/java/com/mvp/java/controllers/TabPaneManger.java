/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package com.mvp.java.controllers;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TabPaneManger {

    private final ConsoleTabController consoleTabController;
    private final LoggerTabController loggerTabController;

    @Autowired
    public TabPaneManger(ConsoleTabController consoleTabController, LoggerTabController loggerTabController) {
        this.consoleTabController = consoleTabController;
        this.loggerTabController = loggerTabController;
    }

    public TextArea getVisualLog() {
        return loggerTabController.getLoggerTxtArea();
    }

}
