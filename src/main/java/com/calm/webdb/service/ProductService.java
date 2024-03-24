package com.calm.webdb.service;

import com.calm.webdb.entity.*;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService {

    public int insertAuthor(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<AuthorEntity> query = session.createQuery("SELECT a FROM AuthorEntity a WHERE a.name = :name", AuthorEntity.class)
                .setParameter("name", name);
        List<AuthorEntity> authors = query.getResultList();

        boolean isAuthorExist = false;
        int existAuthorId = 0;
        for(AuthorEntity author : authors){
            isAuthorExist = true;
            existAuthorId = author.getId();
        }
        try {
            if (isAuthorExist) {
                return existAuthorId;
            } else {
                AuthorEntity insertAuthor = new AuthorEntity();
                insertAuthor.setName(name);
                int authorId = (int) session.save(insertAuthor);

                return authorId;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public int insertPublisher(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<PublisherEntity> query = session.createQuery("SELECT p FROM PublisherEntity p WHERE p.name = :name", PublisherEntity.class)
                .setParameter("name", name);
        List<PublisherEntity> publishers = query.getResultList();

        boolean isPublisherExist = false;
        int existPublisherId = 0;
        for(PublisherEntity publisher : publishers){
            isPublisherExist = true;
            existPublisherId = publisher.getId();
        }
        try {
            if (isPublisherExist) {
                return existPublisherId;
            } else {
                PublisherEntity insertPublisher = new PublisherEntity();
                insertPublisher.setName(name);
                int publisherId = (int) session.save(insertPublisher);

                return publisherId;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public int insertBook(String title, String description, int pages, int category, int condition,
                          int author, int publisher, int language, int edition) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
                BookEntity insertBook = new BookEntity();
                insertBook.setTitle(title);
                insertBook.setDescription(description);
                insertBook.setPages(pages);
                insertBook.setCategoryId(category);
                insertBook.setStatusId(1);
                insertBook.setConditionId(condition);
                insertBook.setAuthorId(author);
                insertBook.setPublisherId(publisher);
                insertBook.setLanguageId(language);
                insertBook.setEditionId(edition);
                int bookId = (int) session.save(insertBook);
                transaction.commit();
                return bookId;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            session.close();
        }
    }

    public void insertBookHasBookFormat(int hardFormat, int eFormat, int book) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            if(hardFormat != 0 && eFormat == 0){
                BookHasBookFormatEntity insertBookHasBookFormat = new BookHasBookFormatEntity();
                insertBookHasBookFormat.setBookId(book);
                insertBookHasBookFormat.setBookFormatId(1);
                session.save(insertBookHasBookFormat);

            }else if(hardFormat == 0 && eFormat != 0){
                BookHasBookFormatEntity insertBookHasBookFormat = new BookHasBookFormatEntity();
                insertBookHasBookFormat.setBookId(book);
                insertBookHasBookFormat.setBookFormatId(2);
                session.save(insertBookHasBookFormat);

            }else if(hardFormat != 0 && eFormat != 0){
                for(int i=1; i<=2; i++){
                    BookHasBookFormatEntity insertBookHasBookFormat = new BookHasBookFormatEntity();
                    insertBookHasBookFormat.setBookId(book);
                    insertBookHasBookFormat.setBookFormatId(i);
                    session.save(insertBookHasBookFormat);

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public void insertProductImage(String fileName, int book) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ImagesEntity insertImage = new ImagesEntity();
            insertImage.setCode(fileName);
            insertImage.setProductId(book);
            session.save(insertImage);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
