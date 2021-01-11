/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.inventory;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {

    private Long sequential;
    private UUID uuid;
    private String sku;
    private String description;

    public Product() {
    }

    public Product(Long sequential, UUID uuid, String sku, String description) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.sku = sku;
        this.description = description;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!sku.equals(product.sku)) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = sku.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
