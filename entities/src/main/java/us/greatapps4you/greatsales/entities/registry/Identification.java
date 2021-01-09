package us.greatapps4you.greatsales.entities.registry;

import java.io.Serializable;

public class Identification implements Serializable {

    private long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String inscEst;
    private String inscMun;

    public Identification() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEst() {
        return this.inscEst;
    }

    public void setInscEst(String inscEst) {
        this.inscEst = inscEst;
    }

    public String getInscMun() {
        return this.inscMun;
    }

    public void setInscMun(String inscMun) {
        this.inscMun = inscMun;
    }
}
