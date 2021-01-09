package us.greatapps4you.greatsales.entities.supply;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PurchaseHeader implements Serializable {

    private long id;
    private Date purchaseDate;
    private Vendor vendor;
    private List<PurchaseItem> items;
    private double discount;
    private double finalPrice;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<PurchaseItem> getItems() {
        return this.items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
