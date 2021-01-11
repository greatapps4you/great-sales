package us.greatapps4you.greatsales.desktop.view.vendor;

import us.greatapps4you.greatsales.entities.purchase.Vendor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendorListTM extends AbstractTableModel {
    private final List<Vendor> vendors;

    public VendorListTM(List<Vendor> vendors) {
        this.vendors = new ArrayList(vendors);
    }

    public int getRowCount() {
        return this.vendors.size();
    }

    public int getColumnCount() {
        return 8;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch(column) {
            case 0:
                name = "CNPJ";
                break;
            case 1:
                name = "NOME";
                break;
            case 2:
                name = "ENDEREÇO";
                break;
            case 3:
                name = "CIDADE";
                break;
            case 4:
                name = "ESTADO";
                break;
            case 5:
                name = "EMAIL";
                break;
            case 6:
                name = "TELEFONE";
                break;
            case 7:
                name = "ID";
        }

        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch(columnIndex) {
            case 7:
                type = Long.class;
            default:
                return type;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendor vendor = (Vendor)this.vendors.get(rowIndex);
        Object value = null;
        switch(columnIndex) {
            case 0:
                //value = vendor.getIdentification().getCnpj();
                break;
            case 1:
                //value = vendor.getIdentification().getNomeFantasia();
                break;
            case 2:
                value = vendor.getAddress().getStreet() + ", " + vendor.getAddress().getNumber();
                break;
            case 3:
                value = vendor.getAddress().getCity();
                break;
            case 4:
                value = vendor.getAddress().getCountryState();
                break;
            case 5:
                value = vendor.getAddress().getEmail();
                break;
            case 6:
                value = vendor.getAddress().getPhone();
                break;
            case 7:
                //value = vendor.getId();
        }

        return value;
    }
}
