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

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ORDERS")
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private UUID uuid;
    private String orderNumber;
    private LocalDateTime orderTime;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Customer customer;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Salesman salesman;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address deliveryAddress;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address billingAddress;
    private String mailMessage;
    private String mailOrderTo;
    private String mailInvoiceTo;
    private LocalDate deliveryDate;
    private BigDecimal deliveryFee;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Carrier carrier;
    private BigDecimal commissionInCurrency;
    private BigDecimal commissionInPercentage;
    private BigDecimal taxInPercentage;
    private String customerOrderNumber;
    private String paymentConditions;
    private String observations;

}
