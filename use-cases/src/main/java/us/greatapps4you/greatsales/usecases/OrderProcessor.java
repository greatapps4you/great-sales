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

public class OrderProcessor {

    private OrderRequest orderRequest;

    public OrderProcessor(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public Order create() {
        LocalDateTime orderTime = LocalDateTime.now();
        StringBuilder orderNumber = new StringBuilder("");
        orderNumber.append(orderTime.getYear())
                .append(orderTime.getMonthValue());

        return Order.builder()
                .orderTime(orderTime)
                .orderNumber(orderNumber.toString())
                .uuid(UUID.randomUUID())
                .customer(orderRequest.getCustomer())
                .items(orderRequest.getItems())
                .totalAmount(orderRequest.getTotalAmount())
                .salesman(orderRequest.getSalesman())
                .deliveryAddress(orderRequest.getDeliveryAddress())
                .billingAddress(orderRequest.getBillingAddress())
                .mailMessage(orderRequest.getMailMessage())
                .mailOrderTo(orderRequest.getMailOrderTo())
                .mailInvoiceTo(orderRequest.getInvoiceTo())
                .deliveryDate(orderRequest.getDeliveryDate())
                .deliveryFee(orderRequest.getDeliveryFee())
                .carrier(orderRequest.getCarrier())
                .commissionInCurrency(orderRequest.getCommissionInCurrency())
                .commissionInPercentage(orderRequest.getCommissionInPercentage())
                .taxInPercentage(orderRequest.getTaxInPercentage())
                .customerOrderNumber(orderRequest.getCustomerOrderNumber())
                .paymentConditions(orderRequest.getPaymentConditions())
                .observations(orderRequest.getObservations()).build();
    }
}
