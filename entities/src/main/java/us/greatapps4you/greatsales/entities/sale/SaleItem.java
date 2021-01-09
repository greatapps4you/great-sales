package us.greatapps4you.greatsales.entities.sale;

import us.greatapps4you.greatsales.entities.inventory.Product;

import java.io.Serializable;
import java.util.Date;

public class SaleItem implements Serializable {

    private long id;
    private Product product;
    private Sale saleHeader;
    private Date dataEntrega;
    private double quantity;
    private double unPrice;
    private double totalPrice;
    private double discount;


}
