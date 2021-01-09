package br.com.greatsoft.greaterp.model.entity.inventory;

import br.com.greatsoft.greaterp.model.entity.supply.Vendor;
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
        name = "SEQ_PRODUCT",
        sequenceName = "SEQ_PRODUCT",
        allocationSize = 0,
        initialValue = 1
)
public class Product implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_PRODUCT",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String barCode;
    @OneToOne(
            cascade = {CascadeType.PERSIST}
    )
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
