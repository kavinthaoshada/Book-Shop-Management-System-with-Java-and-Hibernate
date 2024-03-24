package com.calm.webdb.service;

import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.entity.VendorEntity;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class VendorService {
    public boolean vendorRegistration(String name, String mobile, String publication){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<VendorEntity> query = session.createQuery("SELECT v FROM VendorEntity v WHERE v.mobile = :mobile AND v.name= :name", VendorEntity.class)
                .setParameter("mobile", mobile)
                .setParameter("name", name);
        List<VendorEntity> vendors = query.getResultList();
        boolean isVendorExist = false;
        for(VendorEntity vendor : vendors){
            isVendorExist = true;
        }
        try {
            if (isVendorExist) {
                return false;
            } else {
                VendorEntity insertVendor = new VendorEntity();
                insertVendor.setName(name);
                insertVendor.setMobile(mobile);
                insertVendor.setPublication(publication);
                insertVendor.setStatus(1);
                session.save(insertVendor);
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

    public void vendorBlockProcess(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            Query<VendorEntity> vendorEntityQuery = hibernateSession.createQuery("SELECT v FROM VendorEntity v " +
                            "WHERE v.id= :id", VendorEntity.class)
                    .setParameter("id", id);
            VendorEntity vendor = vendorEntityQuery.uniqueResult();
            int newStatus = 0;
            if(vendor.getStatus()==0){
                VendorEntity updateVendor = hibernateSession.get(VendorEntity.class, id);
                updateVendor.setStatus(1);
                hibernateSession.update(updateVendor);
                newStatus = 1;
            }else if(vendor.getStatus()==1){
                VendorEntity updateVendor = hibernateSession.get(VendorEntity.class, id);
                updateVendor.setStatus(0);
                hibernateSession.update(updateVendor);
                newStatus = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            hibernateSession.close();
        }
    }

    public void vendorUpdate(int id, String mobile, String publication){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
                VendorEntity updateVendor = hibernateSession.get(VendorEntity.class, id);
                updateVendor.setMobile(mobile);
                updateVendor.setPublication(publication);
                hibernateSession.update(updateVendor);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            hibernateSession.close();
        }

    }


}
