/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import us.greatapps4you.greatsales.entities.order.Order;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class OrderProcessor {
    public Order receive(OrderRequest orderRequest) {
        Order order = new Order();
        order.setSequential(orderRequest.getSequential());
        order.setCustomer(orderRequest.getCustomer());
        order.setItems(orderRequest.getItems());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setSalesman(orderRequest.getSalesman());
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());
        order.setBillingAddress(orderRequest.getBillingAddress());
        order.setMailMessage(orderRequest.getMailMessage());
        order.setMailOrderTo(orderRequest.getMailOrderTo());
        order.setMailInvoiceTo(orderRequest.getInvoiceTo());
        order.setDeliveryDate(orderRequest.getDeliveryDate());
        order.setDeliveryFee(orderRequest.getDeliveryFee());
        order.setCarrier(orderRequest.getCarrier());
        order.setCommissionInCurrency(orderRequest.getCommissionInCurrency());
        order.setCommissionInPercentage(orderRequest.getCommissionInPercentage());
        order.setTaxInPercentage(orderRequest.getTaxInPercentage());
        order.setCustomerOrderNumber(orderRequest.getCustomerOrderNumber());
        order.setPaymentConditions(orderRequest.getPaymentConditions());
        order.setObservations(orderRequest.getObservations());

        // Locally filled fields
        order.setOrderTime(LocalDateTime.now());
        StringBuilder orderNumber = new StringBuilder("");
        orderNumber.append(order.getOrderTime().getYear())
        .append(order.getOrderTime().getMonthValue())
        .append(order.getSequential());
        order.setOrderNumber(orderNumber.toString());
        order.setUuid(UUID.randomUUID());
        return order;
    }
}
