package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "my_book_shop_a", catalog = "")
public class UsersEntity {
    @Basic
    @Column(name = "fname")
    private String fname;
    @Basic
    @Column(name = "lname")
    private String lname;

    @Id
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "mobile")
    private String mobile;
    @Basic
    @Column(name = "joined_date")
    private Date joinedDate;
    @Basic
    @Column(name = "verification_code")
    private String verificationCode;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "gender_id")
    private int genderId;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private GenderEntity genderByGenderId;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return genderId == that.genderId && Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(mobile, that.mobile) && Objects.equals(joinedDate, that.joinedDate) && Objects.equals(verificationCode, that.verificationCode) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, email, password, mobile, joinedDate, verificationCode, status, genderId);
    }

    public GenderEntity getGenderByGenderId() {
        return genderByGenderId;
    }

    public void setGenderByGenderId(GenderEntity genderByGenderId) {
        this.genderByGenderId = genderByGenderId;
    }
}
