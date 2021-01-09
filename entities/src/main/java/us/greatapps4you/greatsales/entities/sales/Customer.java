package us.greatapps4you.greatsales.entities.sales;

import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

    private long id;
    private Identification identification;
    private Address address;
    private String endCobranca;
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
