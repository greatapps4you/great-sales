/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.inventory;

import us.greatapps4you.greatsales.entities.purchase.Vendor;

import java.io.Serializable;
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
public class Inventory implements Serializable {

    private Long sequential;
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

    public Inventory() {
        if(quantity == null) {
            quantity = BigDecimal.ZERO;
        }
    }

    public Inventory(Long sequential, UUID uuid, String lotNumber, Product product, BigDecimal quantity, BigDecimal minimalThreshold, ProductUnit unit, BigDecimal buyingPrice, BigDecimal sellingPrice, BigInteger shelfLife, LocalDateTime expiryDate, LocalDateTime buyingDate, Vendor vendor) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.lotNumber = lotNumber;
        this.product = product;
        this.quantity = quantity;
        this.minimalThreshold = minimalThreshold;
        this.unit = unit;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.shelfLife = shelfLife;
        this.expiryDate = expiryDate;
        this.buyingDate = buyingDate;
        this.vendor = vendor;
    }

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMinimalThreshold() {
        return minimalThreshold;
    }

    public void setMinimalThreshold(BigDecimal minimalThreshold) {
        this.minimalThreshold = minimalThreshold;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    public void setUnit(ProductUnit unit) {
        this.unit = unit;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigInteger getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(BigInteger shelfLife) {
        this.shelfLife = shelfLife;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(LocalDateTime buyingDate) {
        this.buyingDate = buyingDate;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (!product.equals(inventory.product)) return false;
        if (!quantity.equals(inventory.quantity)) return false;
        if (unit != inventory.unit) return false;
        if (!sellingPrice.equals(inventory.sellingPrice)) return false;
        return buyingDate.equals(inventory.buyingDate);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + unit.hashCode();
        result = 31 * result + sellingPrice.hashCode();
        result = 31 * result + buyingDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", sellingPrice=" + sellingPrice +
                ", expiryDate=" + expiryDate +
                ", vendor=" + vendor +
                '}';
    }
}
