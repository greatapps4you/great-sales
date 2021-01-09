package br.com.greatsoft.greaterp.model.entity.supply;

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
        name = "SEQ_VENDOR",
        sequenceName = "SEQ_VENDOR",
        allocationSize = 0,
        initialValue = 1
)
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_VENDOR",
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
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    private List<PurchaseHeader> acquisitons;

    public Vendor() {
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

    public List<PurchaseHeader> getAcquisitons() {
        return this.acquisitons;
    }

    public void setAcquisitons(List<PurchaseHeader> acquisitons) {
        this.acquisitons = acquisitons;
    }
}
