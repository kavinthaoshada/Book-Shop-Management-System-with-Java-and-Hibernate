package com.calm.webdb.service;

import com.calm.webdb.entity.CartEntity;
import com.calm.webdb.entity.StockEntity;
import com.calm.webdb.entity.WatchlistEntity;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class WachlistService {

    public String addToWachlist(String userEmail, int stockId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        try {

            Query<WatchlistEntity> query = session1.createQuery("SELECT w FROM WatchlistEntity w " +
                            "WHERE w.usersEmail = :userEmail AND w.stockId = :stockId", WatchlistEntity.class)
                    .setParameter("userEmail", userEmail)
                    .setParameter("stockId", stockId);
            List<WatchlistEntity> watchlistItems = query.getResultList();
            int watchlistItemNumber = 0;
            int existWachlistID = 0;
            for (WatchlistEntity watchlistItem : watchlistItems) {
                watchlistItemNumber++;
                existWachlistID = watchlistItem.getId();
            }

            if (watchlistItemNumber == 1) {
                WatchlistEntity watchlistEntity = session1.get(WatchlistEntity.class, existWachlistID);
                session1.delete(watchlistEntity);
                return "removed";
            } else {
                WatchlistEntity insertWatchlistItem = new WatchlistEntity();
                insertWatchlistItem.setStockId(stockId);
                insertWatchlistItem.setUsersEmail(userEmail);
                session1.save(insertWatchlistItem);
                return "added";
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session1.close();
        }
        return "Error";
    }

}
