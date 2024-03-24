<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.hibernate.query.Query" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Home</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="header.jsp"/>

        <hr class="hr-break-1" />

        <div class="col-12 justify-content-center">
            <div class="row mb-3">

                <div class="col-4 col-lg-1 offset-4 offset-lg-1 logo-img"></div>

                <div class="col-8 col-lg-6">
                    <div class="input-group input-group-lg mt-3 mb-3">
                        <input type="text" class="form-control" aria-label="Text input with dropdown button" id="basic_search_txt"  placeholder="Serch by name, category, author.." />

                        <select class="btn btn-outline-primary" id="basic_search_select">

                            <option value="0" readonly>Select Category</option>


                            <%
                                // Assuming Database is a Java class with a search method
                                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                Session hibernateSession = sessionFactory.openSession();
                                Transaction transaction = hibernateSession.beginTransaction();

                                List<CategoryEntity> categories = hibernateSession.createQuery("FROM CategoryEntity", CategoryEntity.class).list();

//                                transaction.commit();
//                                session1.close();
                                StringBuilder options = new StringBuilder();
                                for (CategoryEntity category : categories) {
                                    options.append("<option value=\"").append(category.getId()).append("\">")
                                            .append(category.getName()).append("</option>");
                                %>

                                <option value="<%= category.getId()%>"><%= category.getName()%></option>

                                <%
                                }
                                %>


                        </select>

                    </div>
                </div>

                <div class="col-2 d-grid gap-2">
                    <button class="btn btn-outline-primary mt-3 search-btn shadow-sm" onclick="basicSearchHome(0);">Search</button>
                    <!-- <button class="btn btn-outline-primary ">Search</button> -->
                </div>
                <!-- <div class="col-1">
                        <label class="form-label fs-3 bi bi-search text-blue"></label>
                </div> -->

                <div class="col-2 mt-4">
                    <a href="advancedSearch.php" class="link-secondary link-1">Advanced</a>
                </div>

            </div>
        </div>

        <hr class="hr-break-1" />

        <div class="col-12 shadow-sm" id="basicSearchResult">

            <div class="col-12 d-none d-lg-block">
                <div class="row">
                    <div id="carouselExampleCaptions" class="col-8 offset-2 carousel slide shadow rounded" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="assets/resources/crousel_img/Award-Winners-2020.png" class="d-block poster-img-1">
                                <div class="carousel-caption d-none d-md-block poster-caption">
                                    <h5 class="poster-title">Welcome to Infinity</h5>
                                    <p class="poster-text">The World's Best Online Bookshop.</p>
                                </div>
                            </div>

                            <div class="carousel-item">
                                <img src="assets/resources/crousel_img/books2.jpg" class="d-block poster-img-1">
                            </div>
                            <div class="carousel-item">
                                <img src="assets/resources/crousel_img/Homepage.jpg" class="d-block poster-img-1">
                                <div class="carousel-caption d-none d-md-block poster-caption-1">
                                    <h5 class="poster-title">Be Free...</h5>
                                    <p class="poster-text">Experience the Lowest Delivery Costs With Us.</p>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>

            <hr class="hr-break-1" />

            <div class="col-12">
                <div class="row">

                    <div class="col-12 col-lg-6">
                        <div class="row my-3 mx-3">

                            <div class="card text-bg-light mb-3 shodowC1" style="max-width: 95%;">
                                <div class="card-header">Our Brand</div>
                                <div class="card-body">
                                    <h5 class="card-title">Find your choice to read</h5>
                                    <p class="card-text">Every book or e-book you buy from us comes with our guarantee and easy discount. Join Infinity book shop for your best choice.</p>
                                </div>
                            </div>

                            <div class="mask1 d-sm-none d-lg-block">
                                <img src="assets/resources/carousel2/freddie-marriage-w8JiSVyjy-8-unsplash.jpg" class="imgSize" alt="Cinque Terre" width="600" height="400">
                            </div>

                        </div>
                    </div>


                    <div class="col-12 col-lg-6">
                        <div class="row">

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/Harry-Potter-and-the-Philosophers-Stone.jpeg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">Harry Potter and the Philosophers Stone</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/mother-maxim-gorky.jpg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">Mother - Maxim Gorky</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/oliver twist.jpg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">Oliver Twist</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/the communist manifesto-karl marx.jpg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">The Communist Manifesto -Karl Marx</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/notebooks of leanardo da vinci.jpg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">Notebooks of Leanardo da vinci</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-5 col-lg-3 my-3 mx-4">
                                <div class="card bg-dark text-white">
                                    <img src="assets/resources/books_img/big_bang_theory.jpg" class="card-img" style="width: 200px; height: 300px;">
                                    <div class="card-img-overlay">
                                        <h5 class="card-title text-black" style="font-weight: bold;">Big bang Theory</h5>
                                        <p class="card-text text-warning" style="font-weight: bold;">Last updated 3 mins ago</p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

            <%
                // Assuming CategoryEntity class is "categories1"
                List<CategoryEntity> categories1 = hibernateSession.createQuery("FROM CategoryEntity", CategoryEntity.class).list();

                for (CategoryEntity category : categories1) {

            %>

            <!-- Category name -->
            <div class="col-12">
                <a href="#" class="link-dark link2"><%= category.getName() %></a>&nbsp;&nbsp;
                <a href="#" class="link-dark link3">See All&nbsp; &rarr;</a>
            </div>
            <!-- Category name -->

            <!-- books -->

            <div class="col-12 mb-3">

                <div class="row border border-primary">

                    <div class="col-12 col-lg-12">

                        <div class="row justify-content-center gap-2">

    <%

//        String hql = "FROM GrnItemEntity gi INNER JOIN gi.grnByGrnId g INNER JOIN gi.StockByStockId s INNER JOIN s.bookByBookId b INNER JOIN b.categoryByCategoryId cbc " +
//                "WHERE cbc.id = :categoryId " +
//                "AND b.statusId = 1 " +
//                "ORDER BY g.dateTime DESC";

        Query<GrnItemEntity> grnQuery = hibernateSession.createQuery("FROM GrnItemEntity gi " +
                        "INNER JOIN gi.grnByGrnId g " +
                        "INNER JOIN gi.StockByStockId s " +
                        "INNER JOIN s.bookByBookId b " +
                        "INNER JOIN b.categoryByCategoryId cbc " +
                        "WHERE cbc.id = :categoryId AND b.statusId = 1 " +
                        "ORDER BY g.dateTime DESC", GrnItemEntity.class)
                .setParameter("categoryId", category.getId())
                .setMaxResults(4)
                .setFirstResult(0);
        List<GrnItemEntity> products = grnQuery.getResultList();

    %>

                            <div class="card col-6 col-lg-2 mt-2 mb-2 shadow-sm" style="width: 18rem;">
<%


                                List<Integer> bookIds = new ArrayList<>();
                                for (GrnItemEntity grnItem : products) {
                                    Integer bookId = grnItem.getStockByStockId().getBookId();
                                    bookIds.add(bookId);

                                Query<ImagesEntity> query2 = hibernateSession.createQuery("SELECT i FROM ImagesEntity i WHERE i.productId = :productId", ImagesEntity.class)
                                       .setParameter("productId", grnItem.getStockByStockId().getBookByBookId().getId());
                                List<ImagesEntity> images = query2.getResultList();

                                for(ImagesEntity image: images){

                                    %>
                                <img src="<%= image.getCode() %>" class="card-img-top card-img-top img-thumbnail" style="height: 200px;" />
                                <%
                                    }
                                %>
                                <div class="card-body ms-0 m-0">
                                    <h5 class="card-title"><%= grnItem.getStockByStockId().getBookByBookId().getTitle()%><span class="badge bg-info">New</span></h5>
                                    <span class="card-text text-primary">Rs.<%= grnItem.getStockByStockId().getSellingPrice()%>.00</span>
                                    <br />

                                    <%

                                         if(grnItem.getStockByStockId().getQty()>0){

                                    %>

                                    <span class="card-text text-warning"><b>In Stock</b></span>
                                    <br />
                                    <span class="card-text text-success fw-bold"><%= grnItem.getStockByStockId().getQty()%> Items Available</span>
                                    <a href='singleProductView?id=<%= grnItem.getStockByStockId().getId() %>' class="btn btn-success col-12">Buy Now</a>

                                    <a href="#" onclick="addToCart(<%grnItem.getStockByStockId().getId();%>);" class="btn btn-danger col-12 mt-1">Add to Cart</a>

                                    <%

                                         }else{

                                    %>

                                    <span class="card-text text-danger"><b>Out of Stock</b></span>
                                    <br />
                                    <span class="card-text text-success fw-bold">00 Items Available</span>
                                    <a href="#" class="btn btn-success col-12 disabled">Buy Now</a>
                                    <a href="#" class="btn btn-danger col-12 mt-1 disabled">Add to Cart</a>

                                    <?php
                                    <%
                                    }
                                         List<UsersEntity> user = (List<UsersEntity>) session.getAttribute("u");
//
                                        if (user != null) {
                                            String userEmail = "empty";
                                            for(UsersEntity data : user){
                                                userEmail=data.getEmail();
                                            }

                                            Query<WatchlistEntity> query = hibernateSession.createQuery("SELECT w FROM WatchlistEntity w " +
                                             "WHERE w.stockId = :stockId AND w.usersEmail = :userEmail", WatchlistEntity.class)
                                              .setParameter("stockId", grnItem.getStockByStockId().getId())
                                              .setParameter("userEmail", userEmail);
                                            List<WatchlistEntity> watchLists = query.getResultList();

                                            int wl = 0;
                                            for(WatchlistEntity watchlist : watchLists){
                                                wl++;
                                            }
                                            if(wl!=0){
                                    %>

                                    <a class="btn btn-secondary col-12 mt-1" onclick='addToWatchlist(<%= grnItem.getStockByStockId().getId() %>);'>
                                        <i class="bi bi-heart-fill fs-5 text-danger" id="heart<%= grnItem.getStockByStockId().getId() %>"></i>
                                    </a>
                                    <%
                                        }else{
                                    %>
                                    <a class="btn btn-secondary col-12 mt-1" onclick='addToWatchlist(<%= grnItem.getStockByStockId().getId() %>);'>
                                        <i class="bi bi-heart-fill fs-5 text-white" id="heart<%= grnItem.getStockByStockId().getId() %>"></i>
                                    </a>
                                    <%
                                        }}
                                    %>


                                    <!--
                                                                            <a class="btn btn-secondary col-12 mt-1">
                                                                                <i class="bi bi-heart-fill fs-5 text-danger"></i></a> -->

                                </div>
                            </div>
                             <%}%>
<%--                            <?php--%>


<%--                                }--%>

<%--                            ?>--%>



                        </div>

                    </div>

                </div>

            </div>

            <!-- books -->

            <%

                }
            %>

            <div class="toast-container position-fixed bottom-0 end-0 p-3">
                <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                        <img src="assets/resources/infinity_logo2.svg" class="rounded me-2" alt="...">
                        <strong class="me-auto">Infinity Book Shop</strong>
                        <small>Just Now</small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                    <div class="toast-body">
                        Register for get our best service.
                    </div>
                </div>
            </div>

        </div>

        <jsp:include page="footer.jsp"/>

    </div>
</div>
<%
    transaction.commit();
    hibernateSession.close();
Object user = session.getAttribute("u");
if (user == null) {
%>

<script>
    const toastLiveExample = document.getElementById('liveToast')
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show();
</script>
<%
}
%>

<script src="assets/js/script.js"></script>


</body>
</html>