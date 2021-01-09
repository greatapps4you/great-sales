package br.com.greatsoft.greaterp.view.product;

import br.com.greatsoft.greaterp.model.entity.inventory.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductListTM extends AbstractTableModel {
    private final List<Product> products;

    public ProductListTM(List<Product> products) {
        this.products = new ArrayList(products);
    }

    public int getRowCount() {
        return this.products.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch(column) {
            case 0:
                name = "CÓD. BARRAS";
                break;
            case 1:
                name = "DESCRIÇÃO";
                break;
            case 2:
                name = "FORNECEDOR";
        }

        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch(columnIndex) {
            case 1:
                type = Product.class;
            default:
                return type;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = (Product)this.products.get(rowIndex);
        Object value = null;

        try {
            switch(columnIndex) {
                case 0:
                    value = product.getBarCode();
                    break;
                case 1:
                    value = product;
                    break;
                case 2:
                    value = product.getVendor().getIdentification().getNomeFantasia();
            }
        } catch (Exception var6) {
            System.out.println("Erro em ProductListTM.getValueAt()");
        }

        return value;
    }
}
