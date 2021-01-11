/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.customer;

import us.greatapps4you.greatsales.entities.sale.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomerListTM extends AbstractTableModel {
    private final List<Customer> customers;

    public CustomerListTM(List<Customer> customers) {
        this.customers = new ArrayList(customers);
    }

    public int getRowCount() {
        return this.customers.size();
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
        Customer customer = (Customer)this.customers.get(rowIndex);
        Object value = null;
        switch(columnIndex) {
            case 0:
                //value = customer.getIdentification().getCnpj();
                break;
            case 1:
                //value = customer.getIdentification().getNomeFantasia();
                break;
            case 2:
                value = customer.getAddress().getStreet() + ", " + customer.getAddress().getNumber();
                break;
            case 3:
                value = customer.getAddress().getCity();
                break;
            case 4:
                value = customer.getAddress().getCountryState();
                break;
            case 5:
                value = customer.getAddress().getEmail();
                break;
            case 6:
                value = customer.getAddress().getPhone();
                break;
            case 7:
                //value = customer.getId();
        }

        return value;
    }
}
