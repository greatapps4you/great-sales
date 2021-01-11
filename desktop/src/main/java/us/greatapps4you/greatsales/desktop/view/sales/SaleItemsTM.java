/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.sales;

import us.greatapps4you.greatsales.entities.sale.SaleItem;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SaleItemsTM extends AbstractTableModel {
    private final List<SaleItem> items;

    public SaleItemsTM(List<SaleItem> items) {
        this.items = new ArrayList(items);
    }

    public int getRowCount() {
        return this.items.size();
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch(column) {
            case 0:
                name = "QUANTIDADE";
                break;
            case 1:
                name = "DESCRIÇÃO";
                break;
            case 2:
                name = "PREÇO UN.";
                break;
            case 3:
                name = "ESPECIF.";
                break;
            case 4:
                name = "ENTREGA.";
                break;
            case 5:
                name = "TOTAL";
        }

        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = Double.class;
        switch(columnIndex) {
            case 1:
                type = SaleItem.class;
            case 2:
            default:
                break;
            case 3:
                type = String.class;
                break;
            case 4:
                type = String.class;
        }

        return type;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        SaleItem item = (SaleItem)this.items.get(rowIndex);
        Object value = null;

        try {
            switch(columnIndex) {
                case 0:
                    value = item.getQuantity();
                    break;
                case 1:
                    value = item;
                    break;
                case 2:
                    //value = item.getUnPrice();
                    break;
                case 3:
                    //value = item.getProduct().getCharacteristics();
                    break;
                case 4:
                   // value = DateUtil.toStringDDmmYYYY(item.getDataEntrega());
                    break;
                case 5:
                   // value = item.getTotalPrice();
            }
        } catch (Exception var6) {
            System.out.println("Erro em SaleHeaderTM.getValueAt()");
        }

        return value;
    }
}
