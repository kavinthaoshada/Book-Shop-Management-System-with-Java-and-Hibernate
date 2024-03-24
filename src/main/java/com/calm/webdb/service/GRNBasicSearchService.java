package com.calm.webdb.service;

import com.calm.webdb.entity.*;
import com.calm.webdb.util.HibernateUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GRNBasicSearchService {

    public String basicSearch(String searchText, int searchSelect, int page){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        String searchQuery = "SELECT b FROM BookEntity b ";
        Query<BookEntity> query = null;
        if(searchText!=null && searchSelect==0){
            searchQuery += "WHERE b.title LIKE :searchText";
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchText", "%"+searchText+"%");
        }else if(searchText==null && searchSelect!=0){
            searchQuery += "WHERE b.categoryId= :searchSelect";
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchSelect", searchSelect);
        }else if(searchText!=null && searchSelect!=0){
            searchQuery += "WHERE b.title LIKE :searchText AND b.categoryId= :searchSelect";
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchText", "%"+searchText+"%")
                    .setParameter("searchSelect", searchSelect);
        }

        String returnQuery = "<div class=\"row\">\n" +
                "\n" +
                "<div class=\"offset-lg-1 col-12 col-lg-10 text-center\">\n" +
                "    <div class=\"row\">\n";

        int pageNo = 1;
        if(page != 0){
            pageNo = page;
        }

        List<BookEntity> books = query.getResultList();
        int bookNo=0;
        for(BookEntity book : books){
            bookNo++;
        }
        int resultsPerPage = 6;
        int numberOfPage = (bookNo/resultsPerPage);
        int viewedResult = (pageNo - 1) * resultsPerPage;

        if(searchText!=null && searchSelect==0){
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchText", "%"+searchText+"%")
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        }else if(searchText==null && searchSelect!=0){
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchSelect", searchSelect)
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        }else if(searchText!=null && searchSelect!=0){
            query = session1.createQuery(searchQuery, BookEntity.class)
                    .setParameter("searchText", "%"+searchText+"%")
                    .setParameter("searchSelect", searchSelect)
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        }

        List<BookEntity> viewBooks = query.getResultList();
        for(BookEntity viewBook : viewBooks){
            returnQuery += "<div class=\"card mb-3 mt-3 col-12 col-lg-6\">\n" +
                    "                                    <div class=\"row\">\n" +
                    "\n" +
                    "                                    <div class=\"col-md-4 mt-4\">";

            Query<ImagesEntity> query1 = session1.createQuery("SELECT i FROM ImagesEntity i WHERE i.productId = :bookId", ImagesEntity.class)
                    .setParameter("bookId", viewBook.getId());
            List<ImagesEntity> images = query1.getResultList();
            String code = null;
            for(ImagesEntity image : images){
                code = image.getCode();
            }
            returnQuery += "<img src=\""+code+"\" class=\"img-fluid rounded-start\" alt=\"...\">\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"col-md-8\">\n" +
                    "                                        <div class=\"card-body\">\n" +
                    "\n" +
                    "                                            <h5 class=\"card-title fw-bold\" id=\"title\">"+viewBook.getTitle()+"</h5>";

            Query<AuthorEntity> query2 = session1.createQuery("SELECT i FROM AuthorEntity i WHERE i.id = :authorId", AuthorEntity.class)
                    .setParameter("authorId", viewBook.getAuthorId());
            List<AuthorEntity> authors = query2.getResultList();
            String authorName = null;
            for(AuthorEntity author : authors){
                authorName = author.getName();
            }
            returnQuery += "<span class=\"card-text text-primary fw-bold\">Author : "+authorName+"</span>\n" +
                    "\n" +
                    "                                            <br />";

            Query<PublisherEntity> query3 = session1.createQuery("SELECT i FROM PublisherEntity i WHERE i.id = :publisherId", PublisherEntity.class)
                    .setParameter("publisherId", viewBook.getPublisherId());
            List<PublisherEntity> publishers = query3.getResultList();
            String publisherName = null;
            for(PublisherEntity publisher : publishers){
                publisherName = publisher.getName();
            }
            returnQuery += "<span class=\"card-text text-success fw-bold fs\">Publisher : "+publisherName+"</span>\n" +
                    "\n" +
                    "                                            <br />";

            Query<EditionEntity> query4 = session1.createQuery("SELECT i FROM EditionEntity i WHERE i.id = :editionId", EditionEntity.class)
                    .setParameter("editionId", viewBook.getEditionId());
            List<EditionEntity> editions = query4.getResultList();
            String editionName = null;
            for(EditionEntity edition : editions){
                editionName = edition.getName();
            }
            returnQuery += "<span class=\"card-text text-success fw-bold fs\">Edition : "+editionName+"</span>\n" +
                    "\n" +
                    "                                            <br />";

            Query<BookConditionEntity> query5 = session1.createQuery("SELECT i FROM BookConditionEntity i WHERE i.id = :conditionId", BookConditionEntity.class)
                    .setParameter("conditionId", viewBook.getConditionId());
            List<BookConditionEntity> conditions = query5.getResultList();
            String conditionName = null;
            for(BookConditionEntity condition : conditions){
                conditionName = condition.getName();
            }
            returnQuery += "<span class=\"card-text text-success fw-bold fs\">Condition : "+conditionName+"</span>\n" +
                    "\n" +
                    "                                            <br />";

            Query<LanguageEntity> query6 = session1.createQuery("SELECT i FROM LanguageEntity i WHERE i.id = :languageId", LanguageEntity.class)
                    .setParameter("languageId", viewBook.getLanguageId());
            List<LanguageEntity> languages = query6.getResultList();
            String languageName = null;
            for(LanguageEntity language : languages){
                languageName = language.getName();
            }
            returnQuery += "<span class=\"card-text text-success fw-bold fs\">Language : "+languageName+"</span>\n" +
                    "\n" +
                    "                                            <br />\n" +
                    "\n" +
                    "                                            <span class=\"card-text text-success fw-bold fs\">Book Format : ";

            Query<BookHasBookFormatEntity> query7 = session1.createQuery("SELECT i FROM BookHasBookFormatEntity i INNER JOIN i.bookFormatByBookFormatId bf WHERE i.bookId = :bookId", BookHasBookFormatEntity.class)
                    .setParameter("bookId", viewBook.getId());
            List<BookHasBookFormatEntity> formats = query7.getResultList();
            for(BookHasBookFormatEntity format : formats){
                returnQuery += format.getBookFormatByBookFormatId().getName()+" ";
            }
            returnQuery += "</span>\n" +
                    "\n" +
                    "                                            <div class=\"row\">\n" +
                    "                                                <div class=\"col-12\">\n" +
                    "\n" +
                    "                                                    <div class=\"row g-1\">\n" +
                    "                                                        <div class=\"col-12 col-lg-12 d-grid\">\n" +
                    "                                                            <a href=\"#\" class=\"btn btn-success fs\" onclick=\"setId("+viewBook.getId()+",'"+viewBook.getTitle()+"');\">Select</a>\n" +
                    "                                                        </div>\n" +
                    "                                                    </div>\n" +
                    "\n" +
                    "                                                </div>\n" +
                    "                                            </div>\n" +
                    "\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                </div>\n" +
                    "                            </div>";

            }
        returnQuery += "</div>\n" +
                "</div>\n" +
                "\n" +
                "                <div class=\"col-12 text-center\">\n" +
                "\n" +
                "                    <div class=\"pagination justify-content-center\">\n" +
                "                        <a ";

        if(pageNo<=1){
            returnQuery += "href=#";
        }else {
            returnQuery += "onclick=\"basicSearch('"+(pageNo-1)+"');\"";
        }
        returnQuery += ">&laquo;</a>";

        for(int pg = 1; pg<=numberOfPage; pg++){
            if(pg == pageNo){
                returnQuery += "<a onclick=\"basicSearch('"+pg+"');\" class=\"active\">"+pg+"</a>";
            }else{
                returnQuery += "<a onclick=\"basicSearch('"+pg+"');\">"+pg+"</a>";
            }
        }
        returnQuery += "<a ";

        if(pageNo >= numberOfPage){
            returnQuery += "href=#";
        }else{
            returnQuery += "onclick=\"basicSearch('"+(pageNo+1)+"');\"";
        }

        returnQuery += ">&raquo;</a>\n" +
                "                    </div>\n" +
                "\n" +
                "                </div>\n" +
                "\n" +
                "</div>";


        transaction.commit();
        session1.close();

        return returnQuery;

    }

}
