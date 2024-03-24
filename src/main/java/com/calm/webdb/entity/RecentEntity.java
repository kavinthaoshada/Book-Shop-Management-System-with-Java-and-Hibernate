package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recent", schema = "my_book_shop_a", catalog = "")
public class RecentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "users_email")
    private String usersEmail;

    public UsersEntity getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(UsersEntity usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByUsersEmail;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByBookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecentEntity that = (RecentEntity) o;
        return id == that.id && bookId == that.bookId && Objects.equals(usersEmail, that.usersEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, usersEmail);
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
