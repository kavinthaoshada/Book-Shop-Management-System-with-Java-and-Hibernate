package com.calm.webdb.service;

import com.calm.webdb.entity.*;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CartService {
    public int addToCart(String userEmail, int stockId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        try {

            Query<CartEntity> query = session1.createQuery("SELECT c FROM CartEntity c " +
                            "WHERE c.usersEmail = :userEmail AND c.stockId = :stockId", CartEntity.class)
                    .setParameter("userEmail", userEmail)
                    .setParameter("stockId", stockId);
            List<CartEntity> cartItems = query.getResultList();
            int cartItemNumber = 0;
            int existCartQty = 0;
            int existCartID = 0;
            for (CartEntity cartItem : cartItems) {
                cartItemNumber++;
                existCartQty = cartItem.getQty();
                existCartID = cartItem.getId();
            }

//        CartEntity cartItem = query.uniqueResult();

            Query<StockEntity> query1 = session1.createQuery("SELECT s FROM StockEntity s " +
                            "WHERE s.id = :stockId", StockEntity.class)
                    .setParameter("stockId", stockId);
            StockEntity stock = query1.uniqueResult();

            int existStockProductQty = stock.getQty();

            if (cartItemNumber == 1) {
                int newCartQty = existCartQty + 1;
                if (existStockProductQty >= newCartQty) {
                    CartEntity updateCart = session1.get(CartEntity.class, existCartID);
                    updateCart.setQty(newCartQty);
                    session1.update(updateCart);
                    return 200;
                } else {
                    return 400;
                }
            } else {
                CartEntity insertCartItem = new CartEntity();
                insertCartItem.setStockId(stockId);
                insertCartItem.setUsersEmail(userEmail);
                insertCartItem.setQty(1);
                session1.save(insertCartItem);
                return 200;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session1.close();
        }
        return 500;
    }

    public int deleteFromCart(int cartId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        try {

        Query<CartEntity> query = session1.createQuery("SELECT c FROM CartEntity c " +
                       "INNER JOIN c.StockByStockId s " +
                       "WHERE c.id = :cartId", CartEntity.class)
                       .setParameter("cartId", cartId);
        CartEntity cartItem = query.uniqueResult();


            RecentEntity insertRecentItem = new RecentEntity();
            insertRecentItem.setBookId(cartItem.getStockByStockId().getBookId());
            insertRecentItem.setUsersEmail(cartItem.getUsersEmail());
            session1.save(insertRecentItem);

//            Query<CartEntity> query2 = session1.createQuery("DELETE FROM CartEntity c WHERE c.id = :cartId", CartEntity.class)
//                    .setParameter("cartId", cartId);
//            query2.executeUpdate();
            CartEntity cartEntity = session1.get(CartEntity.class, cartId);
            session1.delete(cartEntity);
            return 200;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session1.close();
        }
        return 500;
    }
}
