package br.com.greatsoft.greaterp.controller.bean;

import br.com.greatsoft.greaterp.model.entity.inventory.Product;
import br.com.greatsoft.greaterp.model.entity.sales.Customer;
import br.com.greatsoft.greaterp.model.entity.sales.SaleHeader;
import br.com.greatsoft.greaterp.model.entity.sales.SaleItem;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleBean implements Serializable {
    private SaleHeader saleHeader;
    private List<SaleHeader> lista;

    public SaleBean() {
    }

    public static void main(String[] args) {
        SaleBean saleBean = new SaleBean();
        SaleHeader saleHeader = new SaleHeader();
        //FIXME: Review this code
        Customer customer = null;
        saleHeader.setCustomer(customer);
        saleHeader.setDataPedido(new Date());
        SaleItem item = new SaleItem();
        //FIXME: Review this code
        Product product = null;
        double quantity = 14000.0D;
        double unPrice = 7.69D;
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setTotalPrice(quantity * unPrice);
        item.setSaleHeader(saleHeader);

        try {
            saleHeader.getItems().add(item);
        } catch (Exception var12) {
            List items = new ArrayList();
            items.add(item);
            saleHeader.setItems(items);
        }

        saleBean.setSaleHeader(saleHeader);
        saleBean.salvar();
    }

    public void salvar() {
        try {
            //FIXME: Review this code
            //(new SaleRn()).salvar(this.saleHeader);
            this.lista = null;
            this.saleHeader = null;
        } catch (Exception var2) {
            System.out.println("Erro em SaleHeaderBean.salvar()!");
            var2.printStackTrace();
        }

    }

    public boolean excluir(SaleHeader saleHeader) {
        try {
            //FIXME: Review this code
            //(new SaleRn()).excluir(saleHeader);
            this.lista = null;
            this.saleHeader = new SaleHeader();
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
        this.saleHeader = new SaleHeader();
    }

    public SaleHeader getSaleHeader(long id) {
        return null;
        //FIXME: Review this code
        //return this.saleHeader == null ? (SaleHeader)(new SaleRn()).carregar("id", id) : this.saleHeader;
    }

    public void setSaleHeader(SaleHeader saleHeader) {
        this.saleHeader = saleHeader;
    }

    public List<SaleHeader> getLista() {
        if (this.lista == null) {
            return null;
            //this.lista = (new SaleRn()).listarSaleHeader();
        }

        return this.lista;
    }

    public void setLista(List<SaleHeader> lista) {
        this.lista = lista;
    }
}