/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.controllers;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TabPaneManger {

    private final OrderTabController orderTabController;
    private final ProductTabController productTabController;

    @Autowired
    public TabPaneManger(OrderTabController orderTabController, ProductTabController productTabController) {
        this.orderTabController = orderTabController;
        this.productTabController = productTabController;
    }

    public TextArea getVisualLog() {
        return productTabController.getLoggerTxtArea();
    }

}
