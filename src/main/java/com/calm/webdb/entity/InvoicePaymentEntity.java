package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "invoice_payment", schema = "my_book_shop_a", catalog = "")
public class InvoicePaymentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "payment")
    private Double payment;
    @Basic
    @Column(name = "balance")
    private Double balance;
    @Basic
    @Column(name = "invoice_id")
    private int invoiceId;
    @Basic
    @Column(name = "payment_type_id")
    private int paymentTypeId;

    public PaymentTypeEntity getPaymentTypeByPaymentTypeId() {
        return paymentTypeByPaymentTypeId;
    }

    public void setPaymentTypeByPaymentTypeId(PaymentTypeEntity paymentTypeByPaymentTypeId) {
        this.paymentTypeByPaymentTypeId = paymentTypeByPaymentTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PaymentTypeEntity paymentTypeByPaymentTypeId;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private InvoiceEntity invoiceByInvoiceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicePaymentEntity that = (InvoicePaymentEntity) o;
        return id == that.id && invoiceId == that.invoiceId && paymentTypeId == that.paymentTypeId && Objects.equals(payment, that.payment) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment, balance, invoiceId, paymentTypeId);
    }

    public InvoiceEntity getInvoiceByInvoiceId() {
        return invoiceByInvoiceId;
    }

    public void setInvoiceByInvoiceId(InvoiceEntity invoiceByInvoiceId) {
        this.invoiceByInvoiceId = invoiceByInvoiceId;
    }
}
