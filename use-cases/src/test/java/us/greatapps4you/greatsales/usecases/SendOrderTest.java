/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.greatapps4you.greatsales.entities.order.*;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendOrderTest {

    private OrderProcessor orderProcessor;
    private OrderRequest orderRequest;
    private Customer customer;
    private List<OrderItem> items;
    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private Carrier carrier;

    @BeforeEach
    void setUp() {
        orderRequest = new OrderRequest();
        orderRequest.setSequential(1L);
        customer = new Customer();
        customer.setIdentification(new Identification(
                1L, UUID.randomUUID(),
                "CUSTOMER NAME",
                "CUSTOMER TRADE NAME",
                "CUSTOMER TAX ID"
        ));
        customer.setAddress(new Address(
                1L, UUID.randomUUID(),
                "CUSTOMER STREET",
                "999", "CUSTOMER COMPLEMENT",
                "99999", "CUSTOMER NEIGHBORHOOD",
                "CUSTOMER CITY", "CUSTOMER STATE",
                "CUSTOMER COUNTRY",
                "www.customer.com",
                "customer@order.com",
                "CELL PHONE 99999999999",
                "PHONE 99999999999"
        ));
        orderRequest.setCustomer(customer);
        items = new ArrayList<>();
        orderRequest.setItems(items);
        orderRequest.setTotalAmount(new BigDecimal("200000.00"));
        salesman = new Salesman(
                1L, UUID.randomUUID(),
                new Identification(
                        1L, UUID.randomUUID(),
                        "SALESMAN NAME",
                        "SALESMAN TRADE NAME",
                        "SALESMAN TAX ID"
                ), new Address(
                1L, UUID.randomUUID(),
                "SALESMAN STREET",
                "999", "SALESMAN COMPLEMENT",
                "99999", "SALESMAN NEIGHBORHOOD",
                "SALESMAN CITY", "SALESMAN STATE",
                "SALESMAN COUNTRY",
                "www.salesman.com",
                "salesman@order.com",
                "CELL PHONE 99999999999",
                "PHONE 99999999999"
        ), "abc123");
        orderRequest.setSalesman(salesman);
        deliveryAddress = new Address(
                1L, UUID.randomUUID(),
                "DELIVERY STREET",
                "999", "DELIVERY COMPLEMENT",
                "99999", "DELIVERY NEIGHBORHOOD",
                "DELIVERY CITY", "DELIVERY STATE",
                "DELIVERY COUNTRY",
                "www.delivey.com",
                "delivery@order.com",
                "CELL PHONE 99999999999",
                "PHONE 99999999999"
        );
        orderRequest.setDeliveryAddress(deliveryAddress);
        billingAddress = new Address(
                1L, UUID.randomUUID(),
                "BILLING STREET",
                "999", "BILLING COMPLEMENT",
                "99999", "BILLING NEIGHBORHOOD",
                "BILLING CITY", "BILLING STATE",
                "BILLING COUNTRY",
                "www.billing.com",
                "billing@order.com",
                "CELL PHONE 99999999999",
                "PHONE 99999999999"
        );
        orderRequest.setBillingAddress(billingAddress);
        orderRequest.setMailMessage("Sending Order");
        orderRequest.setMailOrderTo("vendor@order.com");
        orderRequest.setInvoiceTo("customer@order.com");
        orderRequest.setDeliveryDate(LocalDate.now().plusDays(15));
        orderRequest.setDeliveryFee(new BigDecimal("1000.00"));
        carrier = new Carrier(
                1L,
                UUID.randomUUID(),
                new Identification(
                        1L, UUID.randomUUID(),
                        "CARRIER NAME",
                        "CARRIER TRADE NAME",
                        "CARRIER TAX ID"
                ),
                new Address(
                        1L, UUID.randomUUID(),
                        "CARRIER STREET",
                        "999", "CARRIER COMPLEMENT",
                        "99999", "CARRIER NEIGHBORHOOD",
                        "CARRIER CITY", "CARRIER STATE",
                        "CARRIER COUNTRY",
                        "www.billing.com",
                        "billing@order.com",
                        "CELL PHONE 99999999999",
                        "PHONE 99999999999"
                )
        );
        orderRequest.setCarrier(carrier);
        orderRequest.setCommissionInCurrency(new BigDecimal("2500.00"));
        orderRequest.setCommissionInPercentage(new BigDecimal("2.00"));
        orderRequest.setTaxInPercentage(new BigDecimal("12"));
        orderRequest.setCustomerOrderNumber("9999");
        orderRequest.setPaymentConditions("PAYMENT CONDITIONS");
        orderRequest.setObservations("OBSERVATIONS");

        orderProcessor = new OrderProcessor(orderRequest);
    }

    @Test
    void whenOrderDataInput_ThenNewOrderCreated() {
        Order actual = orderProcessor.create();
        Assertions.assertEquals(orderRequest.getCustomer(), actual.getCustomer());
        Assertions.assertEquals(orderRequest.getTotalAmount(), actual.getTotalAmount());
        Assertions.assertEquals(LocalDateTime.now().getHour(), actual.getOrderTime().getHour());
        Assertions.assertEquals(LocalDateTime.now().getDayOfMonth(), actual.getOrderTime().getDayOfMonth());
    }
}
