package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "stock", schema = "my_book_shop_a", catalog = "")
public class StockEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "qty")
    private Integer qty;
    @Basic
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "delivery_fee_colombo")
    private Double deliveryFeeColombo;
    @Basic
    @Column(name = "delivery_fee_other")
    private Double deliveryFeeOther;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByBookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Double getDeliveryFeeColombo() {
        return deliveryFeeColombo;
    }

    public void setDeliveryFeeColombo(Double deliveryFeeColombo) {
        this.deliveryFeeColombo = deliveryFeeColombo;
    }

    public Double getDeliveryFeeOther() {
        return deliveryFeeOther;
    }

    public void setDeliveryFeeOther(Double deliveryFeeOther) {
        this.deliveryFeeOther = deliveryFeeOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return id == that.id && bookId == that.bookId && Objects.equals(qty, that.qty) && Objects.equals(sellingPrice, that.sellingPrice) && Objects.equals(deliveryFeeColombo, that.deliveryFeeColombo) && Objects.equals(deliveryFeeOther, that.deliveryFeeOther);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, sellingPrice, bookId, deliveryFeeColombo, deliveryFeeOther);
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
