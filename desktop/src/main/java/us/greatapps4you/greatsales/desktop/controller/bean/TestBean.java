/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.controller.bean;

import us.greatapps4you.greatsales.entities.sale.SaleItem;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class TestBean {
    public TestBean() {
    }

    public static void main(String[] args) throws ParseException {
        String dataInicial = "01/01/2014";
        String dataFinal = "01/01/2015";
        SaleBean.filtrarRelatorio(dataInicial, dataFinal);
        List<SaleItem> vendas = SaleBean.filtrarRelatorio(dataInicial, dataFinal);
        Iterator var4 = vendas.iterator();

        while(var4.hasNext()) {
            SaleItem v = (SaleItem)var4.next();
            //System.out.println("Num. Pedido: " + v.getSaleHeader() + "Data Entrega: " + v + "Data Entrega: " + v.getTotalPrice());
        }

    }
}
