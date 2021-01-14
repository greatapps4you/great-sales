/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import lombok.Builder;
import lombok.Data;
import us.greatapps4you.greatsales.entities.order.Carrier;
import us.greatapps4you.greatsales.entities.order.Customer;
import us.greatapps4you.greatsales.entities.order.OrderItem;
import us.greatapps4you.greatsales.entities.order.Salesman;
import us.greatapps4you.greatsales.entities.registration.Address;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderRequest {
    private UUID uuid;
    private Customer customer;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private String mailMessage;
    private String mailOrderTo;
    private String invoiceTo;
    private LocalDate deliveryDate;
    private BigDecimal deliveryFee;
    private Carrier carrier;
    private BigDecimal commissionInCurrency;
    private BigDecimal commissionInPercentage;
    private BigDecimal taxInPercentage;
    private String customerOrderNumber;
    private String paymentConditions;
    private String observations;

}
