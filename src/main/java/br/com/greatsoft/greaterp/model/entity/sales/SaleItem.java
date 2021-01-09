package br.com.greatsoft.greaterp.model.entity.sales;

import br.com.greatsoft.greaterp.common.DateUtil;
import br.com.greatsoft.greaterp.model.entity.inventory.Product;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(
        name = "SEQ_SALEITEM",
        sequenceName = "SEQ_SALEITEM",
        allocationSize = 0,
        initialValue = 1
)
public class SaleItem implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_SALEITEM",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @OneToOne(
            cascade = {CascadeType.PERSIST}
    )
    private Product product;
    @ManyToOne
    private SaleHeader saleHeader;
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    private double quantity;
    private double unPrice;
    private double totalPrice;
    private double discount;

    public SaleItem() {
    }

    public String toString() {
        return DateUtil.toStringDDmmYYYY(this.dataEntrega);
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

    public SaleHeader getSaleHeader() {
        return this.saleHeader;
    }

    public void setSaleHeader(SaleHeader saleHeader) {
        this.saleHeader = saleHeader;
    }

    public Date getDataEntrega() {
        return this.dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnPrice() {
        return this.unPrice;
    }

    public void setUnPrice(double unPrice) {
        this.unPrice = unPrice;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
