package com.calm.webdb.service;

import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.util.HibernateUtil;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {



    @Test
    void testIfAdminExists() {

        try (MockedStatic<HibernateUtil> mockedHibernateUtil = Mockito.mockStatic(HibernateUtil.class)) {

            // given
            SessionFactory sessionFactoryMock = Mockito.mock(SessionFactory.class);
            mockedHibernateUtil.when(HibernateUtil::getSessionFactory).thenReturn(sessionFactoryMock);

            Session sessionMock = Mockito.mock(Session.class);
            Transaction transactionMock = Mockito.mock(Transaction.class);
            Query queryMock = Mockito.mock(Query.class);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setEmpEmail("admin@example.com");
            List<EmployeeEntity> employees = List.of(employeeEntity);

            Mockito.when(sessionFactoryMock.openSession()).thenReturn(sessionMock);
            Mockito.when(sessionMock.beginTransaction()).thenReturn(transactionMock);

            Mockito.when(sessionMock.createQuery("SELECT e FROM EmployeeEntity e WHERE e.empEmail = :email", EmployeeEntity.class))
                    .thenReturn(queryMock);
            Mockito.when(queryMock.setParameter("email", "admin@example.com")).thenReturn(queryMock);
            Mockito.when(queryMock.getResultList()).thenReturn(employees);

            AdminService adminService = new AdminService();

            // when
            boolean adminExists = adminService.existAdmin("admin@example.com");

            // Verify that the necessary methods were invoked on mocks
            Mockito.verify(sessionFactoryMock).openSession();
            Mockito.verify(sessionMock).beginTransaction();
            Mockito.verify(sessionMock).createQuery("SELECT e FROM EmployeeEntity e WHERE e.empEmail = :email", EmployeeEntity.class);
            Mockito.verify(queryMock).setParameter("email", "admin@example.com");
            Mockito.verify(queryMock).getResultList();

            // then
            Assertions.assertThat(adminExists).isTrue();
        }
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