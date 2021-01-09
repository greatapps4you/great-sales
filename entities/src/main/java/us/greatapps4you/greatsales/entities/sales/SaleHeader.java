package us.greatapps4you.greatsales.entities.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SaleHeader implements Serializable {
    private long id;
    private String numeroPedido;
    private Date dataPedido;
    private Customer customer;
    private List<SaleItem> items;
    private double discount;
    private double finalPrice;
    private Salesman representante;
    private String message;
    private String observacoes;
    private String emailPedido;
    private String emailDanfe;
    private String endEntrega;
    private String endFatura;
    private String comprador;
    private String dataEntrega;
    private String frete;
    private String transportadora;
    private String prazoPgto;
    private String pedidoCliente;
    private String icms;
    private double total;
    private double comissaoDinheiro;
    private double comissaoPercent;
    private boolean editavel;

    public SaleHeader() {
    }

    public String toString() {
        return this.numeroPedido;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SaleItem> getItems() {
        return this.items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Salesman getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(Salesman representante) {
        this.representante = representante;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getEmailPedido() {
        return this.emailPedido;
    }

    public void setEmailPedido(String emailPedido) {
        this.emailPedido = emailPedido;
    }

    public String getEmailDanfe() {
        return this.emailDanfe;
    }

    public void setEmailDanfe(String emailDanfe) {
        this.emailDanfe = emailDanfe;
    }

    public String getEndEntrega() {
        return this.endEntrega;
    }

    public void setEndEntrega(String endEntrega) {
        this.endEntrega = endEntrega;
    }

    public String getEndFatura() {
        return this.endFatura;
    }

    public void setEndFatura(String endFatura) {
        this.endFatura = endFatura;
    }

    public String getComprador() {
        return this.comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getDataEntrega() {
        return this.dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getFrete() {
        return this.frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getTransportadora() {
        return this.transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getPrazoPgto() {
        return this.prazoPgto;
    }

    public void setPrazoPgto(String prazoPgto) {
        this.prazoPgto = prazoPgto;
    }

    public String getPedidoCliente() {
        return this.pedidoCliente;
    }

    public void setPedidoCliente(String pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    public String getIcms() {
        return this.icms;
    }

    public void setIcms(String icms) {
        this.icms = icms;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getComissaoDinheiro() {
        return this.comissaoDinheiro;
    }

    public void setComissaoDinheiro(double comissaoDinheiro) {
        this.comissaoDinheiro = comissaoDinheiro;
    }

    public double getComissaoPercent() {
        return this.comissaoPercent;
    }

    public void setComissaoPercent(double comissaoPercent) {
        this.comissaoPercent = comissaoPercent;
    }

    public boolean isEditavel() {
        return this.editavel;
    }

    public void setEditavel(boolean editavel) {
        this.editavel = editavel;
    }
}
