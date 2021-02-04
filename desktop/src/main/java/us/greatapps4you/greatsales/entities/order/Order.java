/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.order;

import lombok.*;
import us.greatapps4you.greatsales.entities.registration.Address;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private UUID uuid;
    private String orderNumber;
    private LocalDateTime orderTime;
    private Customer customer;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private String mailMessage;
    private String mailOrderTo;
    private String mailInvoiceTo;
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
