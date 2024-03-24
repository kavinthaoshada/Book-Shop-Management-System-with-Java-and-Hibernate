package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "profile_image", schema = "my_book_shop_a", catalog = "")
public class ProfileImageEntity {

    @Id
    @Column(name = "path")
    private String path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        ProfileImageEntity that = (ProfileImageEntity) o;
        return Objects.equals(path, that.path) && Objects.equals(usersEmail, that.usersEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, usersEmail);
    }
}
