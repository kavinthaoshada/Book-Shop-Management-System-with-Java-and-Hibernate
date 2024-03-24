package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "grn", schema = "my_book_shop_a", catalog = "")
public class GrnEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date_time")
    private Date dateTime;
    @Basic
    @Column(name = "vendor_id")
    private int vendorId;

    public VendorEntity getVendorByVendor() {
        return VendorByVendor;
    }

    public void setVendorByVendor(VendorEntity vendorByVendor) {
        VendorByVendor = vendorByVendor;
    }

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private VendorEntity VendorByVendor;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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
        GrnEntity grnEntity = (GrnEntity) o;
        return id == grnEntity.id && vendorId == grnEntity.vendorId && Objects.equals(dateTime, grnEntity.dateTime) && Objects.equals(employeeEmpEmail, grnEntity.employeeEmpEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, vendorId, employeeEmpEmail);
    }

    public EmployeeEntity getEmployeeByEmployeeEmpEmail() {
        return employeeByEmployeeEmpEmail;
    }

    public void setEmployeeByEmployeeEmpEmail(EmployeeEntity employeeByEmployeeEmpEmail) {
        this.employeeByEmployeeEmpEmail = employeeByEmployeeEmpEmail;
    }
}
