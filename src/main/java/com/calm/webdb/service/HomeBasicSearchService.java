package com.calm.webdb.service;

import com.calm.webdb.entity.BookEntity;
import com.calm.webdb.entity.ImagesEntity;
import com.calm.webdb.entity.StockEntity;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HomeBasicSearchService {

    public String basicSearch(String searchText, int searchSelect, int page) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        String searchQuery = "SELECT s FROM StockEntity s " +
                "INNER JOIN s.bookByBookId b " +
                "INNER JOIN b.bookConditionByBookConditionId bc " +
                "INNER JOIN b.authorByAuthorId a " +
                "INNER JOIN b.publisherByPublisherId p " +
                "INNER JOIN b.languageBylanguageId l ";
        Query<StockEntity> query = null;
        if (searchText != null && searchSelect == 0) {
            searchQuery += "WHERE b.title LIKE :searchText";
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchText", "%" + searchText + "%");
        } else if (searchText == null && searchSelect != 0) {
            searchQuery += "WHERE b.categoryId= :searchSelect";
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchSelect", searchSelect);
        } else if (searchText != null && searchSelect != 0) {
            searchQuery += "WHERE b.title LIKE :searchText AND b.categoryId= :searchSelect";
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchText", "%" + searchText + "%")
                    .setParameter("searchSelect", searchSelect);
        }

        String returnQuery = "<div class=\"row\">\n" +
                "\n" +
                "<div class=\"offset-lg-1 col-12 col-lg-10 text-center\">\n" +
                "    <div class=\"row\">\n";

        int pageNo = 1;
        if (page != 0) {
            pageNo = page;
        }

        List<StockEntity> books = query.getResultList();
        int bookNo = 0;
        for (StockEntity book : books) {
            bookNo++;
        }
        int resultsPerPage = 6;
        int numberOfPage = (bookNo / resultsPerPage);
        int viewedResult = (pageNo - 1) * resultsPerPage;

        if (searchText != null && searchSelect == 0) {
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchText", "%" + searchText + "%")
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        } else if (searchText == null && searchSelect != 0) {
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchSelect", searchSelect)
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        } else if (searchText != null && searchSelect != 0) {
            query = session1.createQuery(searchQuery, StockEntity.class)
                    .setParameter("searchText", "%" + searchText + "%")
                    .setParameter("searchSelect", searchSelect)
                    .setMaxResults(resultsPerPage)
                    .setFirstResult(viewedResult);
        }
        List<StockEntity> viewBooks = query.getResultList();
        for (StockEntity viewBook : viewBooks) {
            returnQuery += "<div class=\"card mb-3 mt-3 col-12 col-lg-6\">\n" +
                    "                                    <div class=\"row\">\n" +
                    "\n" +
                    "                                    <div class=\"col-md-4 mt-4\">";

            Query<ImagesEntity> query1 = session1.createQuery("SELECT i FROM ImagesEntity i WHERE i.productId = :bookId", ImagesEntity.class)
                    .setParameter("bookId", viewBook.getId());
            List<ImagesEntity> images = query1.getResultList();
            String code = null;
            for (ImagesEntity image : images) {
                code = image.getCode();
            }
            returnQuery += "<img src=\"" + code + "\" class=\"img-fluid rounded-start\" alt=\"...\">\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"col-md-8\">\n" +
                    "                                        <div class=\"card-body\">\n" +
                    "\n" +
                    "                                            <h5 class=\"card-title fw-bold\" id=\"title\">" + viewBook.getBookByBookId().getTitle() + "</h5>\n" +
                    "\n" +
                    "                                            <span class=\"card-text text-primary fw-bold\">Rs." + viewBook.getSellingPrice() + "0</span>\n" +
                    "\n" +
                    "                                            <br />";
            if (viewBook.getQty() > 0) {
                returnQuery += "<span class=\"card-text text-warning\"><b>In Stock</b></span>\n" +
                        "                                            <br />\n" +
                        "                                            <span class=\"card-text text-success fw-bold\">" + viewBook.getQty() + " Items Available</span>\n" +
                        "                                            <div class=\"row\">\n" +
                        "                                                <div class=\"col-12\">\n" +
                        "\n" +
                        "                                                    <div class=\"row g-1\">\n" +
                        "                                                        <div class=\"col-12 col-lg-6 d-grid\">\n" +
                        "                                                            <a href=\"#\" class=\"btn btn-success fs\">Buy Now</a>\n" +
                        "                                                        </div>\n" +
                        "                                                        <div class=\"col-12 col-lg-6 d-grid\">\n" +
                        "                                                            <a href=\"#\" class=\"btn btn-danger fs\">Add Cart</a>\n" +
                        "                                                        </div>\n" +
                        "                                                    </div>\n" +
                        "\n" +
                        "                                                </div>\n" +
                        "                                            </div>";
            } else {
                returnQuery += "<span class=\"card-text text-danger\"><b>Out of Stock</b></span>\n" +
                        "                                            <br />\n" +
                        "                                            <span class=\"card-text text-success fw-bold\">00 Items Available</span>\n" +
                        "                                            <div class=\"row\">\n" +
                        "                                                <div class=\"col-12\">\n" +
                        "\n" +
                        "                                                    <div class=\"row g-1\">\n" +
                        "                                                        <div class=\"col-12 col-lg-6 d-grid\">\n" +
                        "                                                            <a href=\"#\" class=\"btn btn-success fs\" style=\"pointer-events: none;\">Buy Now</a>\n" +
                        "                                                        </div>\n" +
                        "                                                        <div class=\"col-12 col-lg-6 d-grid\">\n" +
                        "                                                            <a href=\"#\" class=\"btn btn-danger fs\">Add Cart</a>\n" +
                        "                                                        </div>\n" +
                        "                                                    </div>\n" +
                        "\n" +
                        "                                                </div>\n" +
                        "                                            </div>";
            }
            returnQuery += "</div>\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                </div>\n" +
                    "                            </div>";

        }
        if(viewBooks.size()<1){
            returnQuery += "<div class=\"col-12 col-lg-8 offset-lg-2 rounded text-center\" >\n" +
                    "                                        <img src=\"resources/box.png\"/>\n" +
                    "                                        <div class=\"row\">\n" +
                    "                                            <div class=\"col-12 text-center\">\n" +
                    "                                                <h1>Not found!..</h1>\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </div>";
        }
        returnQuery += "</div>\n" +
                "</div>\n" +
                "\n" +
                "                <div class=\"col-12 text-center\">\n" +
                "\n" +
                "                    <div class=\"pagination justify-content-center\">";
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
