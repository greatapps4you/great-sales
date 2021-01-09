package us.greatapps4you.greatsales.entities.inventory;

import us.greatapps4you.greatsales.entities.sales.SaleHeader;
import us.greatapps4you.greatsales.entities.supply.PurchaseHeader;

import java.io.Serializable;
import java.util.List;

public class Inventory implements Serializable {

    private long id;
    private Product product;
    private double quantity;
    private double price;
    private List<SaleHeader> sales;
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
