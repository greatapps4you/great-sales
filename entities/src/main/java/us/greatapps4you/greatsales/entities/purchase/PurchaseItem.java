package us.greatapps4you.greatsales.entities.purchase;

import us.greatapps4you.greatsales.entities.inventory.Inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class PurchaseItem implements Serializable {

    private Long sequential;
    private UUID uuid;
    private Inventory inventory;
    private BigDecimal quantity;
    private BigDecimal totalAmount;






}
