package us.greatapps4you.greatsales.entities.sales;

import us.greatapps4you.greatsales.entities.inventory.Product;

import java.io.Serializable;
import java.util.Date;

public class SaleItem implements Serializable {

    private long id;
    private Product product;
    private SaleHeader saleHeader;
    private Date dataEntrega;
    private double quantity;
    private double unPrice;
    private double totalPrice;
    private double discount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleHeader getSaleHeader() {
        return saleHeader;
    }

    public void setSaleHeader(SaleHeader saleHeader) {
        this.saleHeader = saleHeader;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnPrice() {
        return unPrice;
    }

    public void setUnPrice(double unPrice) {
        this.unPrice = unPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
