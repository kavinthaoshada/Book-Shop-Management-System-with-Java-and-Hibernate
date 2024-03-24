<%@ page import="com.calm.webdb.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.WatchlistEntity" %>
<%@ page import="com.calm.webdb.entity.StockEntity" %>
<%@ page import="com.calm.webdb.entity.ImagesEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Infinity | Wachlist</title>
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
   <%
        session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
        List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
        if (users != null) {
        for (UsersEntity user : users) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session1 = sessionFactory.openSession();
            Transaction transaction = session1.beginTransaction();

   %>

        <div class="col-12">
            <div class="row">
                <div class="col-12 border border-1 border-secondary rounded">
                    <div class="row">

                        <div class="col-12">
                            <label class="form-label fs-1 fw-bolder">wachlist &hearts;</label>
                        </div>
                        <div class="col-12 col-lg-6">
                            <hr class="hr-break-1"/>
                        </div>

                        <div class="col-12">
                            <div class="row">
                                <div class="offset-lg-2 col-12 col-lg-6 mb-3">
                                    <input type="text" class="form-control" placeholder="Search In Wachlist..." id="txt"/>
                                </div>
                                <div class="col-12 col-lg-2 mb-3 d-grid">
                                    <button class="btn btn-outline-primary" onclick="basicSearchWatchlist(0,'<%= user.getEmail() %>')">Search</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <hr class="hr-break-1"/>
                        </div>
                        <div class="col-11 col-lg-2 border-0 border-end border-1 border-primary">

                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#" onclick="home();">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">wachlist</li>
                                </ol>
                            </nav>
                            <nav class="nav nav-pills flex-column">
                                <a class="nav-link active" aria-current="page" href="#">My Wachlist</a>
                                <a class="nav-link" href="cart">My Cart</a>
                                <a class="nav-link" href="#">Recents</a>
                            </nav>

                        </div>

                        <%
                            Query<WatchlistEntity> query = session1.createQuery("SELECT w FROM WatchlistEntity w " +
                                    "WHERE w.usersEmail= :usersEmail", WatchlistEntity.class)
                                    .setParameter("usersEmail", user.getEmail());
                            List<WatchlistEntity> watchlistItems = query.getResultList();


                        if(watchlistItems.isEmpty()){

                        %>

                        <!-- no item -->
                        <div class="col-12 col-lg-9">
                            <div class="row">
                                <div class="col-12 emptyView"></div>
                                <div class="col-12 text-center">
                                    <label class="form-label fs-1 fw-bold">
                                        You have no Item in your watchlist yet.
                                    </label>
                                </div>
                                <div class="offset-lg-4 col-12 col-lg-4 d-grid mb-3">
                                    <a href="home" class="btn btn-warning fs-3 fw-bold" onclick="home();">
                                        Start Shopping
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- no item -->



                        <%
                         }else{
                        %>
                        <!-- have products -->
                        <div class="col-12 col-lg-9" id="resultPage">
                            <div class="row g-2">
                                <%
                                    for(WatchlistEntity watchlistItem : watchlistItems){

                                    Query<StockEntity> query1 = session1.createQuery("SELECT s FROM StockEntity s " +
                                            "INNER JOIN s.bookByBookId b " +
                                            "INNER JOIN b.categoryByCategoryId c " +
                                            "INNER JOIN b.bookConditionByBookConditionId bc " +
                                            "INNER JOIN b.authorByAuthorId a " +
                                            "INNER JOIN b.publisherByPublisherId p " +
                                            "INNER JOIN b.languageBylanguageId l " +
                                            "INNER JOIN b.editionByEditionId e " +
                                            "WHERE s.id= :stockID", StockEntity.class)
                                            .setParameter("stockID", watchlistItem.getStockId());
                                    StockEntity stockItem = query1.uniqueResult();

                                    Query<ImagesEntity> query2 = session1.createQuery("SELECT i FROM ImagesEntity i " +
                                                    "WHERE i.productId= :productId", ImagesEntity.class)
                                            .setParameter("productId", stockItem.getBookId());
                                    ImagesEntity image = query2.uniqueResult();


                                %>



                                <div class="card mb-3 mx-0 mx-lg-2 col-12">
                                    <div class="row g-0">
                                        <div class="col-md-4">
                                            <img src="<%= image.getCode() %>" class="img-fluid rounded-start" style="height: 270px;"/>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="card-body">
                                                <h5 class="card-title fw-bold fs-2 text-success"><%= stockItem.getBookByBookId().getTitle() %></h5>
                                                <span class="fs-4 text-black-50">Author : <%= stockItem.getBookByBookId().getAuthorByAuthorId().getName() %></span>
                                                <br/>
                                                <span class="fs-5 fw-bold text-black-50">Condition : <%= stockItem.getBookByBookId().getConditionByConditionId().getName() %></span>
                                                <br/>
                                                <span class="fs-5 fw-bold text-black-50">Language : </span>
                                                <span class="fs-5 fw-bold text-black-50"><%= stockItem.getBookByBookId().getLanguageBylanguageId().getName() %></span>
                                                <br/>
                                                <span class="fs-5 fw-bold text-black-50">Price : </span>&nbsp;&nbsp;
                                                <span class="fs-5 fw-bold text-black">Rs. <%= stockItem.getSellingPrice() %>0</span>
                                                <br/>
                                                <span class="fs-5 fw-bold text-black-50">Quantity : </span>&nbsp;&nbsp;
                                                <span class="fs-5 fw-bold text-black"><%= stockItem.getQty() %> Items Available</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3 mt-4">
                                            <div class="card-body d-lg-grid">
                                                <a href='singleProductView?id=<%= stockItem.getId() %>' class="btn btn-outline-success mb-2">Buy Now</a>
                                                <a onclick="addToCart(<%= stockItem.getId() %>);" class="btn btn-outline-secondary mb-2">Add to Cart</a>
                                                <a class="btn btn-outline-danger" onclick="removeFromWatchlist(<%= watchlistItem.getId() %>);">Remove</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>



                            <%

                             }
                            %>
                            </div>
                        </div>
                        <!-- have products -->
                        <%
                        }

                        %>



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
    alert("Please Sign In First");
    fetch("", {
        method: "GET"
    }).then(response => response.text())
        .then(data => {
            document.open();
            document.write(data);
            document.close();
        });
</script>

<%
    }
%>

