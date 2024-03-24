package com.calm.webdb.service;

import com.calm.webdb.entity.StockEntity;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StockService {
    public void updateStock(int stockId, double sellingPrice, double dow, double doc){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            StockEntity updateStockEntity = hibernateSession.get(StockEntity.class, stockId);
            updateStockEntity.setSellingPrice(sellingPrice);
            updateStockEntity.setDeliveryFeeColombo(dow);
            updateStockEntity.setDeliveryFeeOther(doc);
            hibernateSession.update(updateStockEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            hibernateSession.close();
        }
    }
}
