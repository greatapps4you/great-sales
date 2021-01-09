package br.com.greatsoft.greaterp.model.entity.supply;

import br.com.greatsoft.greaterp.model.entity.inventory.Product;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name = "SEQ_PURCHASEITEM",
        sequenceName = "SEQ_PURCHASEITEM",
        allocationSize = 0,
        initialValue = 1
)
public class PurchaseItem implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_PURCHASEITEM",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private Product product;
    private double quantity;
    private double discount;
    private double finalPrice;

    public PurchaseItem() {
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
