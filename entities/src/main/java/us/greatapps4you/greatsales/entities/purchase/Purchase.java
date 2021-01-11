/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.purchase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Purchase implements Serializable {

    private Long sequential;
    private UUID uuid;
    private LocalDateTime purchaseTime;
    private Vendor vendor;
    private List<PurchaseItem> items;
    private BigDecimal totalAmount;

    public Purchase() {
        this.totalAmount = BigDecimal.ZERO;
        this.items = new ArrayList<>();
    }

    public Purchase(Long sequential, UUID uuid, LocalDateTime purchaseTime, Vendor vendor, List<PurchaseItem> items, BigDecimal totalAmount) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.purchaseTime = purchaseTime;
        this.vendor = vendor;
        this.items = items;
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

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
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

        Purchase purchase = (Purchase) o;

        if (!purchaseTime.equals(purchase.purchaseTime)) return false;
        if (!vendor.equals(purchase.vendor)) return false;
        if (!items.equals(purchase.items)) return false;
        return totalAmount.equals(purchase.totalAmount);
    }

    @Override
    public int hashCode() {
        int result = purchaseTime.hashCode();
        result = 31 * result + vendor.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + totalAmount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseTime=" + purchaseTime +
                ", vendor=" + vendor +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
