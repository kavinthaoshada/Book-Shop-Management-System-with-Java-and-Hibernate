package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grn_item", schema = "my_book_shop_a", catalog = "")
public class GrnItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "qty")
    private Integer qty;
    @Basic
    @Column(name = "buying_price")
    private Double buyingPrice;
    @Basic
    @Column(name = "grn_id")
    private int grnId;
    @Basic
    @Column(name = "stock_id")
    private int stockId;

    public StockEntity getStockByStockId() {
        return StockByStockId;
    }

    public void setStockByStockId(StockEntity stockByStockId) {
        StockByStockId = stockByStockId;
    }

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private StockEntity StockByStockId;
    @ManyToOne
    @JoinColumn(name = "grn_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private GrnEntity grnByGrnId;

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

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getGrnId() {
        return grnId;
    }

    public void setGrnId(int grnId) {
        this.grnId = grnId;
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
        GrnItemEntity that = (GrnItemEntity) o;
        return id == that.id && grnId == that.grnId && stockId == that.stockId && Objects.equals(qty, that.qty) && Objects.equals(buyingPrice, that.buyingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, buyingPrice, grnId, stockId);
    }

    public GrnEntity getGrnByGrnId() {
        return grnByGrnId;
    }

    public void setGrnByGrnId(GrnEntity grnByGrnId) {
        this.grnByGrnId = grnByGrnId;
    }
}
