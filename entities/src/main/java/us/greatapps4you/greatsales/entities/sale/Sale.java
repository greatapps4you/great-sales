/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.sale;

import us.greatapps4you.greatsales.entities.registration.Address;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Sale implements Serializable {
    private Long sequential;
    private UUID uuid;
    private String orderNumber;
    private LocalDateTime orderTime;
    private Customer customer;
    private List<SaleItem> items;
    private BigDecimal totalAmount;

    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private Customer buyer;

    private String mailMessage;
    private String mailOrderTo;
    private String mailInvoiceTo;

    private LocalDate deliveryDate;
    private BigDecimal deliveryFee;
    private Carrier carrier;

    private BigDecimal commissionInCurrency;
    private BigDecimal commissionInPercentage;
    private BigDecimal taxInPercentage;

    private String customerOrderNumber;
    private String paymentConditions;

    private String observations;

    public Sale() {
    }

    public Sale(String orderNumber, Customer customer, Salesman salesman, String customerOrderNumber) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.salesman = salesman;
        this.customerOrderNumber = customerOrderNumber;
    }

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public String getMailMessage() {
        return mailMessage;
    }

    public void setMailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }

    public String getMailOrderTo() {
        return mailOrderTo;
    }

    public void setMailOrderTo(String mailOrderTo) {
        this.mailOrderTo = mailOrderTo;
    }

    public String getMailInvoiceTo() {
        return mailInvoiceTo;
    }

    public void setMailInvoiceTo(String mailInvoiceTo) {
        this.mailInvoiceTo = mailInvoiceTo;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public BigDecimal getCommissionInCurrency() {
        return commissionInCurrency;
    }

    public void setCommissionInCurrency(BigDecimal commissionInCurrency) {
        this.commissionInCurrency = commissionInCurrency;
    }

    public BigDecimal getCommissionInPercentage() {
        return commissionInPercentage;
    }

    public void setCommissionInPercentage(BigDecimal commissionInPercentage) {
        this.commissionInPercentage = commissionInPercentage;
    }

    public BigDecimal getTaxInPercentage() {
        return taxInPercentage;
    }

    public void setTaxInPercentage(BigDecimal taxInPercentage) {
        this.taxInPercentage = taxInPercentage;
    }

    public String getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    public void setCustomerOrderNumber(String customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
    }

    public String getPaymentConditions() {
        return paymentConditions;
    }

    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (!orderNumber.equals(sale.orderNumber)) return false;
        if (!orderTime.equals(sale.orderTime)) return false;
        if (!customer.equals(sale.customer)) return false;
        if (!totalAmount.equals(sale.totalAmount)) return false;
        return salesman.equals(sale.salesman);
    }

    @Override
    public int hashCode() {
        int result = orderNumber.hashCode();
        result = 31 * result + orderTime.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + salesman.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderTime=" + orderTime +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
