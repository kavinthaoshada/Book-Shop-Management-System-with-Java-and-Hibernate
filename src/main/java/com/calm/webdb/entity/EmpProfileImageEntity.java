package com.calm.webdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "emp_profile_image", schema = "my_book_shop_a", catalog = "")
public class EmpProfileImageEntity {
    @Id
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "employee_emp_email")
    private String employeeEmpEmail;

    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeEmpEmail;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        employeeByEmployeeEmpEmail = employeeByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "employee_emp_email", referencedColumnName = "emp_email", nullable = false, insertable = false, updatable = false)
    private EmployeeEntity employeeByEmployeeEmpEmail;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        EmpProfileImageEntity that = (EmpProfileImageEntity) o;
        return Objects.equals(path, that.path) && Objects.equals(employeeEmpEmail, that.employeeEmpEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, employeeEmpEmail);
    }
}
