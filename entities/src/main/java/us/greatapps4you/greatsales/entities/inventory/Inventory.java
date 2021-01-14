/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.inventory;

import lombok.Builder;
import lombok.Data;
import us.greatapps4you.greatsales.entities.purchase.Vendor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The scope of inventory management concerns the balance between
 * replenishment lead time, carrying costs of inventory, asset management,
 * inventory forecasting, inventory valuation, inventory visibility,
 * future inventory price forecasting, physical inventory,
 * available physical space, quality management, replenishment,
 * returns and defective goods, and demand forecasting.
 * Balancing these competing requirements leads to optimal inventory levels,
 * which is an ongoing process as the business needs shift and react
 * to the wider environment.
 * Inventory management involves a retailer seeking to acquire
 * and maintain a proper merchandise assortment while ordering,
 * shipping, handling, and related costs are kept in check.
 * It also involves systems and processes that identify
 * inventory requirements, set targets, provide
 * replenishment techniques, report actual and
 * projected inventory status and handle all
 * functions related to the tracking and management of material.
 * This would include the monitoring of material moved into
 * and out of stockroom locations and the reconciling
 * of the inventory balances. It also may include ABC analysis,
 * lot tracking, cycle counting support, etc.
 * Management of the inventories, with the primary objective
 * of determining/controlling stock levels within
 * the physical distribution system, functions to balance
 * the need for product availability against the need
 * for minimizing stock holding and handling costs.
 */

@Data
@Builder
public class Inventory {
    private UUID uuid;
    private String lotNumber;
    private Product product;
    private BigDecimal quantity;
    private BigDecimal minimalThreshold;
    private ProductUnit unit;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private BigInteger shelfLife;
    private LocalDateTime expiryDate;
    private LocalDateTime buyingDate;
    private Vendor vendor;

}
