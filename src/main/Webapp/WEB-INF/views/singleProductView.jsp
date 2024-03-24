<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%
    String pid = request.getParameter("id");

    if (pid != null && !pid.isEmpty()) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Query<StockEntity> query = session1.createQuery("SELECT s FROM StockEntity s " +
                        "INNER JOIN s.bookByBookId WHERE s.id = :id", StockEntity.class)
                .setParameter("id", pid);
        List<StockEntity> stockProducts = query.getResultList();

//        transaction.commit();
//        session1.close();
        for(StockEntity stockProduct : stockProducts){

//$product_rs = Database::search("SELECT `book`.`id` AS `book_id`,`book`.`category_id`,
//`book`.`pages`,`book`.`language_id`,`book`.`edition_id`,
//`book`.`author_id`,`book`.`title`,`stock`.`id` AS `stock_id`,`stock`.`selling_price`,`stock`.`qty`,`book`.`description`,
//`book`.`condition_id`,`book`.`status_id`,`book`.`publisher_id` FROM `stock` INNER JOIN `book` ON
//`stock`.`book_id`=`book`.`id` WHERE `stock`.`id`='".$pid."'");
//
//$product_num = $product_rs->num_rows;
//
//if($product_num == 1){
//
//$product_data = $product_rs->fetch_assoc();



%>



<!DOCTYPE html>
<html>
<head>
    <title>Infinity | Single Product View</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="header.jsp"/>

        <div class="col-12 mt-0 bg-white singleproduct">
            <div class="row">

                <div class="col-12 shadow" style="padding: 11px;">
                    <div class="row">

                        <div class="col-12 col-lg-6 order-1 shadow">
                            <div class="row">
                                <div class="col-12 col-lg-6 order-2 order-lg-1">
                                    <ul>
                <%
                    Query<ImagesEntity> query1 = session1.createQuery("SELECT i FROM ImagesEntity i " +
                                    "WHERE i.productId = :productid", ImagesEntity.class)
                            .setParameter("productid", stockProduct.getBookByBookId().getId());
                    List<ImagesEntity> images = query1.getResultList();
                    String productImgCode = null;
                    for(ImagesEntity image : images){
                       productImgCode = image.getCode();
                %>

                                        <li class="d-flex flex-column justify-content-center align-items-center
                                    border border-secondary mb-1">
                                            <img src="<%= image.getCode() %>" class="img-thumbnail mt-1 mb-1"
                                            style="height: 50vh;" id="productImg" />
                                        </li>

                                        <%

                                         }

                                        %>


                                    </ul>
                                </div>

                                <div class="col-0 col-lg-6 order-2"></div>
                                <hr class="order-3"/>
                                <div class="col-12 order-4 shadow" style="background-color: rgb(234, 238, 195);">
                                    <div class="row">

                                        <div class="col-6">
                                            <span class="text-success fs-4">Pages : <%=stockProduct.getBookByBookId().getPages() %></span>
                                        </div>
                                        <%
                                            Query<EditionEntity> query2 = session1.createQuery("SELECT i FROM EditionEntity i " +
                                                            "WHERE i.id = :editionId", EditionEntity.class)
                                                    .setParameter("editionId", stockProduct.getBookByBookId().getEditionId());
//                                            List<EditionEntity> editions = query2.getResultList();
                                            EditionEntity edition = query2.uniqueResult();
                                        %>
                                        <div class="col-6">
                                            <span class="text-success fs-4">Edition : <%= edition.getName() %></span>
                                        </div>
                                        <%
                                            Query<LanguageEntity> query3 = session1.createQuery("SELECT i FROM LanguageEntity i " +
                                                            "WHERE i.id = :languageId", LanguageEntity.class)
                                                    .setParameter("languageId", stockProduct.getBookByBookId().getLanguageId());
                                            LanguageEntity language = query3.uniqueResult();
                                        %>

                                        <div class="col-6">
                                            <span class="text-success fs-4">Language : <%= language.getName() %></span>
                                        </div>
                                        <%
                                            Query<BookConditionEntity> query4 = session1.createQuery("SELECT i FROM BookConditionEntity i " +
                                                            "WHERE i.id = :conditionId", BookConditionEntity.class)
                                                    .setParameter("conditionId", stockProduct.getBookByBookId().getConditionId());
                                            BookConditionEntity condition = query4.uniqueResult();
                                        %>

                                        <div class="col-6">
                                            <span class="text-success fs-4">Condition : <%= condition.getName() %></span>
                                        </div>

                                        <div class="col-12">
                                            <span class="text-success fs-4">Description : <%= stockProduct.getBookByBookId().getDescription() %></span>
                                        </div>

                                    </div>
                                    <hr class="order-5"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 order-3 shadow" style="background-color: rgb(234, 238, 195);">
                            <div class="row">
                                <div class="col-12">

                                    <div class="row border-bottom border-dark">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="">Home</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">
                                                    Single Product View
                                                </li>
                                            </ol>
                                        </nav>
                                    </div>

                                    <div class="row border-bottom border-dark">
                                        <div class="col-12 my-2">
                                            <span class="fs-4 fw-bold text-success" id="ptitle"><%= stockProduct.getBookByBookId().getTitle() %></span>
                                        </div>
                                    </div>
                                    <%
                                        Query<AuthorEntity> query5 = session1.createQuery("SELECT i FROM AuthorEntity i " +
                                                        "WHERE i.id = :authorId", AuthorEntity.class)
                                                .setParameter("authorId", stockProduct.getBookByBookId().getAuthorId());
                                        AuthorEntity author = query5.uniqueResult();

                                        Query<PublisherEntity> query6 = session1.createQuery("SELECT i FROM PublisherEntity i " +
                                                        "WHERE i.id = :publisherId", PublisherEntity.class)
                                                .setParameter("publisherId", stockProduct.getBookByBookId().getPublisherId());
                                        PublisherEntity publisher = query6.uniqueResult();
                                    %>

                                    <div class="row border-bottom border-dark">
                                        <div class="col-12 my-2">
                                            <div class="row g-2">
                                                <div class="col-12 col-lg-12 border border-0 border-bottom-1 border-dark mb-2 text-center">
                                                    <span class="fs-4 text-info"><b>Author : </b><%= author.getName() %></span>
                                                </div>
                                                <div class="col-12 col-lg-12 border border-0 border-dark text-center">
                                                    <span class="fs-4 text-success"><b>Publisher : </b><%= publisher.getName() %></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row border-bottom border-dark">

                                        <div class="col-12 my-2">
                            <span class="badge">

                            <i class="bi bi-star-fill text-warning fs-5"></i>
                            <i class="bi bi-star-fill text-warning fs-5"></i>
                            <i class="bi bi-star-fill text-warning fs-5"></i>
                            <i class="bi bi-star-fill text-warning fs-5"></i>
                            <i class="bi bi-star-half text-warning fs-5"></i>

                            &nbsp;&nbsp;&nbsp;

                            <label class="fs-5 text-dark fw-bold">4.5 Stars | 35 Rating And Reviews</label>

                            </span>
                                        </div>

                                    </div>


                                    <div class="row border-bottom border-dark">
                                        <div class="col-12 my-2">

                                            <%
                                                double price = stockProduct.getSellingPrice();
                                                double addingPrice = (price/100)*5;
                                                double newPrice = price + addingPrice;
                                                double difference = newPrice - price;
                                                double percentage = (difference/price)*100;
                                            %>

                                            <span class="fs-4 fw-bold text-black" >Rs. </span>
                                            <span class="fs-4 fw-bold text-black" id="unitprice"><%= price %></span>
                                            <span class="fs-4 fw-bold text-black" >0</span>
                                            &nbsp;&nbsp; | &nbsp;&nbsp;
                                            <span class="fs-4 fw-bold text-danger"><del>Rs. <%= newPrice %>0</del></span>
                                            &nbsp;&nbsp; | &nbsp;&nbsp;
                                            <span class="fs-4 fw-bold text-black-50">Save Rs. <%= difference %>0 (<%= percentage %>%)</span>
                                        </div>
                                    </div>

                                    <div class="row border-bottom border-dark mb-3">
                                        <div class="col-12 my-2">
                                            <span class="fs-5 text-primary"><b>In-stock : </b><%= stockProduct.getQty() %> Items Available</span>
                                        </div>
                                    </div>



                                    <div class="row">
                                        <div class="col-12">
                                            <div class="row">
                                                <div class="offset-lg-2 col-12 col-lg-8 border border-1 border-danger rounded">
                                                    <div class="row">
                                                        <div class="col-3 col-lg-2 border-end border-1 border-danger">
                                                            <img src="assets/resources/pricetag.png" />
                                                        </div>
                                                        <div class="col-9 col-lg-10">
                                                <span class="fs-5 fw-bold text-warning">
                                                    Stand a chance to get 5% discount by using VISA or MASTER
                                                </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12">
                                            <div class="row">
                                                <div class="col-12 my-3">
                                                    <div class="row g-2">

                                                        <div class="border border-1 border-secondary rounded overflow-hidden
                                            float-start mt-1 position-relative product_qty">
                                                            <div class="col-12">
                                                                <span>Quantity : </span>
                                                                <input type="text" class="border-0 fs-5 fw-bold text-start"
                                                                       style="outline: none;" pattern="[0-9]" value="1"
                                                                       onkeyup='check_value(<%= stockProduct.getQty() %>);' id="qtyinput"/>

                                                                <div class="position-absolute qty_buttons">
                                                                    <div class="justify-content-center d-flex flex-column align-items-center border border-1
                                                     border-secondary qty_inc"><i class="bi bi-caret-up text-info fs-5" onclick="qty_inc(<%= stockProduct.getQty() %>);"></i>
                                                                    </div>
                                                                    <div class="justify-content-center d-flex flex-column align-items-center border border-1
                                                     border-secondary qty_inc"><i class="bi bi-caret-down text-info fs-5" onclick="qty_dec();"></i>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12 mt-5">
                                                                <div class="row">
                                                                    <div class="col-4 d-grid">
                                                                        <button class="btn btn-success" onclick="paynowproduct('<%= productImgCode %>',<%= stockProduct.getId() %>);">Buy Now</button>
                                                                    </div>
                                                                    <div class="col-4 d-grid">

                                                                        <%
                                                                            List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
                                                                            boolean existUser = false;
                                                                            String userEmail = null;
                                                                            if (users != null) {
                                                                                for (UsersEntity user : users) {
                                                                                    existUser = true;
                                                                                    userEmail = user.getEmail();
                                                                                }
                                                                            }
                                                                            if(existUser){
                                                                        %>
                                                                        <a href="#" onclick="addToCart(<%= stockProduct.getId() %>);" class="btn btn-danger col-12">Add to Cart</a>
                                                                        <%
                                                                            }else{
                                                                        %>
                                                                        <a href="#" class="btn btn-danger col-12">Add to Cart</a>
                                                                        <%
                                                                            }
                                                                        %>
                                                                    </div>
                                                                    <div class="col-4 d-grid">
                                                                        <%
                                                                            if(existUser){
                                                                                Query<WatchlistEntity> query7 = session1.createQuery("SELECT i FROM WatchlistEntity i " +
                                                                                                "WHERE i.stockId = :stockId AND i.usersEmail= :userEmail", WatchlistEntity.class)
                                                                                        .setParameter("stockId", stockProduct.getId())
                                                                                        .setParameter("userEmail", userEmail);
                                                                                List<WatchlistEntity> wls = query7.getResultList();
                                                                                boolean existWatchlist = false;
                                                                                for(WatchlistEntity wl : wls){
                                                                                    existWatchlist = true;
                                                                                }
                                                                            if(existWatchlist){
                                                                        %>
                                                                        <a class="btn btn-secondary col-12" onclick='addToWatchlist(<%= stockProduct.getId() %>);'>
                                                                            <i class="bi bi-heart-fill fs-5 text-danger" id="heart<%= stockProduct.getId() %>"></i>
                                                                        </a>
                                                                        <%
                                                                            }else{
                                                                        %>
                                                                        <a class="btn btn-secondary col-12" onclick='addToWatchlist(<%= stockProduct.getId() %>);'>
                                                                            <i class="bi bi-heart-fill fs-5 text-white" id="heart<%= stockProduct.getId() %>"></i>
                                                                        </a>
                                                                        <%
                                                                            }
                                                                          }else{
                                                                        %>
                                                                        <a class="btn btn-secondary col-12" >
                                                                            <i class="bi bi-heart-fill fs-5 text-danger"></i>
                                                                        </a>
                                                                        <%
                                                                         }

                                                                        %>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-12 bg-white">
                    <div class="row d-block me-0 mt-4 mb-3 border-bottom border-1 border-dark">
                        <div class="col-12">
                            <span class="fs-3 fw-bold">Related Items</span>
                        </div>
                    </div>
                </div>

                <div class="col-12 bg-white">
                    <div class="row g-2">

                        <%
                            Query<StockEntity> query8 = session1.createQuery("SELECT s FROM StockEntity s " +
                                            "INNER JOIN s.bookByBookId b " +
                                            "WHERE b.categoryId = :categoryid OR b.authorId= :authorId", StockEntity.class)
                                    .setParameter("categoryid", stockProduct.getBookByBookId().getCategoryId())
                                    .setParameter("authorId", stockProduct.getBookByBookId().getAuthorId())
                                    .setMaxResults(6);

                            List<StockEntity> relatedProducts = query8.getResultList();
                            for(StockEntity relatedProduct : relatedProducts){

                                Query<ImagesEntity> query9 = session1.createQuery("SELECT i FROM ImagesEntity i " +
                                                "WHERE i.productId = :productId", ImagesEntity.class)
                                        .setParameter("productId", relatedProduct.getBookByBookId().getId());
                                ImagesEntity relatetedProductImage = query9.uniqueResult();

                        %>

                        <div class="offset-1 offset-lg-1 col-4 col-lg-2">
                            <div class="card" style="width: 18rem;">
                                <img src="<%= relatetedProductImage.getCode() %>" class="card-img-top" style="width: 250px; height: 300px;"/>
                                <div class="card-body">
                                    <h4 class="card-title"><%= relatedProduct.getBookByBookId().getTitle() %></h4>
                                    <span class="fs-5 fw-bold">Rs. <%= relatedProduct.getSellingPrice() %>0</span>
                                    <div class="col-12">
                                        <div class="row g-1">
                                            <div class="col-12 d-grid">
                                                <a href='singleProductView?id=<%= relatedProduct.getId() %>' class="btn btn-primary">Buy Now</a>
                                            </div>
                                            <div class="col-12 d-grid">
                                                <a class="btn btn-primary" onclick="addToCart(<%= relatedProduct.getId() %>);">Add to Cart</a>
                                            </div>
                                            <div class="col-12 d-grid">
                                                <%
                                                    if(existUser){
                                                        Query<WatchlistEntity> query7 = session1.createQuery("SELECT i FROM WatchlistEntity i " +
                                                                        "WHERE i.stockId = :stockId AND i.usersEmail= :userEmail", WatchlistEntity.class)
                                                                .setParameter("stockId", relatedProduct.getId())
                                                                .setParameter("userEmail", userEmail);
                                                        List<WatchlistEntity> wls = query7.getResultList();
                                                        boolean existWatchlist = false;
                                                        for(WatchlistEntity wl : wls){
                                                            existWatchlist = true;
                                                        }
                                                        if(existWatchlist){
                                                %>
                                                <a class="btn btn-primary col-12 mt-1" onclick='addToWatchlist(<%= relatedProduct.getId() %>);'>
                                                    <i class="bi bi-heart-fill fs-5 text-danger" id="heart<%= relatedProduct.getId() %>"></i>
                                                </a>
                                                <%
                                                        }else{
                                                %>
                                                <a class="btn btn-primary col-12 mt-1" onclick='addToWatchlist(<%= relatedProduct.getId() %>);'>
                                                    <i class="bi bi-heart-fill fs-5 text-white" id="heart<%= relatedProduct.getId() %>"></i>
                                                </a>
                                                <%
                                                        }

                                                  }else{
                                                %>
                                                <button class="btn btn-primary">
                                                    <i class="bi bi-heart-fill fs-4 text-danger"></i>
                                                </button>
                                                <%
                                                  }
                                                %>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>



                        </div>
                        <%

                         }

                        %>

                    </div>
                </div>

                <div class="col-12">
                    <div class="row d-block me-0 mt-4 mb-3 border-bottom border-1 border-dark">
                        <div class="col-12">
                            <span class="fs-4 fw-bold">Product Details</span>
                        </div>
                    </div>
                </div>

                <div class="col-12 bg-white">
                    <div class="row">

                        <div class="col-6">
                            <div class="row">
                                <div class="col-3">
                                    <label class="form-label fs-4 fw-bold">Brand :</label>
                                </div>
                                <div class="col-9">
                                    <label class="form-label fs-4">Apple</label>
                                </div>
                            </div>
                        </div>

                        <div class="col-6">
                            <div class="row">
                                <div class="col-3">
                                    <label class="form-label fs-4 fw-bold">Model :</label>
                                </div>
                                <div class="col-9">
                                    <label class="form-label fs-4"> iPhone 12 </label>
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="row">
                                <div class="col-12">
                                    <label class="form-label fs-4 fw-bold">Description :</label>
                                </div>
                                <div class="col-12">
                                    <textarea class="form-control" cols="60" rows="10" disable></textarea>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>


        <jsp:include page="footer.jsp"/>
    </div>
</div>

<script src="assets/js/script.js"></script>
</body>
</html>

<%
        transaction.commit();
        session1.close();
      }
    }else{
%>
    <script>
        alert("Something went wrong.");
    </script>
<%
    }
%>
