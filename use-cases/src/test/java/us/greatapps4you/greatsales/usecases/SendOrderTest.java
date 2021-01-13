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
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsales.entities.order.Carrier;
import us.greatapps4you.greatsales.entities.order.Customer;
import us.greatapps4you.greatsales.entities.order.Order;
import us.greatapps4you.greatsales.entities.order.Salesman;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class SendOrderTest {

    private OrderProcessor orderProcessor;
    private OrderRequest orderRequest;
    private Customer customer;
    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private Carrier carrier;

    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .identification(Identification.builder()
                        .uuid(UUID.randomUUID())
                        .name("CUSTOMER NAME")
                        .tradeName("CUSTOMER TRADE NAME")
                        .taxId("CUSTOMER TAX ID").build())
                .address(Address.builder()
                        .uuid(UUID.randomUUID())
                        .street("CUSTOMER STREET")
                        .number("999")
                        .complement("CUSTOMER COMPLEMENT")
                        .zip("99999")
                        .neighborhood("CUSTOMER NEIGHBORHOOD")
                        .city("CUSTOMER CITY")
                        .countryState("CUSTOMER STATE")
                        .country("CUSTOMER COUNTRY")
                        .website("www.customer.com")
                        .email("customer@order.com")
                        .cellPhone("CELL PHONE 99999999999")
                        .phone("PHONE 99999999999").build())
                .build();

        salesman = Salesman.builder()
                .identification(Identification.builder()
                        .uuid(UUID.randomUUID())
                        .name("SALESMAN NAME")
                        .tradeName("SALESMAN TRADE NAME")
                        .taxId("SALESMAN TAX ID").build())
                .address(Address.builder()
                        .uuid(UUID.randomUUID())
                        .street("SALESMAN STREET")
                        .number("999")
                        .complement("SALESMAN COMPLEMENT")
                        .zip("99999")
                        .neighborhood("SALESMAN NEIGHBORHOOD")
                        .city("SALESMAN CITY")
                        .countryState("SALESMAN STATE")
                        .country("SALESMAN COUNTRY")
                        .website("www.SALESMAN.com")
                        .email("SALESMAN@order.com")
                        .cellPhone("CELL PHONE 99999999999")
                        .phone("PHONE 99999999999").build())
                .build();

        deliveryAddress = Address.builder()
                .uuid(UUID.randomUUID())
                .street("DELIVERY STREET")
                .number("999")
                .complement("DELIVERY COMPLEMENT")
                .zip("99999")
                .neighborhood("DELIVERY NEIGHBORHOOD")
                .city("DELIVERY CITY")
                .countryState("DELIVERY STATE")
                .country("DELIVERY COUNTRY")
                .website("www.DELIVERY.com")
                .email("DELIVERY@order.com")
                .cellPhone("CELL PHONE 99999999999")
                .phone("PHONE 99999999999").build();

        billingAddress = Address.builder()
                .uuid(UUID.randomUUID())
                .street("BILLING STREET")
                .number("999")
                .complement("BILLING COMPLEMENT")
                .zip("99999")
                .neighborhood("BILLING NEIGHBORHOOD")
                .city("BILLING CITY")
                .countryState("BILLING STATE")
                .country("BILLING COUNTRY")
                .website("www.BILLING.com")
                .email("BILLING@order.com")
                .cellPhone("CELL PHONE 99999999999")
                .phone("PHONE 99999999999").build();

        carrier = Carrier.builder()
                .identification(Identification.builder()
                        .uuid(UUID.randomUUID())
                        .name("CARRIER NAME")
                        .tradeName("CARRIER TRADE NAME")
                        .taxId("CARRIER TAX ID").build())
                .address(Address.builder()
                        .uuid(UUID.randomUUID())
                        .street("CARRIER STREET")
                        .number("999")
                        .complement("CARRIER COMPLEMENT")
                        .zip("99999")
                        .neighborhood("CARRIER NEIGHBORHOOD")
                        .city("CARRIER CITY")
                        .countryState("CARRIER STATE")
                        .country("CARRIER COUNTRY")
                        .website("www.CARRIER.com")
                        .email("CARRIER@order.com")
                        .cellPhone("CELL PHONE 99999999999")
                        .phone("PHONE 99999999999").build())
                .build();

        orderRequest = OrderRequest.builder()
                .customer(customer)
                .salesman(salesman)
                .carrier(carrier)
                .deliveryAddress(deliveryAddress)
                .billingAddress(billingAddress)
                .items(new ArrayList<>())
                .totalAmount(new BigDecimal("200000.00"))
                .mailMessage("Sending Order")
                .mailOrderTo("vendor@order.com")
                .invoiceTo("customer@order.com")
                .deliveryDate(LocalDate.now().plusDays(15))
                .deliveryFee(new BigDecimal("1000.00"))
                .commissionInCurrency(new BigDecimal("2500.00"))
                .commissionInPercentage(new BigDecimal("2.00"))
                .taxInPercentage(new BigDecimal("12"))
                .customerOrderNumber("9999")
                .paymentConditions("PAYMENT CONDITIONS")
                .observations("OBSERVATIONS")
                .build();

        orderProcessor = new OrderProcessor(orderRequest);
    }

    @Test
    void testProduct() {
        Product product = Product.builder()
                .sku("999999")
                .uuid(UUID.randomUUID())
                .description("Borracha")
                .build();

        System.out.println(product);
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
