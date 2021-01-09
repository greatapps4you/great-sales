package br.com.greatsoft.greaterp.model.entity.supply;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(
        name = "SEQ_SALEHEADER",
        sequenceName = "SEQ_SALEHEADER",
        allocationSize = 0,
        initialValue = 1
)
public class PurchaseHeader implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_SALEHEADER",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @OneToOne
    private Vendor vendor;
    @OneToMany(
            cascade = {CascadeType.ALL}
    )
    private List<PurchaseItem> items;
    private double discount;
    private double finalPrice;

    public PurchaseHeader() {
    }

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
