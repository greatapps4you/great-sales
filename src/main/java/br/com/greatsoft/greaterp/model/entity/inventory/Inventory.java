package br.com.greatsoft.greaterp.model.entity.inventory;

import br.com.greatsoft.greaterp.model.entity.sales.SaleHeader;
import br.com.greatsoft.greaterp.model.entity.supply.PurchaseHeader;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(
        name = "SEQ_INVENTORY",
        sequenceName = "SEQ_INVENTORY",
        allocationSize = 0,
        initialValue = 1
)
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_INVENTORY",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private Product product;
    private double quantity;
    private double price;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    private List<SaleHeader> sales;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    private List<PurchaseHeader> purchases;

    public Inventory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<SaleHeader> getSales() {
        return this.sales;
    }

    public void setSales(List<SaleHeader> sales) {
        this.sales = sales;
    }

    public List<PurchaseHeader> getPurchases() {
        return this.purchases;
    }

    public void setPurchases(List<PurchaseHeader> purchases) {
        this.purchases = purchases;
    }
}
