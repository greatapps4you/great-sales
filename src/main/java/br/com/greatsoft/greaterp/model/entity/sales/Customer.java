package br.com.greatsoft.greaterp.model.entity.sales;

import br.com.greatsoft.greaterp.model.entity.registry.Address;
import br.com.greatsoft.greaterp.model.entity.registry.Identification;
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
        name = "SEQ_CUSTOMER",
        sequenceName = "SEQ_CUSTOMER",
        allocationSize = 0,
        initialValue = 1
)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_CUSTOMER",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private Identification identification;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private Address address;
    private String endCobranca;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    private List<SaleHeader> sales;

    public Customer() {
    }

    public String toString() {
        return this.identification.getNomeFantasia() + " - " + this.identification.getCnpj();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Identification getIdentification() {
        return this.identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEndCobranca() {
        return this.endCobranca;
    }

    public void setEndCobranca(String endCobranca) {
        this.endCobranca = endCobranca;
    }

    public List<SaleHeader> getSales() {
        return this.sales;
    }

    public void setSales(List<SaleHeader> sales) {
        this.sales = sales;
    }
}
