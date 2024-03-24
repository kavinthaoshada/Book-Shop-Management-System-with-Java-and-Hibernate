<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.StockEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | View Stock</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="">
<div class="container-fluid">
    <div class="row gy-3">
        <jsp:include page="dashBord.jsp"/>

        <div class="col-12 col-lg-9">
            <div class="row">

                <div class="col-12 my-4">
                    <span class="text-success fs-2">Stock View</span>
                </div>

                <div class="col-8 col-lg-6 offset-lg-2">
                    <div class="input-group input-group-lg mt-3 mb-3">
                        <input type="text" class="form-control" aria-label="Text input with dropdown button" id="basic_search_txt"  placeholder="Serch by name, category, author.." />

                        <select class="btn btn-outline-secondary" id="basic_search_select">
                            <option value="0" readonly>Select Category</option>

<%--                            <?php--%>

<%--                                $categoryrs = Database::search("SELECT * FROM `category`");--%>
<%--                                $num = $categoryrs->num_rows;--%>

<%--                            for($x=0; $x<$num; $x++){--%>

<%--                            $cd = $categoryrs->fetch_assoc();--%>

<%--                            ?>--%>
                            <%
                                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                Session hibernateSession = sessionFactory.openSession();
                                Transaction transaction = hibernateSession.beginTransaction();
                                Query<CategoryEntity> categoryEntityQuery = hibernateSession.createQuery("SELECT c FROM CategoryEntity c", CategoryEntity.class);
                                List<CategoryEntity> categories = categoryEntityQuery.getResultList();
                                for(CategoryEntity category : categories){
                            %>

                            <option value="<%= category.getId() %>"><%= category.getName() %></option>

                            <%
                                }

                            %>


                        </select>

                    </div>
                </div>

                <div class="col-2 d-grid gap-2">
                    <button class="btn btn-outline-secondary mt-3 search-btn" onclick="basicSearchHome(0);"><label class="form-label fs-5 bi bi-search text-primary"></label>&nbsp;&nbsp; Search</button>
                    <!-- <button class="btn btn-outline-primary ">Search</button> -->
                </div>

                <div class="col-12 border border-1 border-info rounded shadow" style="background-color: rgb(234, 238, 195);">
                    <div class="row">

                        <!--  -->
                        <div class="col-12 my-1">
                            <div class="row">

                                <div class="col-12" id="loadResults">
                                    <div class="row" id="box">

                                        <div class="col-1 bg-primary text-end">
                                            <label class="form-label fs5 fw-bold text-white">Stock ID</label>
                                        </div>
                                        <div class="col-3 bg-secondary text-end">
                                            <label class="form-label fs5 fw-bold text-white">Book Title</label>
                                        </div>
                                        <div class="col-1 text-end" style="background-color: rgb(234, 238, 195);">
                                            <label class="form-label fs-6 fw-bold text-black">Quantity</label>
                                        </div>
                                        <div class="col-1 bg-secondary text-end">
                                            <label class="form-label fs-5 fw-bold text-white">Selling Price</label>
                                        </div>
                                        <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                            <label class="form-label fs-6 fw-bold text-black">Delivery fee Colombo</label>
                                        </div>
                                        <div class="col-2 bg-secondary text-end">
                                            <label class="form-label fs-6 fw-bold text-white">Delivey fee Other</label>
                                        </div>
                                        <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                        <!--  -->

                        <hr/>

<%--                        <?php--%>
<%--                    $stock_rs = Database::search("SELECT `stock`.`id` AS `stock_id`,`stock`.`qty`,--%>
<%--                    `stock`.`selling_price`,`stock`.`delivery_fee_colombo`,`stock`.`delivery_fee_other`,`book`.`title`--%>
<%--                    FROM `stock` INNER JOIN `book` ON `stock`.`book_id`=`book`.`id`--%>
<%--                    WHERE `stock`.`qty`>'0' ORDER BY `stock`.`id` ASC");--%>
<%--                        $stock_num=$stock_rs->num_rows;--%>

<%--                        for($n=0; $n<$stock_num; $n++){--%>
<%--                        $stock_data = $stock_rs->fetch_assoc();--%>
<%--                        ?>--%>
                        <%
                            Query<StockEntity> stockEntityQuery = hibernateSession.createQuery("SELECT s FROM StockEntity s " +
                                    "INNER JOIN s.bookByBookId b WHERE s.qty > 0 ORDER BY s.id ASC", StockEntity.class);
                            List<StockEntity> stockItems = stockEntityQuery.getResultList();
                            for(StockEntity stockItem : stockItems){
                        %>

                        <div class="col-12 my-1 mb-1">
                            <div class="row">

                                <div class="col-12" id="loadResults">
                                    <div class="row" id="box">

                                        <div class="col-1 bg-primary text-end">
                                            <label class="form-label fs5 fw-bold text-white"><%= stockItem.getId() %></label>
                                        </div>
                                        <div class="col-3 bg-secondary text-end">
                                            <label class="form-label fs5 fw-bold text-white"><%= stockItem.getBookByBookId().getTitle() %></label>
                                        </div>
                                        <div class="col-1 text-end" style="background-color: rgb(234, 238, 195);">
                                            <label class="form-label fs-6 fw-bold text-black"><%= stockItem.getQty() %></label>
                                        </div>
                                        <div class="col-1 bg-secondary text-end">
                                            <label class="form-label fs-5 fw-bold text-white"><%= stockItem.getSellingPrice() %></label>
                                        </div>
                                        <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                            <label class="form-label fs-6 fw-bold text-black"><%= stockItem.getDeliveryFeeColombo() %></label>
                                        </div>
                                        <div class="col-2 bg-secondary text-end">
                                            <label class="form-label fs-6 fw-bold text-white"><%= stockItem.getDeliveryFeeOther() %></label>
                                        </div>
                                        <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                            <div class="row">

                                                <div class="col-10 offset-1 my-1">
                                                    <a href='updateStockPrice?id=<%= stockItem.getId() %>' class="btn btn-warning">Price Update</a>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>

                    <%
                     }
                            transaction.commit();
                            hibernateSession.close();
                    %>

                    </div>
                </div>

            </div>
        </div>

    </div>
</div>

<jsp:include page="modals.jsp"/>

<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>
