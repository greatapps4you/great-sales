package br.com.greatsoft.greaterp.controller.bean;

import us.greatapps4you.greatsales.entities.inventory.Product;

import java.io.Serializable;
import java.util.List;

public class ProductBean implements Serializable {
    private Product product;
    private List<Product> lista;

    public ProductBean() {
    }

    public static void main(String[] args) {
        ProductBean productBean = new ProductBean();
        Product product = new Product();
       // product.setBarCode("7865757876771");
        product.setDescription("GEB 1");
        //product.setCharacteristics("Dureza 80");
        productBean.setProduct(product);
        productBean.salvar();
    }

    public void salvar() {
        try {
            //FIXME: Review this code
            //(new ProductRn()).salvar(this.product);
            this.lista = null;
            this.product = null;
        } catch (Exception var2) {
            System.out.println("Erro em ProductBean.salvar()!");
            var2.printStackTrace();
        }

    }

    public boolean excluir(Product product) {
        try {
            //FIXME: Review this code
            //(new ProductRn()).excluir(product);
            this.lista = null;
            this.product = new Product();
            System.out.println("Produto excluído!");
            return true;
        } catch (Exception var3) {
            System.out.println("Erro ao tentar excluir produto!");
            var3.printStackTrace();
            return false;
        }
    }

    public void novo() {
        this.product = new Product();
    }

    public Product getProduct(long id) {
        //FIXME: Review this code
        return null;
        //return this.product == null ? (Product)(new ProductRn()).carregar("id", id) : this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getLista() {
        if (this.lista == null) {
            //FIXME: Review this code
            //this.lista = (new ProductRn()).listar();
        }

        return this.lista;
    }

    public void setLista(List<Product> lista) {
        this.lista = lista;
    }
}
