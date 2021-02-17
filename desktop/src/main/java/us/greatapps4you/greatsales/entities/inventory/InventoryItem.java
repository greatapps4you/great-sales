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

package us.greatapps4you.greatsales.entities.inventory;

import lombok.*;
import us.greatapps4you.greatsales.entities.purchase.Vendor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The scope of inventoryItem management concerns the balance between
 * replenishment lead time, carrying costs of inventoryItem, asset management,
 * inventoryItem forecasting, inventoryItem valuation, inventoryItem visibility,
 * future inventoryItem price forecasting, physical inventoryItem,
 * available physical space, quality management, replenishment,
 * returns and defective goods, and demand forecasting.
 * Balancing these competing requirements leads to optimal inventoryItem levels,
 * which is an ongoing process as the business needs shift and react
 * to the wider environment.
 * InventoryItem management involves a retailer seeking to acquire
 * and maintain a proper merchandise assortment while ordering,
 * shipping, handling, and related costs are kept in check.
 * It also involves systems and processes that identify
 * inventoryItem requirements, set targets, provide
 * replenishment techniques, report actual and
 * projected inventoryItem status and handle all
 * functions related to the tracking and management of material.
 * This would include the monitoring of material moved into
 * and out of stockroom locations and the reconciling
 * of the inventoryItem balances. It also may include ABC analysis,
 * lot tracking, cycle counting support, etc.
 * Management of the inventories, with the primary objective
 * of determining/controlling stock levels within
 * the physical distribution system, functions to balance
 * the need for product availability against the need
 * for minimizing stock holding and handling costs.
 */

@Entity
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {

    @Id
    private UUID uuid;
    private String lotNumber;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Product product;
    private BigDecimal quantity;
    private BigDecimal minimalThreshold;
    @Enumerated(EnumType.STRING)
    private ProductUnit unit;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private BigInteger shelfLife;
    private LocalDateTime expiryDate;
    private LocalDateTime buyingDate;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Vendor vendor;

}
