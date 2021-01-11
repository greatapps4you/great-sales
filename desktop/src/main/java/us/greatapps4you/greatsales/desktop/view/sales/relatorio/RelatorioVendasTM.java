package us.greatapps4you.greatsales.desktop.view.sales.relatorio;

import us.greatapps4you.greatsales.entities.sale.Sale;
import us.greatapps4you.greatsales.entities.sale.SaleItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RelatorioVendasTM extends AbstractTableModel {
    private final List<SaleItem> saleItems;

    public RelatorioVendasTM(List<SaleItem> saleItems) {
        this.saleItems = new ArrayList(saleItems);
    }

    public int getRowCount() {
        return this.saleItems.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch(column) {
            case 0:
                name = "N. PEDIDO";
                break;
            case 1:
                name = "CLIENTE";
                break;
            case 2:
                name = "DATA ENTREGA";
                break;
            case 3:
                name = "TOTAL";
        }

        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch(columnIndex) {
            case 0:
                type = Sale.class;
            case 1:
            default:
                break;
            case 2:
                type = SaleItem.class;
                break;
            case 3:
                type = Double.class;
        }

        return type;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        SaleItem saleItem = (SaleItem)this.saleItems.get(rowIndex);
        Object value = null;

        try {
            switch(columnIndex) {
                case 0:
                   // value = saleItem.getSaleHeader();
                    break;
                case 1:
                    //value = saleItem.getSaleHeader().getCustomer().getIdentification().getRazaoSocial();
                    break;
                case 2:
                    value = saleItem;
                    break;
                case 3:
                    //value = saleItem.getTotalPrice();
            }
        } catch (Exception var6) {
            System.out.println("Erro em RelatorioVendasTM.getValueAt()");
        }

        return value;
    }
}
