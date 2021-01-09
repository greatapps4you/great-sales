package us.greatapps4you.greatsales.entities.supply;

import us.greatapps4you.greatsales.entities.inventory.Product;

import java.io.Serializable;

public class PurchaseItem implements Serializable {

    private long id;
    private Product product;
    private double quantity;
    private double discount;
    private double finalPrice;

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
