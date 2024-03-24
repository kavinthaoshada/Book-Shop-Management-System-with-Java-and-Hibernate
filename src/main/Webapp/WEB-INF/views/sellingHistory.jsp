<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.InvoiceEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.InvoiceItemEntity" %>
<%@ page import="com.calm.webdb.entity.InvoicePaymentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Infinity | Admin | Manage Books</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>

<body class="">

<div class="container-fluid">
    <div class="row">

        <div class="col-12 bg-light text-center mb-3">
            <label class="form-label fs-1 fw-bold text-primary">Selling History</label>
        </div>

        <div class="col-12 mt-3 mb-3 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-12 col-lg-3 mt-3 mb-3">
                    <label class="form-label fs-5">Search by Invoice ID : </label>
                    <input type="text" class="form-control fs-5" placeholder="Invoice ID..."/>
                </div>

                <div class="col-12 col-lg-2 mt-3 mb-3"></div>
                <div class="col-12 col-lg-2 mt-3 mb-3">
                    <label class="form-label fs-5">From Date : </label>
                    <input type="date" class="form-control fs-5"/>
                </div>

                <div class="col-12 col-lg-2 mt-3 mb-3">
                    <label class="form-label fs-5">To Date : </label>
                    <input type="date" class="form-control fs-5"/>
                </div>
                <div class="col-12 col-lg-1 mt-3 mb-3 d-grid">
                    <botton class="btn btn-primary fw-bold fs-5">Find</botton>
                    <div class="form-label fs-5"></div>
                </div>
            </div>

        </div>
    </div>

    <div class="col-12 shadow" style="background-color: rgb(234, 238, 195);"></div>
    <div class="row">

        <div class="col-1 bg-secondary text-end">
            <label class="form-label fs-5 fw-bold text-white">Invoice ID</label>
        </div>
        <div class="col-3 text-end" style="background-color: rgb(234, 238, 195);">
            <label class="form-label fs-5 fw-bold text-black">Book Title</label>
        </div>
        <div class="col-2 bg-secondary text-end">
            <label class="form-label fs-5 fw-bold text-white">Buyer</label>
        </div>
        <div class="col-1 text-end" style="background-color: rgb(234, 238, 195);">
            <label class="form-label fs-5 fw-bold text-black">Amount</label>
        </div>
        <div class="col-1 bg-secondary text-end">
            <label class="form-label fs-5 fw-bold text-white">Quantity</label>
        </div>
        <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
            <label class="form-label fs-5 fw-bold text-black">Date</label>
        </div>
        <div class="col-2" style="background-color: rgb(234, 238, 195);">

        </div>
    </div>

    <%
        String page1 = request.getParameter("page");
        int pageNo = 0;
        if(!page1.isEmpty()){
            pageNo = 1;
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Query<InvoiceEntity> invoiceEntityQuery =hibernateSession.createQuery("FROM InvoiceEntity i", InvoiceEntity.class);
        List<InvoiceEntity> invoices = invoiceEntityQuery.getResultList();
        int invoiceResultSize = invoices.size();

        int resultPerPage = 10;
        int numberOfPage = (int) Math.ceil((double) invoiceResultSize / resultPerPage);;

        int pageFirstResult = (pageNo - 1) * resultPerPage;

        Query<InvoiceItemEntity> invoiceItemEntityQuery = hibernateSession.createQuery("SELECT ii FROM InvoiceItemEntity ii " +
                "INNER JOIN ii.invoiceByInvoiceId i " +
                "INNER JOIN ii.stockByStockId s " +
                "INNER JOIN s.bookByBookId b " +
                "INNER JOIN i.usersByUsersEmail u", InvoiceItemEntity.class)
                .setFirstResult(pageFirstResult)
                .setMaxResults(resultPerPage);
        List<InvoiceItemEntity> invoiceItems = invoiceItemEntityQuery.getResultList();
        for(InvoiceItemEntity invoiceItem : invoiceItems){
            Query<InvoicePaymentEntity> invoicePaymentEntityQuery = hibernateSession.createQuery("SELECT ip FROM InvoicePaymentEntity ip " +
                    "WHERE ip.invoiceId= :invoiceId", InvoicePaymentEntity.class)
                    .setParameter("invoiceId", invoiceItem.getInvoiceByInvoiceId().getId());
            InvoicePaymentEntity invoicePayment = invoicePaymentEntityQuery.uniqueResult();
    %>

    <div class="col-12 mt-1">
        <div class="row">
            <div class="col-12" id="loadResults">
                <div class="row" id="box">

                    <div class="col-1 bg-secondary text-end">
                        <label class="form-label fs5 fw-bold text-white"><%= invoiceItem.getInvoiceId() %></label>
                    </div>
                    <div class="col-3 text-end" style="background-color: rgb(234, 238, 195);">
                        <label class="form-label fs-5 fw-bold text-black"><%= invoiceItem.getStockByStockId().getBookByBookId().getTitle() %></label>
                    </div>
                    <div class="col-2 bg-secondary text-end">
                        <label class="form-label fs-5 fw-bold text-white"><%= invoiceItem.getInvoiceByInvoiceId().getUsersByUsersEmail().getFname()+" "+invoiceItem.getInvoiceByInvoiceId().getUsersByUsersEmail().getLname() %></label>
                    </div>
                    <div class="col-1 text-end" style="background-color: rgb(234, 238, 195);">
                        <label class="form-label fs-5 fw-bold text-black">Rs. <%= invoicePayment.getPayment() %>0</label>
                    </div>
                    <div class="col-1 bg-secondary text-end">
                        <label class="form-label fs-5 fw-bold text-white"><%= invoiceItem.getQty() %></label>
                    </div>
                    <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                        <label class="form-label fs-5 fw-bold text-black"><%= invoiceItem.getInvoiceByInvoiceId().getDate() %></label>
                    </div>

                    <div class="col-2 d-grid" style="background-color: rgb(234, 238, 195);">
                        <%
                            int orderStatus = invoiceItem.getInvoiceByInvoiceId().getStatus();
                            if(orderStatus == 0){
                        %>
                        <button class="btn btn-success mb-2 mt-2 fw-bold"
                                onclick="changeInvoiceId(<%= invoiceItem.getInvoiceId() %>);"
                                id="btn<%= invoiceItem.getInvoiceId() %>">Confirm Order</button>
                        <%
                            }else if(orderStatus == 1){
                        %>
                        <button class="btn btn-warning mb-2 mt-2 fw-bold"
                                onclick="changeInvoiceId(<%= invoiceItem.getInvoiceId() %>);"
                                id="btn<%= invoiceItem.getInvoiceId() %>">Packing</button>
                        <%
                            }else if(orderStatus == 2){
                        %>
                        <button class="btn btn-info mb-2 mt-2 fw-bold"
                                onclick="changeInvoiceId(<%= invoiceItem.getInvoiceId() %>);"
                                id="btn<%= invoiceItem.getInvoiceId() %>">Dispatch</button>
                        <%
                            }else if(orderStatus == 3){
                        %>
                        <button class="btn btn-primary mb-2 mt-2 fw-bold"
                                onclick="changeInvoiceId(<%= invoiceItem.getInvoiceId() %>);"
                                id="btn<%= invoiceItem.getInvoiceId() %>">Shipping</button>
                        <%
                            }else if(orderStatus == 4){
                        %>
                        <button class="btn btn-danger mb-2 mt-2 fw-bold"
                                onclick="changeInvoiceId(<%= invoiceItem.getInvoiceId() %>);"
                                id="btn<%= invoiceItem.getInvoiceId() %>">Deliverd</button>
                        <%
                            }
                        %>
                    </div>



                </div>
            </div>
        </div>
    </div>

    <%
             }
    %>



    <!-- pagination -->
    <div class="col-12 text-center justify-content-center align-content-center d-flex mb-4 mt-3">
        <div class="pagination">
            <a href="<%
                            String hash ="#";
                            String param = "?page="+(pageNo - 1);
                            String param1 = "?page="+(pageNo);
                            String param2 = "?page="+(pageNo + 1);
                                if(pageNo <= 1){
                        %>
                        <%= hash %>
                        <%
                            }else{
                        %>
                        <%= param %>
                        <%
                            }
                        %>">&laquo;</a>
            <%
                for(int pageNumber = 1; pageNumber <= numberOfPage; pageNumber++){

                    if(pageNumber == pageNo){
            %>
            <a href="<%= param1 %>" class="active"><%= pageNumber %></a>
            <%
            }else{
            %>
            <a href="<%= param1 %>"><%= pageNumber %></a>
            <%
                    }
                }
            %>
            <a href="<%
                        if(pageNo >= numberOfPage){
                            %>
                            <%= hash %>
                            <%
                                }else{
                                %>
                                <%= param2 %>
                                <%
                                }
                                %>">&raquo;</a>
        </div>
    </div>
    <!-- pagination -->

</div>
</div>

<script src="assets/js/script.js"></script>
</body>
</html>
