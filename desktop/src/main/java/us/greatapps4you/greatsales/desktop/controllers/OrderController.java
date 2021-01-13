/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import us.greatapps4you.greatsales.desktop.repositories.OrderRepository;
import us.greatapps4you.greatsales.entities.order.Order;
import us.greatapps4you.greatsales.usecases.OrderProcessor;
import us.greatapps4you.greatsales.usecases.OrderRequest;

public class OrderController {

    private OrderProcessor orderProcessor;
    private OrderRepository orderRepository;


    @FXML
    public void save(ActionEvent event) {
        System.out.println("Saving...");
    }

    public Order createOrder(OrderRequest orderRequest) {
        orderProcessor = new OrderProcessor(orderRequest);
        return (Order) orderRepository.save(orderProcessor.create());
    }
}
