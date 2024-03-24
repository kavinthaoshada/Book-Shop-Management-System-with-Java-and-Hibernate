package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "invoice", schema = "my_book_shop_a", catalog = "")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "order_id")
    private String orderId;
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
    @Basic
    @Column(name = "employee_emp_email")
    private String employeeEmpEmail;
    @ManyToOne
    @JoinColumn(name = "employee_emp_email", referencedColumnName = "emp_email", nullable = false, insertable = false, updatable = false)
    private EmployeeEntity employeeByEmployeeEmpEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getEmployeeEmpEmail() {
        return employeeEmpEmail;
    }

    public void setEmployeeEmpEmail(String employeeEmpEmail) {
        this.employeeEmpEmail = employeeEmpEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(status, that.status) && Objects.equals(orderId, that.orderId) && Objects.equals(usersEmail, that.usersEmail) && Objects.equals(employeeEmpEmail, that.employeeEmpEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, status, orderId, usersEmail, employeeEmpEmail);
    }

    public EmployeeEntity getEmployeeByEmployeeEmpEmail() {
        return employeeByEmployeeEmpEmail;
    }

    public void setEmployeeByEmployeeEmpEmail(EmployeeEntity employeeByEmployeeEmpEmail) {
        this.employeeByEmployeeEmpEmail = employeeByEmployeeEmpEmail;
    }
}
