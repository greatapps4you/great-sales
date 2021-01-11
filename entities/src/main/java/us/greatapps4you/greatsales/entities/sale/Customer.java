/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.sale;

import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Customer implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Identification identification;
    private Address address;
    private Address billingAddress;
    private LocalDateTime registrationTime;

    public Customer() {
    }

    public Customer(Long sequential, UUID uuid, Identification identification, Address address, Address billingAddress, LocalDateTime registrationTime) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.identification = identification;
        this.address = address;
        this.billingAddress = billingAddress;
        this.registrationTime = registrationTime;
    }

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return identification.equals(customer.identification);
    }

    @Override
    public int hashCode() {
        return identification.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identification=" + identification +
                ", registrationTime=" + registrationTime +
                '}';
    }
}
