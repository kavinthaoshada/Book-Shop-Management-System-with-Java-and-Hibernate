<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.time.*" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Admin Panel</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/clock.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>

<body class="bg-body">

<div class="container.fluid">
    <div class="row">

        <jsp:include page="dashBord.jsp"/>

        <div class="col-12 col-lg-9">
            <div class="row">

                <div class="col-12 text-black-50 fw-bold mb-3 mt-2">
                    <h2 class="fw-bold">Dashboard</h2>
                </div>

                <div class="col-12">
                    <hr/>
                </div>

                <div class="col-12 col-lg-6 shadow-sm" style="background-color: rgb(203, 231, 227);">
                    <div class="row g-1">

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Daily erning</span>
                                    <br/>

                                    <%
                                        LocalDate today = LocalDate.now();
                                        String formattedToday = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                        String thisMonth = today.format(DateTimeFormatter.ofPattern("MM"));
                                        String thisYear = today.format(DateTimeFormatter.ofPattern("yyyy"));
//                        $today = date("Y-m-d");
//                        $this_month = date("m");
//                        $this_year = date("Y");

                        double a = 0;
                        double b = 0;
                        int c = 0;
                        int d = 0;
                        int e = 0;

                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                        Session session1 = sessionFactory.openSession();
                        Transaction transaction = session1.beginTransaction();
                        Query<InvoiceItemEntity> query = session1.createQuery("SELECT ii FROM InvoiceItemEntity ii " +
                                "INNER JOIN ii.invoiceByInvoiceId i " +
                                "INNER JOIN ii.stockByStockId s", InvoiceItemEntity.class);
                        List<InvoiceItemEntity> invoiceItems = query.getResultList();
                        for(InvoiceItemEntity invoiceItem : invoiceItems){
                            Query<InvoicePaymentEntity> query1 = session1.createQuery("SELECT ip FROM InvoicePaymentEntity ip " +
                                    "INNER JOIN ip.invoiceByInvoiceId i WHERE i.id= :invoiceId", InvoicePaymentEntity.class)
                                    .setParameter("invoiceId", invoiceItem.getInvoiceByInvoiceId().getId());
                            List<InvoicePaymentEntity> invoicePayments = query1.getResultList();
                            for(InvoicePaymentEntity invoicePayment : invoicePayments){

                                    e = e + invoiceItem.getQty();

                                    Date f = invoiceItem.getInvoiceByInvoiceId().getDate();
                                    String pdate = String.valueOf(f);

                                    double tot = invoiceItem.getStockByStockId().getSellingPrice() * invoiceItem.getQty();

                                    if(pdate == formattedToday){
                                    a = a + tot;
                                    c = c + invoiceItem.getQty();
                                    }

                                    String[] splitResult = pdate.split("-");
                                    String pyear = splitResult[0];
                                    String pmonth = splitResult[1];
//                                    $split_result = explode("-",$pdate);
//                                    $pyear = $split_result[0];
//                                    $pmonth = $split_result[1];

                                    if(pyear == thisYear){
                                    if(pmonth == thisMonth){
                                    b = b + tot;
                                    d = d + invoiceItem.getQty();
                                    }
                                    }

                                    }
                                    }
                                    %>

                                    <span class="fs-5">Rs.<%= a+"" %>0</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Monthly erning</span>
                                    <br/>
                                    <span class="fs-5">Rs.<%= b+"" %>0</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Today Sellings</span>
                                    <br/>
                                    <span class="fs-5"><%= c+"" %> Item</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Monthly Sellings</span>
                                    <br/>
                                    <span class="fs-5"><%= d+"" %> Item</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Total Sellings</span>
                                    <br/>
                                    <span class="fs-5"><%= e+"" %> Item</span>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-lg-6 px-1 shadow">
                            <div class="row g-1">
                                <div class="col-12 text-black text-center rounded my-2" style="height: 100px; background-color: rgb(247, 244, 220);">
                                    <br/>
                                    <span class="fs-4 fw-bold">Total Engagements</span>
                                    <br/>
                                    <%
                                        Query<UsersEntity> query2 = session1.createQuery("FROM UsersEntity u", UsersEntity.class);
                                        List<UsersEntity> users = query2.getResultList();
                                        int userCount = 0;
                                        for(UsersEntity user : users){
                                            userCount++;
                                        }
                                    %>
                                    <span class="fs-5"><%= userCount+"" %> Members</span>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <!-- <div class="col-12">
                    <hr/>
                </div> -->

                <div class="col-5 mx-5 shadow" style="background-color: rgb(212, 202, 202);">
                    <div class="row">

                        <div class="col-12 text-center mt-3 mb-3">
                            <label class="form-label fs-4 fw-bold text-black">Total Active Time</label>
                        </div>

                        <%
                            LocalDateTime startDate = LocalDateTime.parse("2022-07-01T00:00:00");
                            ZonedDateTime endDate = ZonedDateTime.now(ZoneId.of("Asia/Colombo"));
                            Duration duration = Duration.between(startDate, endDate);

                            long years = duration.toDays() / 365;
                            long months = (duration.toDays() % 365) / 30;
                            long days = duration.toDays() % 30;
                            long hours = duration.toHours() % 24;
                            long minutes = duration.toMinutes() % 60;
                            long seconds = duration.getSeconds() % 60;

                        %>

                        <div class="col-12 col-lg-10 text-end mt-3 mb-3">
                            <label class="form-label fs-4 fw-bold text-black">
                                <%= years + " Years " + months + " Months " +
                                        days + " Days " + hours + " Hours " +
                                        minutes + " Minutes " + seconds + " Seconds " %>
                            </label>
                        </div>

                        <div class="mx-5" style="width: 150px; height: 100px;">
                            <div class="clock">
                                <div class="clock-hand">
                                    <div class="hand hour"></div>
                                    <div class="hand minute"></div>
                                    <div class="hand second"></div>
                                </div>
                            </div>
                        </div>



                    </div>
                </div>

                <div class="offset-1 col-10 col-lg-10 mt-3 mb-3 rounded shadow" style="background-color: rgb(202, 234, 243);">
                    <div class="row g-1">

                        <div class="col-12 text-center">
                            <label class="form-label fs-4 fw-bold">Mostly Sold Item</label>
                        </div>

                        <%
