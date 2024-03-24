package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book_has_book_format", schema = "my_book_shop_a", catalog = "")
//@IdClass(BookHasBookFormatEntityPK.class)
public class BookHasBookFormatEntity {

    @Id
    @Column(name = "book_id")
    private int bookId;

    @Id
    @Column(name = "book_format_id")
    private int bookFormatId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByBookId;
    @ManyToOne
    @JoinColumn(name = "book_format_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookFormatEntity bookFormatByBookFormatId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookFormatId() {
        return bookFormatId;
    }

    public void setBookFormatId(int bookFormatId) {
        this.bookFormatId = bookFormatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookHasBookFormatEntity that = (BookHasBookFormatEntity) o;
        return bookId == that.bookId && bookFormatId == that.bookFormatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookFormatId);
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public BookFormatEntity getBookFormatByBookFormatId() {
        return bookFormatByBookFormatId;
    }

    public void setBookFormatByBookFormatId(BookFormatEntity bookFormatByBookFormatId) {
        this.bookFormatByBookFormatId = bookFormatByBookFormatId;
    }
}
