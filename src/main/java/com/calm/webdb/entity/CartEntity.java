package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cart", schema = "my_book_shop_a", catalog = "")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "qty")
    private Integer qty;
    @Basic
    @Column(name = "users_email")
    private String usersEmail;

    public UsersEntity getUsersByUsersEmail() {
        return UsersByUsersEmail;
    }

    public void setUsersByUsersEmail(UsersEntity usersByUsersEmail) {
        UsersByUsersEmail = usersByUsersEmail;
    }

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, insertable = false, updatable = false)
    private UsersEntity UsersByUsersEmail;
    @Basic
    @Column(name = "stock_id")
    private int stockId;

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private StockEntity StockByStockId;

    public StockEntity getStockByStockId() {
        return StockByStockId;
    }

    public void setStockByStockId(StockEntity stockByStockId) {
        StockByStockId = stockByStockId;
    }

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

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
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
        CartEntity that = (CartEntity) o;
        return id == that.id && stockId == that.stockId && Objects.equals(qty, that.qty) && Objects.equals(usersEmail, that.usersEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, usersEmail, stockId);
    }
}
