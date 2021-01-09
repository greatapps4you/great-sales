package us.greatapps4you.greatsales.entities.inventory;

import us.greatapps4you.greatsales.entities.supply.Vendor;
import java.io.Serializable;

public class Product implements Serializable {

    private long id;
    private String barCode;
    private Vendor vendor;
    private String description;
    private String characteristics;

    public Product() {
    }

    public String toString() {
        return this.description + " - " + this.characteristics;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristics() {
        return this.characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
