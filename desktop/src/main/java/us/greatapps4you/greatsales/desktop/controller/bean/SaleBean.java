package us.greatapps4you.greatsales.desktop.controller.bean;

import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsales.entities.sale.Customer;
import us.greatapps4you.greatsales.entities.sale.Sale;
import us.greatapps4you.greatsales.entities.sale.SaleItem;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleBean implements Serializable {
    private Sale sale;
    private List<Sale> lista;

    public SaleBean() {
    }

    public static void main(String[] args) {
        SaleBean saleBean = new SaleBean();
        Sale sale = new Sale();
        //FIXME: Review this code
        Customer customer = null;
        sale.setCustomer(customer);
       // sale.setDataPedido(new Date());
        SaleItem item = new SaleItem();
        //FIXME: Review this code
        Product product = null;
        double quantity = 14000.0D;
        double unPrice = 7.69D;
       /* item.setProduct(product);
        item.setQuantity(quantity);
        item.setTotalPrice(quantity * unPrice);
        item.setSale(sale);*/

        try {
            sale.getItems().add(item);
        } catch (Exception var12) {
            List items = new ArrayList();
            items.add(item);
            sale.setItems(items);
        }

        saleBean.setSale(sale);
        saleBean.salvar();
    }

    public void salvar() {
        try {
            //FIXME: Review this code
            //(new SaleRn()).salvar(this.sale);
            this.lista = null;
            this.sale = null;
        } catch (Exception var2) {
            System.out.println("Erro em SaleBean.salvar()!");
            var2.printStackTrace();
        }

    }

    public boolean excluir(Sale sale) {
        try {
            //FIXME: Review this code
            //(new SaleRn()).excluir(sale);
            this.lista = null;
            this.sale = new Sale();
            System.out.println("Venda excluída!");
            return true;
        } catch (Exception var3) {
            System.out.println("Erro ao tentar excluir Venda!");
            var3.printStackTrace();
            return false;
        }
    }

    public static List<SaleItem> filtrarRelatorio(String dataInicial, String dataFinal) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataIn = formatter.parse(dataInicial);
        Date dataFin = formatter.parse(dataFinal);
        //FIXME: Review this code
        return null;
        //return (new SaleItemRn()).listarRelatorioComissoes(dataIn, dataFin, "SaleItem");
    }

    public void novo() {
        this.sale = new Sale();
    }

    public Sale getSale(long id) {
        return null;
        //FIXME: Review this code
        //return this.sale == null ? (Sale)(new SaleRn()).carregar("id", id) : this.sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public List<Sale> getLista() {
        if (this.lista == null) {
            return null;
            //this.lista = (new SaleRn()).listarSale();
        }

        return this.lista;
    }

    public void setLista(List<Sale> lista) {
        this.lista = lista;
    }
}
