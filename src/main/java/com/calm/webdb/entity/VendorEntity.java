package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vendor", schema = "my_book_shop_a", catalog = "")
public class VendorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "mobile")
    private String mobile;
    @Basic
    @Column(name = "publication")
    private String publication;
    @Basic
    @Column(name = "status")
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorEntity that = (VendorEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(mobile, that.mobile) && Objects.equals(publication, that.publication) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile, publication, status);
    }
}
