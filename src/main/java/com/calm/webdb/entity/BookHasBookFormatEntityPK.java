package com.calm.webdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class BookHasBookFormatEntityPK implements Serializable {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "book_format_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookFormatId;

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
        BookHasBookFormatEntityPK that = (BookHasBookFormatEntityPK) o;
        return bookId == that.bookId && bookFormatId == that.bookFormatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookFormatId);
    }
}
