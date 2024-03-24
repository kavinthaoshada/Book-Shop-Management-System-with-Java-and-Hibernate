package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grn_payment", schema = "my_book_shop_a", catalog = "")
public class GrnPaymentEntity {
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
    @Column(name = "payment_type_id")
    private int paymentTypeId;

    public PaymentTypeEntity getPaymentTypeByPaymentTypeId() {
        return PaymentTypeByPaymentTypeId;
    }

    public void setPaymentTypeByPaymentTypeId(PaymentTypeEntity paymentTypeByPaymentTypeId) {
        PaymentTypeByPaymentTypeId = paymentTypeByPaymentTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PaymentTypeEntity PaymentTypeByPaymentTypeId;
    @Basic
    @Column(name = "grn_id")
    private int grnId;
    @ManyToOne
    @JoinColumn(name = "grn_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private GrnEntity grnByGrnId;

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

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getGrnId() {
        return grnId;
    }

    public void setGrnId(int grnId) {
        this.grnId = grnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrnPaymentEntity that = (GrnPaymentEntity) o;
        return id == that.id && paymentTypeId == that.paymentTypeId && grnId == that.grnId && Objects.equals(payment, that.payment) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment, balance, paymentTypeId, grnId);
    }

    public GrnEntity getGrnByGrnId() {
        return grnByGrnId;
    }

    public void setGrnByGrnId(GrnEntity grnByGrnId) {
        this.grnByGrnId = grnByGrnId;
    }
}
