package com.calm.webdb.service;

import com.calm.webdb.entity.CategoryEntity;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoryService {
    public boolean isExistCategory(String newCategory){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        Query<CategoryEntity> categoryEntityQuery = hibernateSession.createQuery("SELECT c FROM CategoryEntity c " +
                "WHERE c.name LIKE :newCategory")
                .setParameter("newCategory", "%"+newCategory+"%");
        CategoryEntity category = categoryEntityQuery.uniqueResult();
        transaction.commit();
        hibernateSession.close();
        if(!category.equals(null))
            return true;
        return false;
    }
    public void addNewCategory(String newCategory){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            CategoryEntity insertNewCategory = new CategoryEntity();
            insertNewCategory.setName(newCategory);
            hibernateSession.save(insertNewCategory);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            hibernateSession.close();
        }
    }

    public void deleteCategory(int categoryId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            CategoryEntity deleteCategory = hibernateSession.get(CategoryEntity.class, categoryId);
            hibernateSession.delete(deleteCategory);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            hibernateSession.close();
        }

    }
}
