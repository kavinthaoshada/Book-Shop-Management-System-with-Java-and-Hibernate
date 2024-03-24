package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "invoice_item", schema = "my_book_shop_a", catalog = "")
public class InvoiceItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "qty")
    private Integer qty;
    @Basic
    @Column(name = "invoice_id")
    private int invoiceId;
    @Basic
    @Column(name = "stock_id")
    private int stockId;

    public StockEntity getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(StockEntity stockByStockId) {
        this.stockByStockId = stockByStockId;
    }

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private StockEntity stockByStockId;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private InvoiceEntity invoiceByInvoiceId;

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

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItemEntity that = (InvoiceItemEntity) o;
        return id == that.id && invoiceId == that.invoiceId && stockId == that.stockId && Objects.equals(qty, that.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, invoiceId, stockId);
    }

    public InvoiceEntity getInvoiceByInvoiceId() {
        return invoiceByInvoiceId;
    }

    public void setInvoiceByInvoiceId(InvoiceEntity invoiceByInvoiceId) {
        this.invoiceByInvoiceId = invoiceByInvoiceId;
    }
}
