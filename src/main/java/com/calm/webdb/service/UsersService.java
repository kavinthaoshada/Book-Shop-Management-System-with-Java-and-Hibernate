package com.calm.webdb.service;

import com.calm.webdb.entity.ProfileImageEntity;
import com.calm.webdb.entity.UserHasAddressEntity;
import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.util.HibernateUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Context;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UsersService {
    public void addUser(UsersEntity user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public boolean existUser(String email, String password, HttpServletRequest request){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Query<UsersEntity> query = session1.createQuery("SELECT u FROM UsersEntity u WHERE u.email = :email AND u.password = :password", UsersEntity.class)
                .setParameter("email", email)
                .setParameter("password", password);
        List<UsersEntity> users = query.getResultList();

        transaction.commit();
        session1.close();
        int n = 0;
        for(UsersEntity user : users){
            n++;
        }
        if(n==1){
            HttpSession session = request.getSession();
            session.setAttribute("u", users);
            return true;
        }
        return false;
    }

    public void updateProfileImageOfUser(String user_email, String file_path) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<ProfileImageEntity> query = session.createQuery("SELECT pi FROM ProfileImageEntity pi WHERE pi.usersEmail = :email", ProfileImageEntity.class)
                .setParameter("email", user_email);
        List<ProfileImageEntity> pImages = query.getResultList();
        transaction.commit();
        boolean isPImageExist = false;
        String pIPath = "empty";
        for(ProfileImageEntity pImage : pImages){
            isPImageExist = true;
            pIPath = pImage.getPath();
        }

        ProfileImageEntity profileImage = session.get(ProfileImageEntity.class, pIPath);
        try {
            if (isPImageExist) {
                profileImage.setPath(file_path);
                session.update(profileImage);
                transaction.commit();
            } else {
                ProfileImageEntity insertProfileImage = new ProfileImageEntity();
                insertProfileImage.setUsersEmail(user_email);
                insertProfileImage.setPath(file_path);
                session.save(insertProfileImage);
                transaction.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateUser(String user_email, String fname, String lname, String mobile) {
        System.out.println("in user update1");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<UsersEntity> query = session.createQuery("SELECT u FROM UsersEntity u WHERE u.email = :email", UsersEntity.class)
                .setParameter("email", user_email);
        List<UsersEntity> existUsers = query.getResultList();
        transaction.commit();
        boolean isUserExist = false;
        for(UsersEntity existUser : existUsers){
            isUserExist = true;
        }

        UsersEntity users = session.get(UsersEntity.class, user_email);
        try {
            System.out.println("in user update2");
            if (isUserExist) {
                users.setFname(fname);
                users.setLname(lname);
                users.setMobile(mobile);
                session.update(users);
                transaction.commit();
                System.out.println("in user update3");
            } else {
                throw new EntityNotFoundException("Employee with Email : " + user_email + " not found.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateUsersAddress(String user_email, String line1, String line2, int city, String postalCode) {
        System.out.println("in user addressUpdate1");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<UserHasAddressEntity> query = session.createQuery("SELECT uha FROM UserHasAddressEntity uha WHERE uha.usersEmail = :email", UserHasAddressEntity.class)
                .setParameter("email", user_email);
        List<UserHasAddressEntity> existUserAddresses = query.getResultList();
        transaction.commit();
        boolean isUHA = false;
        int uHAId = 0;
        for(UserHasAddressEntity existUserAddress : existUserAddresses){
            isUHA = true;
            uHAId = existUserAddress.getId();
        }

        System.out.println("in user addressUpdate2");
        UserHasAddressEntity userHasAddress = session.get(UserHasAddressEntity.class, uHAId);
        System.out.println("in user addressUpdate3");
        try {
            if (isUHA) {
                System.out.println("in user addressUpdate5");
                userHasAddress.setLine1(line1);
                userHasAddress.setLine2(line2);
                userHasAddress.setCityId(city);
                userHasAddress.setPostalCode(postalCode);
                session.update(userHasAddress);
                transaction.commit();
            } else {
                System.out.println("in user addressUpdate6");
                UserHasAddressEntity insertUserHasAddress = new UserHasAddressEntity();
                insertUserHasAddress.setUsersEmail(user_email);
                insertUserHasAddress.setLine1(line1);
                insertUserHasAddress.setLine2(line2);
                insertUserHasAddress.setCityId(city);
                insertUserHasAddress.setPostalCode(postalCode);
                session.save(insertUserHasAddress);
                transaction.commit();
                System.out.println("in user addressUpdate7");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void userBlockProcess(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            Query<UsersEntity> usersEntityQuery = hibernateSession.createQuery("SELECT u FROM UsersEntity u " +
                    "WHERE u.email= :userEmail", UsersEntity.class)
                    .setParameter("userEmail", email);
            UsersEntity user = usersEntityQuery.uniqueResult();
            int newStatus = 0;
            if(user.getStatus()==0){
                UsersEntity updateUser = hibernateSession.get(UsersEntity.class, user.getEmail());
                updateUser.setStatus(1);
                hibernateSession.update(updateUser);
                newStatus = 1;
            }else if(user.getStatus()==1){
                UsersEntity updateUser = hibernateSession.get(UsersEntity.class, user.getEmail());
                updateUser.setStatus(0);
                hibernateSession.update(updateUser);
                newStatus = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            hibernateSession.close();
        }
    }
}
