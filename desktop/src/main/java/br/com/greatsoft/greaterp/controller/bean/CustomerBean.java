package br.com.greatsoft.greaterp.controller.bean;

import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import us.greatapps4you.greatsales.entities.sale.Customer;

import java.io.Serializable;
import java.util.List;

public class CustomerBean implements Serializable {
    private Customer customer;
    private List<Customer> lista;

    public CustomerBean() {
    }

    public static void main(String[] args) {
        CustomerBean customerBean = new CustomerBean();
        Customer customer = new Customer();
        Identification ident = new Identification();
        /*ident.setNomeFantasia("José Esteves de Souza Neto");
        ident.setCnpj("02966076909");
        ident.setInscEst("3154049-DF");Address*/
        Address address = new Address();
        address.setStreet("Rua Pereira Passos");
        address.setNumber("838");
        address.setZip("87711-030");
        address.setNeighborhood("Jardim São Jorge");
        address.setCity("Paranavaí");
        address.setCountryState("Paraná");
        address.setCountry("Brasil");
        address.setPhone("44 3045-2946");
        address.setCellPhone("44 8425-1993");
        address.setEmail("estevesdeveloper@gmail.com");
        address.setWebsite("www.greatsoft.com.br");
        customer.setIdentification(ident);
        customer.setAddress(address);
        customerBean.setCustomer(customer);
        customerBean.salvar();
    }

    public void salvar() {
        try {
            //FIXME: Review this code
            //(new CustomerRn()).salvar(this.customer);
            this.lista = null;
            this.customer = null;
        } catch (Exception var2) {
            System.out.println("Erro em CustomerBean.salvar()!");
            var2.printStackTrace();
        }

    }

    public boolean excluir(Customer customer) {
        try {
            //FIXME: Review this code
            //(new CustomerRn()).excluir(customer);
            this.lista = null;
            this.customer = new Customer();
            System.out.println("Cliente excluído!");
            return true;
        } catch (Exception var3) {
            System.out.println("Erro ao tentar excluir cliente!");
            var3.printStackTrace();
            return false;
        }
    }

    public void novo() {
        this.customer = new Customer();
    }

    public Customer getCustomer(long id) {
        //FIXME: Review this code
        return null;
        //return this.customer == null ? (Customer)(new CustomerRn()).carregar("id", id) : this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getLista() {
        if (this.lista == null) {
            //FIXME: Review this code
           // this.lista = (new CustomerRn()).listar();
        }

        return this.lista;
    }

    public void setLista(List<Customer> lista) {
        this.lista = lista;
    }
}
