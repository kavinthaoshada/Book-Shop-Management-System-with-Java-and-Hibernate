package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "my_book_shop_a", catalog = "")
public class EmployeeEntity {
    @Id
    @Column(name = "emp_email")
    private String empEmail;
    @Basic
    @Column(name = "fname")
    private String fname;
    @Basic
    @Column(name = "lname")
    private String lname;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "mobile")
    private String mobile;
    @Basic
    @Column(name = "employee_type_id")
    private int employeeTypeId;

    public EmployeeTypeEntity getEmployeeTypeByEmployeeTypeId() {
        return EmployeeTypeByEmployeeTypeId;
    }

    public void setEmployeeTypeByEmployeeTypeId(EmployeeTypeEntity employeeTypeByEmployeeTypeId) {
        EmployeeTypeByEmployeeTypeId = employeeTypeByEmployeeTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "employee_type_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private EmployeeTypeEntity EmployeeTypeByEmployeeTypeId;
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

    public GenderEntity getGenderByGenderId() {
        return GenderByGenderId;
    }

    public void setGenderByGenderId(GenderEntity genderByGenderId) {
        GenderByGenderId = genderByGenderId;
    }

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private GenderEntity GenderByGenderId;

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
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
        EmployeeEntity that = (EmployeeEntity) o;
        return employeeTypeId == that.employeeTypeId && genderId == that.genderId && Objects.equals(empEmail, that.empEmail) && Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(mobile, that.mobile) && Objects.equals(joinedDate, that.joinedDate) && Objects.equals(verificationCode, that.verificationCode) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empEmail, fname, lname, username, password, mobile, employeeTypeId, joinedDate, verificationCode, status, genderId);
    }

}
