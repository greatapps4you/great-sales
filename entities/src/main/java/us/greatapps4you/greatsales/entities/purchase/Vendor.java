/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.purchase;

import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import java.io.Serializable;
import java.util.UUID;

public class Vendor implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Identification identification;
    private Address address;

    public Vendor() {
    }

    public Vendor(Long sequential, UUID uuid, Identification identification, Address address) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.identification = identification;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendor vendor = (Vendor) o;

        if (!identification.equals(vendor.identification)) return false;
        return address.equals(vendor.address);
    }

    @Override
    public int hashCode() {
        int result = identification.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "identification=" + identification +
                '}';
    }
}
