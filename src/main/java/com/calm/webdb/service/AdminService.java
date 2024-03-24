package com.calm.webdb.service;

import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.entity.ProfileImageEntity;
import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.util.HibernateUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class AdminService {
    public boolean existAdmin(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Query<EmployeeEntity> query = session1.createQuery("SELECT e FROM EmployeeEntity e WHERE e.empEmail = :email", EmployeeEntity.class)
                .setParameter("email", email);
        List<EmployeeEntity> employees = query.getResultList();

        transaction.commit();
        session1.close();
        for(EmployeeEntity employee : employees){
            return true;
        }
        return false;
    }

    public String adminVerificationUpdate(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        EmployeeEntity employee = session.get(EmployeeEntity.class, email);
        String uniqueId = generateUniqueId();
        try {
                employee.setVerificationCode(uniqueId);
                session.update(employee);
                transaction.commit();
                return uniqueId;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    public boolean adminLogin(String verificationCode, HttpServletRequest request){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Query<EmployeeEntity> query = session1.createQuery("SELECT e FROM EmployeeEntity e WHERE e.verificationCode = :verificationCode", EmployeeEntity.class)
                .setParameter("verificationCode", verificationCode);
        List<EmployeeEntity> employees = query.getResultList();

        transaction.commit();
        session1.close();

        for(EmployeeEntity employee : employees){
            HttpSession session = request.getSession();
            session.setAttribute("a", employees);
            return true;
        }
        return false;

    }

    public boolean checkVerificationCode(String verificationCode, HttpServletRequest request){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Query<EmployeeEntity> query = session1.createQuery("SELECT e FROM EmployeeEntity e WHERE e.verificationCode = :verificationCode", EmployeeEntity.class)
                .setParameter("verificationCode", verificationCode);
        List<EmployeeEntity> employees = query.getResultList();

        transaction.commit();
        session1.close();

        for(EmployeeEntity employee : employees){
            return true;
        }
        return false;

    }

    public boolean employeeRegistration(String empEmail, String fname, String lname, String uname, String password,
                                        String mobile, int empType, Date joinedDate, int gender){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<EmployeeEntity> query = session.createQuery("SELECT e FROM EmployeeEntity e WHERE e.empEmail = :email", EmployeeEntity.class)
                .setParameter("email", empEmail);
        List<EmployeeEntity> emps = query.getResultList();
        boolean isEmpExist = false;
        for(EmployeeEntity emp : emps){
            isEmpExist = true;
        }
        try {
            if (isEmpExist) {
                return false;
            } else {
                EmployeeEntity insertEmployee = new EmployeeEntity();
                insertEmployee.setEmpEmail(empEmail);
                insertEmployee.setFname(fname);
                insertEmployee.setLname(lname);
                insertEmployee.setUsername(uname);
                insertEmployee.setPassword(password);
                insertEmployee.setMobile(mobile);
                insertEmployee.setEmployeeTypeId(empType);
                insertEmployee.setJoinedDate(joinedDate);
                insertEmployee.setStatus(1);
                insertEmployee.setGenderId(gender);
                session.save(insertEmployee);

                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public void employeeBlockProcess(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            Query<EmployeeEntity> employeeEntityQuery = hibernateSession.createQuery("SELECT e FROM EmployeeEntity e " +
                            "WHERE e.empEmail= :empEmail", EmployeeEntity.class)
                    .setParameter("empEmail", email);
            EmployeeEntity employee = employeeEntityQuery.uniqueResult();
            int newStatus = 0;
            if(employee.getStatus()==0){
                EmployeeEntity updateEmployee = hibernateSession.get(EmployeeEntity.class, employee.getEmpEmail());
                updateEmployee.setStatus(1);
                hibernateSession.update(updateEmployee);
                newStatus = 1;
            }else if(employee.getStatus()==1){
                EmployeeEntity updateEmployee = hibernateSession.get(EmployeeEntity.class, employee.getEmpEmail());
                updateEmployee.setStatus(0);
                hibernateSession.update(updateEmployee);
                newStatus = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            hibernateSession.close();
        }
    }

    public static String generateUniqueId() {
        // Generate a UUID (Universally Unique Identifier)
        UUID uuid = UUID.randomUUID();

        // Get the current timestamp
        long timestamp = System.currentTimeMillis();

        // Combine UUID and timestamp to create a unique identifier
        String uniqueId = uuid.toString().substring(0,5) + "_" + timestamp;

        return uniqueId;
    }
}
