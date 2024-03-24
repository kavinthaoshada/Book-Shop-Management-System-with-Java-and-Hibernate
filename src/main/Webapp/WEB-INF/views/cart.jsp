<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Infinity | Cart</title>
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
                double total = 0;
                double subTotal = 0;
                double shipping = 0;

        %>
<%--        <?php--%>
<%--             require "header.php";--%>

<%--             if(isset($_SESSION["u"])){--%>
<%--                $uemail = $_SESSION["u"]["email"];--%>

<%--                $total = 0;--%>
<%--                $subTotal = 0;--%>
<%--                $shipping = 0;--%>


<%--             ?>--%>

        <div class="col-12 pt-2" style="background-color: #E3E5E4;">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">Home</li>
                    <li class="breadcrumb-item active" aria-current="page">Cart</li>
                </ol>
            </nav>
        </div>

        <div class="col-12 border border-0 border-secondary rounded mb-3">
            <div class="row">

                <div class="col-12">
                    <label class="form-label fs-1 fw-bold">Basket <i class="bi bi-cart3 fs-2"></i></label>
                </div>

                <div class="col-12 col-lg-6">
                    <hr class="hr-break-1"/>
                </div>

                <div class="col-12">
                    <div class="row">
                        <div class="col-12 col-lg-6 offset-0 offset-lg-3 mb-3">
                            <input type="text" class="form-control" placeholder="Search in Busket.." />
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <hr class="hr-break-1"/>
                </div>
                <%
                    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                    Session session1 = sessionFactory.openSession();
                    Transaction transaction = session1.beginTransaction();
                    Query<CartEntity> query = session1.createQuery("SELECT c FROM CartEntity c " +
                            "WHERE c.usersEmail= :usersEmail", CartEntity.class)
                            .setParameter("usersEmail", userEmail);
                    List<CartEntity> cartItems = query.getResultList();
                    int cartNumber=0;
                %>

<%--                <?php--%>
<%--                    // $squery = "";--%>

<%--                    $cart_rs = Database::search("SELECT * FROM `cart` WHERE `users_email`='".$uemail."'");--%>
<%--                    $cart_num = $cart_rs->num_rows;--%>

<%--                if($cart_num == 0){--%>

<%--                ?>--%>

                <!-- empty -->
                <div class="col-12">
                    <div class="row">
                        <div class="col-12 emptycart"></div>
                        <div class="col-12 text-center mb-2">
                            <label class="form-label fs-1">You have no item in your basket.</label>
                        </div>
                        <div class="col-12 col-lg-4 offset-0 offset-lg-4 d-d-grid mb-4">
                            <a href="#" class="btn btn-primary fs-5 col-12">Start Shoping</a>
                        </div>
                    </div>
                </div>
                <!-- empty -->

               <%

                   for(CartEntity cartItem : cartItems){
//                            $cart_data = $cart_rs->fetch_assoc();
                       cartNumber++;
                       Query<StockEntity> query1 = session1.createQuery("SELECT s FROM StockEntity s " +
                                       "INNER JOIN s.bookByBookId b " +
                                       "INNER JOIN b.categoryByCategoryId c " +
                                       "INNER JOIN b.bookConditionByBookConditionId bc " +
                                       "INNER JOIN b.authorByAuthorId a " +
                                       "INNER JOIN b.publisherByPublisherId p " +
                                       "INNER JOIN b.languageBylanguageId l " +
                                       "INNER JOIN b.editionByEditionId e " +
                                       "WHERE s.id= :stockId", StockEntity.class)
                               .setParameter("stockId", cartItem.getStockId());
//                       List<StockEntity> stockItems = query1.getResultList();
                       StockEntity stockItem = query1.uniqueResult();

//                $product_rs = Database::search("SELECT `book`.`id` AS `book_id`,`book`.`title`,`book`.`description`,
//                `book`.`pages`,`category`.`name` AS `category`,`condition`.`name` AS `condition`,
//                `author`.`name` AS `author`,`publisher`.`name` AS `publisher`,`language`.`name` AS `language`,
//                `edition`.`name` AS `edition`,`stock`.`selling_price`,`stock`.`qty`,`stock`.`delivery_fee_colombo`,`stock`.`delivery_fee_other`
//                FROM `stock` INNER JOIN `book` ON `stock`.`book_id`=`book`.`id`
//                INNER JOIN `category` ON `book`.`category_id`=`category`.`id`
//                INNER JOIN `condition` ON `book`.`condition_id`=`condition`.`id`
//                INNER JOIN `author` ON `book`.`author_id`=`author`.`id`
//                INNER JOIN `publisher` ON `book`.`publisher_id`=`publisher`.`id`
//                INNER JOIN `language` ON `book`.`language_id`=`language`.`id`
//                INNER JOIN `edition` ON `book`.`edition_id`=`edition`.`id`
//                WhERE `stock`.`id`='".$cart_data["stock_id"]."'");
//                $product_data = $product_rs->fetch_assoc();

                       total = total + (stockItem.getSellingPrice()*stockItem.getQty());

                       Query<UserHasAddressEntity> query2 = session1.createQuery("SELECT s FROM UserHasAddressEntity s " +
                                       "WHERE s.usersEmail= :usersEmail", UserHasAddressEntity.class)
                               .setParameter("usersEmail", userEmail);
                       UserHasAddressEntity addressData = query2.uniqueResult();
                       int cityId = addressData.getCityId();

//                $address_rs = Database::search("SELECT * FROM `user_has_address` WHERE
//                `users_email`='".$uemail."'");
//                $address_data = $address_rs->fetch_assoc();
//                $city_id = $address_data["city_id"];

                       Query<CityEntity> query3 = session1.createQuery("SELECT s FROM CityEntity s " +
                                       "WHERE s.id= :cityId", CityEntity.class)
                               .setParameter("cityId", cityId);
                       CityEntity districtData = query3.uniqueResult();
                       int districtId = districtData.getDistrictId();

//                $district_rs = Database::search("SELECT * FROM `city` WHERE `id`='".$city_id."'");
//                $district_data = $district_rs->fetch_assoc();
//                $district_id = $district_data["district_id"];

//                $ship = 0;
                double ship =0;

                if(districtId == 4){
                    ship = stockItem.getDeliveryFeeColombo();
                    shipping =shipping + stockItem.getDeliveryFeeColombo();
                }else{
                ship = stockItem.getDeliveryFeeOther();
                shipping =shipping + stockItem.getDeliveryFeeOther();
                }

                %>

                <div class="col-12 col-lg-9">
                    <div class="row">

                        <div class="card mb-3 mx-0 col-12">
                            <div class="row g-0">

                                <div class="col-md-12 mt-3 mb-3">
                                    <div class="row">
                                    </div>
                                </div>

                                <hr>

                                <div class="col-md-4">
                                    <%
                                        Query<ImagesEntity> query4 = session1.createQuery("SELECT s FROM ImagesEntity s " +
                                                        "WHERE s.productId= :bookId", ImagesEntity.class)
                                                .setParameter("bookId", stockItem.getBookId());
                                        ImagesEntity imgData = query4.uniqueResult();
                                    %>

<%--                                    <?php--%>

<%--                            $img_rs = Database::search("SELECT * FROM `images` WHERE--%>
<%--                            `product_id`='".$product_data["book_id"]."'");--%>
<%--                            $img_data = $img_rs->fetch_assoc();--%>

<%--                                    ?>--%>

                                    <span class="d-inline-block" tabindex="0" data-bs-toggle="popover"
                                          data-bs-trigger="hover focus" data-bs-content="<%= stockItem.getBookByBookId().getDescription() %>"
                                    title="Product Description">
                                    <img src="<%= imgData.getCode() %>"
                                    class="img-fluid rounded-start" style="max-width: 200px;" />
                                    </span>
                                </div>

                                <div class="col-md-5">
                                    <div class="card-body">

                                        <h3 class="card-title"><%= stockItem.getBookByBookId().getTitle() %></h3>
                                        <span class="fw-bold text-black-50">Author :<%= stockItem.getBookByBookId().getAuthorByAuthorId().getName() %></span>&nbsp;
                                        &nbsp;<span class="fw-bold text-black-50">Condition :<%= stockItem.getBookByBookId().getConditionByConditionId().getName() %></span>

                                        <br/>

                                        <span class="fw-bold text-black-50 fs-5">Price :</span>&nbsp;
                                        <span class="fw-bold text-black fs-5">Rs. <%= stockItem.getSellingPrice() %>0</span>

                                        <br/>

                                        <span class="fw-bold text-black-50 fs-5">Quantity :</span>&nbsp;
                                        <input type="number" class="mt-3 border border-2 border-secondary fs-4 fw-bold px-3 cardqtytext"
                                               value="<%= cartItem.getQty() %>" />

                                        <br/><br/>

                                        <%
                                         if(districtId == 4){

                                        %>
                                        <span class="fw-bold text-black-50 fs-5">Delivery fee :</span>&nbsp;
                                        <span class="fw-bold text-black fs-5">Rs. <%= stockItem.getDeliveryFeeColombo() %>0</span>
                                        <%
                                         }else{
                                        %>
                                        <span class="fw-bold text-black-50 fs-5">Delivery fee :</span>&nbsp;
                                        <span class="fw-bold text-black fs-5">Rs. <%= stockItem.getDeliveryFeeOther() %>0</span>
                                        <%
                                         }
                                        %>

                                    </div>
                                </div>

                                <div class="col-md-3">
                                    <div class="card-body d-grid">
                                        <a href='singleProductView.php?id=<%= stockItem.getBookId() %>' class="btn btn-outline-success mb-2">Buy Now</a>
                                        <a href="#" class="btn btn-outline-danger" onclick="deleteFromCart(<%= cartItem.getId() %>);">Remove</a>
                                    </div>
                                </div>

                                <hr>



                                <div class="col-md-12 mt-3 mb-3">
                                    <div class="row">
                                        <div class="col-6 col-md-6">
                                            <span class="fw-bold fs-5 text-black-50">Requested Total<i class="bi bi-info-circle"></i></span>
                                        </div>
                                        <div class="col-6 col-md-6 text-end">
                                            <span class="fw-bold fs-5 text-black-50">Rs.<%= (stockItem.getSellingPrice()*cartItem.getQty())+ship %>0</span>
                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>



                    </div>
                </div>

                <%

//                        }

                    }

                %>





                <!-- sumary -->
                <div class="col-12 col-lg-3">
                    <div class="row">

                        <div class="col-12">
                            <label class="form-label fs-3 fw-bold">Summary</label>
                        </div>

                        <div class="col-12">
                            <hr />
                        </div>

                        <div class="col-6 mb-3">
                            <span class="fs-6 fw-bold">items (<%= cartNumber %>)</span>
                        </div>

                        <div class="col-6 text-end mb-3">
                            <span class="fs-6 fw-bold">Rs. <%= total %>0</span>
                        </div>

                        <div class="col-6">
                            <span class="fs-6 fw-bold">Shipping</span>
                        </div>

                        <div class="col-6 text-end">
                            <span class="fs-6 fw-bold">Rs. <%= shipping %>0</span>
                        </div>

                        <div class="col-12 mt-3">
                            <hr />
                        </div>

                        <div class="col-6 mt-2">
                            <span class="fs-4 fw-bold">Total</span>
                        </div>

                        <div class="col-6 mt-2 text-end">
                            <span class="fs-4 fw-bold">Rs. <%= total+shipping %>0</span>
                        </div>

                        <div class="col-12 mt-3 mb-3 d-grid">
                            <button class="btn btn-primary fs-5 fw-bold">CHECKOUT</button>
                        </div>

                    </div>
                </div>
                <!-- sumary -->

            </div>
        </div>







        <jsp:include page="footer.jsp"/>
    </div>

</div>

<script src="assets/js/script.js"></script>

<script>
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
        return new bootstrap.Popover(popoverTriggerEl)
    })
</script>

<%
    transaction.commit();
    session1.close();
}else{
%>

<script>
    // window.location = "";
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

<!-- <script src="bootstrap.bundle.js"></script>
<script src="bootstrap.js"></script> -->
</body>
</html>


