/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.purchase;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    private UUID uuid;
    private LocalDateTime purchaseTime;
    @OneToOne(cascade = {CascadeType.ALL})
    private Vendor vendor;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PurchaseItem> items;
    private BigDecimal totalAmount;

}
