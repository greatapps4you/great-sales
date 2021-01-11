/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.registration;

import java.io.Serializable;
import java.util.UUID;

public class Identification implements Serializable {

    private Long sequential;
    private UUID uuid;
    private String name;
    private String tradeName;
    //US: EIN; BR: CNPJ
    private String taxId;

    public Identification() {
    }

    public Identification(Long sequential, UUID uuid, String name, String tradeName, String taxId) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.name = name;
        this.tradeName = tradeName;
        this.taxId = taxId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identification that = (Identification) o;

        if (!name.equals(that.name)) return false;
        return taxId.equals(that.taxId);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + taxId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                '}';
    }
}
