package br.com.greatsoft.greaterp.controller.bean;

import br.com.greatsoft.greaterp.model.entity.registry.Address;
import br.com.greatsoft.greaterp.model.entity.registry.Identification;
import br.com.greatsoft.greaterp.model.entity.supply.Vendor;
import java.io.Serializable;
import java.util.List;

public class VendorBean implements Serializable {
    private Vendor vendor;
    private List<Vendor> lista;

    public VendorBean() {
    }

    public static void main(String[] args) {
        VendorBean vendorBean = new VendorBean();
        Vendor vendor = new Vendor();
        Identification ident = new Identification();
        ident.setNomeFantasia("José Esteves de Souza Neto");
        ident.setCnpj("02966076909");
        ident.setInscEst("3154049-DF");
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
        vendor.setIdentification(ident);
        vendor.setAddress(address);
        vendorBean.setVendor(vendor);
        vendorBean.salvar();
    }

    public void salvar() {
        try {
            //FIXME: Review this code
            //(new VendorRn()).salvar(this.vendor);
            this.lista = null;
            this.vendor = null;
        } catch (Exception var2) {
            System.out.println("Erro em VendorBean.salvar()!");
            var2.printStackTrace();
        }

    }

    public boolean excluir(Vendor vendor) {
        try {
            //FIXME: Review this code
            //(new VendorRn()).excluir(vendor);
            this.lista = null;
            this.vendor = new Vendor();
            System.out.println("Fornecedor excluído!");
            return true;
        } catch (Exception var3) {
            System.out.println("Erro ao tentar excluir Fornecedor!");
            var3.printStackTrace();
            return false;
        }
    }

    public void novo() {
        this.vendor = new Vendor();
    }

    public Vendor getVendor(long id) {
        //FIXME: Review this code
        return null;
        //return this.vendor == null ? (Vendor)(new VendorRn()).carregar("id", id) : this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<Vendor> getLista() {
        if (this.lista == null) {
            //FIXME: Review this code
           // this.lista = (new VendorRn()).listar();
        }

        return this.lista;
    }

    public void setLista(List<Vendor> lista) {
        this.lista = lista;
    }
}
