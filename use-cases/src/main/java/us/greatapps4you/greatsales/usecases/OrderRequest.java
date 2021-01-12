/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.usecases;

import us.greatapps4you.greatsales.entities.order.Carrier;
import us.greatapps4you.greatsales.entities.order.Customer;
import us.greatapps4you.greatsales.entities.order.OrderItem;
import us.greatapps4you.greatsales.entities.order.Salesman;
import us.greatapps4you.greatsales.entities.registration.Address;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderRequest {
    private Long sequential;
    private Customer customer;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private Salesman salesman;
    private Address deliveryAddress;
    private Address billingAddress;
    private String mailMessage;
    private String mailOrderTo;
    private String invoiceTo;
    private LocalDate deliveryDate;
    private BigDecimal deliveryFee;
    private Carrier carrier;
    private BigDecimal commissionInCurrency;
    private BigDecimal commissionInPercentage;
    private BigDecimal taxInPercentage;
    private String customerOrderNumber;
    private String paymentConditions;
    private String observations;

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
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

    public String getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(String invoiceTo) {
        this.invoiceTo = invoiceTo;
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

        OrderRequest that = (OrderRequest) o;

        if (!customer.equals(that.customer)) return false;
        if (!totalAmount.equals(that.totalAmount)) return false;
        if (!deliveryAddress.equals(that.deliveryAddress)) return false;
        return customerOrderNumber.equals(that.customerOrderNumber);
    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + deliveryAddress.hashCode();
        result = 31 * result + customerOrderNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "sequential=" + sequential +
                ", customer=" + customer +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
