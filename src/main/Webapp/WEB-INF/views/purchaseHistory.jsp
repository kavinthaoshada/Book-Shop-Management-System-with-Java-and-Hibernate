<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.InvoiceItemEntity" %>
<%@ page import="com.calm.webdb.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.InvoicePaymentEntity" %>
<%@ page import="com.calm.webdb.entity.ImagesEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Purchase History</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <link rel="icon" href="assets/resources/logo.svg" />

    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="header.jsp"/>

        <div class="col-12 text-center mb-3">
            <span class="fs-1 fw-bold text-primary">Transaction History</span>
        </div>

        <div class="col-12">
            <div class="row">

                <div class="col-12 d-none d-lg-block">
                    <div class="row">

                        <div class="col-1 bg-light">
                            <label class="form-label fw-bold">#</label>
                        </div>

                        <div class="col-3 bg-light">
                            <label class="form-label fw-bold">Order Details</label>
                        </div>

                        <div class="col-1 bg-light text-end">
                            <label class="form-label fw-bold">Quantity</label>
                        </div>

                        <div class="col-2 bg-light text-end">
                            <label class="form-label fw-bold">Amount</label>
                        </div>

                        <div class="col-2 bg-light text-end">
                            <label class="form-label fw-bold">Purchased Date And Time</label>
                        </div>

                        <div class="col-3 bg-light"></div>
                        <div class="col-12">
                            <hr />
                        </div>

                    </div>
                </div>

                <div class="col-12">
                    <%
                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                        Session hibernateSession = sessionFactory.openSession();
                        Transaction transaction = hibernateSession.beginTransaction();

                        String usersEmail = "empty";
                        List<UsersEntity> users = (List<UsersEntity>)session.getAttribute("u");
                        for (UsersEntity user : users)
                            usersEmail = user.getEmail();

                        Query<InvoiceItemEntity> invoiceItemQuery = hibernateSession.createQuery("SELECT ii FROM InvoiceItemEntity ii " +
                                "INNER JOIN ii.invoiceByInvoiceId i " +
                                "INNER JOIN ii.stockByStockId s " +
                                "INNER JOIN s.bookByBookId b " +
                                "WHERE i.usersEmail= :usersEmail", InvoiceItemEntity.class)
                                .setParameter("usersEmail", usersEmail);
                        List<InvoiceItemEntity> invoiceItems = invoiceItemQuery.getResultList();
                        int number = 0;
                        for(InvoiceItemEntity invoiceItem : invoiceItems){
                            number++;

                            Query<InvoicePaymentEntity> invoicePaymentEntityQuery = hibernateSession.createQuery("SELECT ip " +
                                    "FROM InvoicePaymentEntity ip " +
                                    "INNER JOIN ip.invoiceByInvoiceId i " +
                                    "WHERE i.id= :invoiceID", InvoicePaymentEntity.class)
                                    .setParameter("invoiceID", invoiceItem.getInvoiceByInvoiceId().getId());
                            InvoicePaymentEntity invoicePayment = invoicePaymentEntityQuery.uniqueResult();

                            Query<ImagesEntity> imagesEntityQuery = hibernateSession.createQuery("SELECT i FROM ImagesEntity i " +
                                    "INNER JOIN i.bookByProductId b " +
                                    "WHERE b.id= :bookID", ImagesEntity.class)
                                    .setParameter("bookID", invoiceItem.getStockByStockId().getBookByBookId().getId());
                            ImagesEntity images = imagesEntityQuery.uniqueResult();

                    %>
                    <div class="row mb-1">

                        <div class="col-12 col-lg-1 bg-light text-center text-lg-start">
                            <label class="form-label text-dark fw-bold fs-5 py-5"><?php echo $number; ?></label>
                        </div>

                        <div class="col-12 col-lg-3">
                            <div class="row g-2">

                                <div class="card mx-0 mt-2 mb-0 shadow-sm" style="width: 500px;">
                                    <div class="row g-0">
                                        <div class="col-md-4">
                                            <img src="<%= images.getCode() %>" class="img-fluid rounded-5" />
                                        </div>
                                        <div class="col-md-8">
                                            <div class="card-body">
                                                <h5 class="card-title"><%= invoiceItem.getStockByStockId().getBookByBookId().getTitle() %></h5>
                                                <p class="card-text"><b>Price : </b> Rs.<%= invoiceItem.getStockByStockId().getSellingPrice() %>0</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="col-12 col-lg-1 text-center text-lg-end bg-light">
                            <label class="form-label fs-4 pt-5"><%= invoiceItem.getStockByStockId().getQty() %></label>
                        </div>

                        <div class="col-12 col-lg-2 text-center text-lg-end bg-light">
                            <label class="form-label fs-4 pt-5 text-black fw-bold">Rs.<%= invoicePayment.getPayment() %>0</label>
                        </div>

                        <div class="col-12 col-lg-2 text-center text-lg-end bg-light">
                            <label class="form-label fs-5 pt-5 px-3 fw-bold"><%= invoiceItem.getInvoiceByInvoiceId().getDate() %></label>
                        </div>

                        <div class="col-12 col-lg-3">
                            <div class="row">

                                <div class="col-6 d-grid">
                                    <button class="btn btn-secondary rounded mt-5 fs-5 shadow" onclick="feedback('<%= invoiceItem.getStockByStockId().getId() %>');">
                                        <i class="bi bi-info-circle-fill"></i> Feedback
                                    </button>
                                </div>

                                <div class="col-6 d-grid">
                                    <button class="btn btn-danger rounded mt-5 fs-5 shadow">
                                        <i class="bi bi-trash-fill"></i> Delete
                                    </button>
                                </div>

                                <div class="col-12">
                                    <hr />
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

        <div class="col-12">
            <hr />
        </div>

        <div class="col-12 mb-3">
            <div class="row">
                <div class="col-0 col-lg-10 d-none d-lg-block"></div>
                <div class="col-12 col-lg-2 d-grid shadow-sm">
                    <button class="btn btn-danger rounded fs-6">
                        <i class="bi ci-trash-fill"></i>Clear All Records
                    </button>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add your feedback</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="col-12">
                            <div class="row px-1">
                                <div class="form-floating">
                                    <textarea class="form-control" placeholder="Leave a comment here" id="fbk" style="height: 100px"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="saveFeedback();">Save</button>
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
