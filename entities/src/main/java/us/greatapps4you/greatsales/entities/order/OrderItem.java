/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.order;

import us.greatapps4you.greatsales.entities.inventory.Inventory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Inventory inventory;
    private BigDecimal quantity;
    private BigDecimal totalAmount;

    public OrderItem() {
    }

    public OrderItem(Long sequential, UUID uuid, Inventory inventory, BigDecimal quantity, BigDecimal totalAmount) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.inventory = inventory;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (!inventory.equals(orderItem.inventory)) return false;
        if (!quantity.equals(orderItem.quantity)) return false;
        return totalAmount.equals(orderItem.totalAmount);
    }

    @Override
    public int hashCode() {
        int result = inventory.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + totalAmount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "inventory=" + inventory +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
