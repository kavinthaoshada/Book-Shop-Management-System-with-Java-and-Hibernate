package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "watchlist", schema = "my_book_shop_a", catalog = "")
public class WatchlistEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "users_email")
    private String usersEmail;
    @Basic
    @Column(name = "stock_id")
    private int stockId;
    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByUsersEmail;
    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private StockEntity stockByStockId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        WatchlistEntity that = (WatchlistEntity) o;
        return id == that.id && stockId == that.stockId && Objects.equals(usersEmail, that.usersEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersEmail, stockId);
    }

    public UsersEntity getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(UsersEntity usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }

    public StockEntity getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(StockEntity stockByStockId) {
        this.stockByStockId = stockByStockId;
    }
}
