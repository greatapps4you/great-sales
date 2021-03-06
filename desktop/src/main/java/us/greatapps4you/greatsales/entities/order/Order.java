/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.order;

import lombok.*;
import us.greatapps4you.greatsales.entities.shipping.Carrier;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.shipping.ShippingType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    // Entities
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Customer customer;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Salesman salesman;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Carrier carrier;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address deliveryAddress;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address billingAddress;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderItem> items;
    @Enumerated(EnumType.STRING)
    private ShippingType shipping;
    // Decimal Values
    private BigDecimal grandTotal;
    private BigDecimal commission;
    private BigDecimal tax;
    // Dates
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    // Strings
    private String orderNumber;
    @Lob
    private String mailMessage;
    private String mailOrderTo;
    private String mailInvoiceTo;
    private String customerOrderNumber;
    private String paymentPlan;
    private String observations;

}
