package us.greatapps4you.greatsales.entities.supply;

import us.greatapps4you.greatsales.entities.registry.Address;
import us.greatapps4you.greatsales.entities.registry.Identification;

import java.io.Serializable;
import java.util.List;

public class Vendor implements Serializable {

    private long id;
    private Identification identification;
     private Address address;
    private List<PurchaseHeader> acquisitons;

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
