package com.calm.webdb.service;

import com.calm.webdb.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    @Test
    void ifCheckAdminExist() {
        // Set up mocks
        SessionFactory sessionFactoryMock = Mockito.mock(SessionFactory.class);
        Session sessionMock = Mockito.mock(Session.class);
        Transaction transactionMock = Mockito.mock(Transaction.class);
        Query queryMock = Mockito.mock(Query.class);

        // Configure mock behavior
        Mockito.when(sessionFactoryMock.openSession()).thenReturn(sessionMock);
        Mockito.when(sessionMock.beginTransaction()).thenReturn(transactionMock);
        // ... more configurations

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpEmail("admin@example.com");
        List<EmployeeEntity> employees = List.of(employeeEntity); // Create a list with a mock employee

        Mockito.when(sessionMock.createQuery("SELECT e FROM EmployeeEntity e WHERE e.empEmail = :email",
                        EmployeeEntity.class))
                .thenReturn(queryMock);
        Mockito.when(queryMock.setParameter("email", "admin@example.com")).thenReturn(queryMock);
        Mockito.when(queryMock.getResultList()).thenReturn(employees);

    }

    @Test
    public void testExistAdminFalse() {

    }

    @Test
    @Disabled
    void adminVerificationUpdate() {
    }

    @Test
    @Disabled
    void adminLogin() {
    }

    @Test
    @Disabled
    void checkVerificationCode() {
    }

    @Test
    @Disabled
    void employeeRegistration() {
    }

    @Test
    @Disabled
    void employeeBlockProcess() {
    }

    @Test
    @Disabled
    void generateUniqueId() {
    }
}