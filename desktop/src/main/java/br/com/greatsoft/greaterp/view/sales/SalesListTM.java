package br.com.greatsoft.greaterp.view.sales;

import us.greatapps4you.greatsales.entities.sale.Sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SalesListTM extends AbstractTableModel {
    private final List<Sale> sales;

    public SalesListTM(List<Sale> sales) {
        this.sales = new ArrayList(sales);
    }

    public int getRowCount() {
        return this.sales.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch(column) {
            case 0:
                name = "DATA PED.";
                break;
            case 1:
                name = "CLIENTE";
                break;
            case 2:
                name = "TOTAL";
                break;
            case 3:
                name = "PRAZO PGTO.";
                break;
            case 4:
                name = "N. PED";
        }

        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch(columnIndex) {
            case 0:
                type = Date.class;
            case 1:
            case 3:
            default:
                break;
            case 2:
                type = Double.class;
                break;
            case 4:
                type = Sale.class;
        }

        return type;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale saleHeader = (Sale)this.sales.get(rowIndex);
        Object value = null;

        try {
            switch(columnIndex) {
                case 0:
                    //value = saleHeader.getDataPedido();
                    break;
                case 1:
                   // value = saleHeader.getCustomer().getIdentification().getNomeFantasia();
                    break;
                case 2:
                    //value = saleHeader.getTotal();
                    break;
                case 3:
                    //value = saleHeader.getPrazoPgto();
                    break;
                case 4:
                    value = saleHeader;
            }
        } catch (Exception var6) {
            System.out.println("Erro em SaleHeaderListTM.getValueAt()");
        }

        return value;
    }
}
