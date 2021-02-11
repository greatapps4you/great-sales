/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.purchase;

import lombok.*;
import us.greatapps4you.greatsales.entities.inventory.Inventory;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItem {
    @Id
    private UUID uuid;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Inventory inventory;
    private BigDecimal quantity;
    private BigDecimal totalAmount;

}
