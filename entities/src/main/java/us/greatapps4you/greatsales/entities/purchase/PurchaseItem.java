/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.purchase;

import lombok.Builder;
import lombok.Data;
import us.greatapps4you.greatsales.entities.inventory.Inventory;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class PurchaseItem {
    private UUID uuid;
    private Inventory inventory;
    private BigDecimal quantity;
    private BigDecimal totalAmount;

}
