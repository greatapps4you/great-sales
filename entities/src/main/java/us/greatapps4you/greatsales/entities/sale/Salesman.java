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
import java.util.UUID;

public class Salesman implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Identification identification;
    private Address address;
    private String password;

    public Salesman() {
    }

    public Salesman(Long sequential, UUID uuid, Identification identification, Address address, String password) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.identification = identification;
        this.address = address;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salesman salesman = (Salesman) o;

        if (!identification.equals(salesman.identification)) return false;
        if (!address.equals(salesman.address)) return false;
        return password.equals(salesman.password);
    }

    @Override
    public int hashCode() {
        int result = identification.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "identification=" + identification +
                '}';
    }
}
