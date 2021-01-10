package us.greatapps4you.greatsales.entities.purchase;

import us.greatapps4you.greatsales.entities.inventory.Inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class PurchaseItem implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Inventory inventory;
    private BigDecimal quantity;
    private BigDecimal totalAmount;

    public PurchaseItem() {
    }

    public PurchaseItem(Long sequential, UUID uuid, Inventory inventory, BigDecimal quantity, BigDecimal totalAmount) {
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

        PurchaseItem that = (PurchaseItem) o;

        if (!inventory.equals(that.inventory)) return false;
        if (!quantity.equals(that.quantity)) return false;
        return totalAmount.equals(that.totalAmount);
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
        return "PurchaseItem{" +
                "inventory=" + inventory +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