//                            COUNT(b.id) AS value_occurence
                         Query<InvoiceItemEntity> query3 = session1.createQuery("SELECT ii " +
                                 "FROM InvoiceItemEntity ii " +
                                 "JOIN ii.invoiceByInvoiceId i " +
                                 "JOIN ii.stockByStockId s " +
                                 "JOIN s.bookByBookId b " +
                                 "WHERE DATE_FORMAT(i.date, '%Y-%m-%d') LIKE :today " +
                                 "GROUP BY b.id " +
                                 "ORDER BY COUNT(b.id) DESC", InvoiceItemEntity.class)
                                 .setParameter("today", formattedToday);
                         List<InvoiceItemEntity> iIs = query3.getResultList();
                         for(InvoiceItemEntity iI : iIs){
                             Query<InvoicePaymentEntity> query4 = session1.createQuery("SELECT ip FROM InvoicePaymentEntity ip " +
                                             "INNER JOIN ip.invoiceByInvoiceId i WHERE i.id= :invoiceId", InvoicePaymentEntity.class)
                                     .setParameter("invoiceId", iI.getInvoiceByInvoiceId().getId());
                             List<InvoicePaymentEntity> iPs = query4.getResultList();
                             for(InvoicePaymentEntity iP : iPs){


                        Query<ImagesEntity> query5 = session1.createQuery("FROM ImagesEntity i WHERE i.productId= :bookId", ImagesEntity.class)
                             .setParameter("bookId", iI.getStockByStockId().getBookByBookId().getId());
                        List<ImagesEntity> imgs = query5.getResultList();
                        String code = "";
                        for(ImagesEntity img : imgs){
                            code = img.getCode();
                        }

                        Query<BookEntity> query6 = session1.createQuery("FROM BookEntity b WHERE b.id= :bookId", BookEntity.class)
                              .setParameter("bookId", iI.getStockByStockId().getBookByBookId().getId());
                        List<BookEntity> books = query6.getResultList();
                                 transaction.commit();
                                 session1.close();
                        String title = "";
                        for(BookEntity book : books){
                            title = book.getTitle();
                        }

                        %>
                        <div class="col-6 text-center">
                            <img src="<%= code %>" class="img-fluid rounded-top" style="height: 250px;"/>
                            <!-- <hr/> -->
                        </div>

                        <div class="col-6 text-center">
                            <span class="fs-4"><%= title %></span>
                            <br/>
                            <!-- <span class="fs-6"><?php
                            //  echo $qtytotal["total"];
                             ?>Items</span>
                            <br/>
                            <span class="fs-6">Rs. <?php
                            // echo $pdetails["price"];
                            ?>.00</span>
                            <br/> -->
                        </div>



                        <div class="col-12 mb-2">
                            <div class="first_place"></div>
                        </div>

                    </div>
                </div>



                <%
                    }
                    }

                %>

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

