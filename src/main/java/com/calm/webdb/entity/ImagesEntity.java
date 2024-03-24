package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "images", schema = "my_book_shop_a", catalog = "")
public class ImagesEntity {
    @Id
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByProductId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesEntity that = (ImagesEntity) o;
        return productId == that.productId && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, productId);
    }

    public BookEntity getBookByProductId() {
        return bookByProductId;
    }

    public void setBookByProductId(BookEntity bookByProductId) {
        this.bookByProductId = bookByProductId;
    }
}
