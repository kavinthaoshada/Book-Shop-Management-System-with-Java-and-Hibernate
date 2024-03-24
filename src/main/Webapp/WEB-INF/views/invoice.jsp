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
<%
  String orderId = request.getParameter("orderId");
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Invoice | Invoice</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />

  <link rel="icon" href="assets/resources/infinity_logo2.svg" />

  <link rel="stylesheet" href="assets/css/bootstrap.css" />
  <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="mt-2" style="background-color: #f7f7ff;">

<div class="container-fluid">
  <div class="row">
    <jsp:include page="header.jsp" />
    <%
      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
      Session hibernateSession = sessionFactory.openSession();
      Transaction transaction = hibernateSession.beginTransaction();
      List<UsersEntity> usersSessionData = (List<UsersEntity>)session.getAttribute("u");
      String cname = "empty";
      String address = "empty";
      String el = "empty";
      if(usersSessionData==null){
        cname = request.getParameter("cname");
        address = request.getParameter("add");
        el = request.getParameter("el");
      }
    %>

    <div class="col-12">
      <hr/>
    </div>

    <div class="col-12 btn-toolbar justify-content-end">
      <button class="btn btn-dark me-2" onclick="printInvoice();"><i class="bi bi-printer-fill"></i>Print</button>
      <button class="btn btn-danger me-2" onclick="Convert_HTML_To_PDF();"><i class="bi bi-file-earmark-pdf-fill"></i>Export as PDF</button>
    </div>

    <div class="col-12">
      <hr/>
    </div>

    <div class="col-12" id="page">
      <div class="row">

        <div class="col-6">
          <div class="ms-5 invoiceHeaderImg"></div>
        </div>

        <div class="col-6">
          <div class="row">

            <div class="col-12 text-primary text-decoration-underline text-end">
              <h2>Infinity Book Shop</h2>
            </div>

            <div class="col-12 fw-bold text-end">
              <span>Maradana, Colombo 10, Sri Lanka.</span><br/>
              <span>+94 112452395</span><br/>
              <span>Infinity@gmail.com</span>
            </div>

          </div>
        </div>

        <div class="col-12">
          <hr class="border border-1 border-primary"/>
        </div>

        <div class="col-12 mb-4">
          <div class="row">

            <%
                    if(usersSessionData != null){
                      for(UsersEntity user : usersSessionData){
            %>
            <div class="col-6">
              <h5>00<%= orderId %></h5>
              <h2><%= user.getFname()+" "+user.getLname() %></h2><br/>
              <%
                Query<UserHasAddressEntity> userHasAddressEntityQuery = hibernateSession.createQuery("SELECT uha " +
                        "FROM UserHasAddressEntity uha " +
                        "INNER JOIN uha.cityByCityId c WHERE uha.usersEmail= :userEmail", UserHasAddressEntity.class)
                        .setParameter("userEmail", user.getEmail());
                UserHasAddressEntity userAddress = userHasAddressEntityQuery.uniqueResult();
              %>
              <span><%= userAddress.getLine1()+", "+userAddress.getLine2()+", " +
                      ""+userAddress.getCityByCityId().getName() %></span><br/>
              <span><%= user.getEmail() %></span>
            </div>

            <div class="col-6 text-end mt-4">
              <h1 class="text-primary">INVOICE 01</h1>
              <span class="fw-bold">Date & Time of Invoice : </span>&nbsp;
              <%
                Query<InvoiceItemEntity> invoiceItemEntityQuery = hibernateSession.createQuery("SELECT ii " +
                        "FROM InvoiceItemEntity ii " +
                        "INNER JOIN ii.invoiceByInvoiceId i " +
                        "WHERE i.orderId= :orderId", InvoiceItemEntity.class)
                        .setParameter("orderId", orderId);
                InvoiceItemEntity invoiceItem = invoiceItemEntityQuery.uniqueResult();

                Query<InvoicePaymentEntity> invoicePaymentEntityQuery = hibernateSession.createQuery("SELECT ip " +
                        "FROM InvoicePaymentEntity ip " +
                        "WHERE ip.invoiceId= :invoiceId", InvoicePaymentEntity.class)
                        .setParameter("invoiceId", invoiceItem.getInvoiceId());
                InvoicePaymentEntity invoicePayment = invoicePaymentEntityQuery.uniqueResult();
              %>
              <sapan class="fw-bold"><%= invoiceItem.getInvoiceByInvoiceId().getDate() %></sapan>
            </div>

          </div>
        </div>

        <div class="col-12">
          <table class="table">
            <thead>

            <tr class="border border-1 border-white">
              <th>#</th>
              <th>Order ID & Product</th>
              <th class="text-end">Unit Price</th>
              <th class="text-end">Quantity</th>
              <th class="text-end">Total</th>
            </tr>

            </thead>
            <tbody>
            <tr style="height: 72px;">
              <td class="bg-primary text-white fs-3"><%= invoiceItem.getInvoiceId() %></td>
              <td>
                <span class="fw-bold text-primary text-decoration-underline p-2"><%= orderId %></span>
                <br/>
                <%

                  Query<StockEntity> stockEntityQuery = hibernateSession.createQuery("SELECT s FROM StockEntity s " +
                          "INNER JOIN s.bookByBookId b " +
                          "INNER JOIN b.categoryByCategoryId c " +
                          "INNER JOIN b.bookConditionByBookConditionId bc " +
                          "INNER JOIN b.authorByAuthorId a " +
                          "INNER JOIN b.publisherByPublisherId p " +
                          "INNER JOIN b.languageBylanguageId l " +
                          "INNER JOIN b.editionByEditionId e WHERE s.id= :stockId", StockEntity.class)
                          .setParameter("stockId", invoiceItem.getStockId());

                StockEntity stockItem = stockEntityQuery.uniqueResult();
                double total = invoiceItem.getQty() * stockItem.getSellingPrice();
                %>
                <span class="fw-bold fs-3 text-primary p-2"><%= stockItem.getBookByBookId().getTitle() %></span>
              </td>
              <td class="fw-bold fs-6 text-end pt-3 bg-secondary text-white">Rs. <%= stockItem.getSellingPrice() %>0</td>
              <td class="fw-bold fs-6 text-end pt-3"><%= invoiceItem.getQty() %></td>
              <td class="fw-bold fs-6 text-end bg-primary text-white">Rs. <%= total %>0</td>
            </tr>
            </tbody>

            <tfoot>

            <tr>
              <td colspan="3" class="border-0"></td>
              <td class="fs-5 text-end">SUBTOTAL</td>
              <td class="text-end">Rs. <%= total %>0</td>
            </tr>

            <tr>
              <td colspan="3" class="border-0"></td>
              <td class="fs-5 text-end border-primary">Discount</td>
              <td class="text-end border-primary">Rs.
                <%
                  double discount = 0;
                  if(total > 250000){
                  discount = (total/100)*1;
                %>
                <%= discount %>
                <%
                  }else if(total > 500000){
                  discount = (total/100)*2;
                %>
                <%= discount %>
                <%
                  }else if(total>1000000){
                  discount = (total/100)*5;
                %>
                <%= discount %>
                <%
                  }else{
                %>
                <%= discount %>
                <%
                  }
                %>0</td>
            </tr>

            <tr>
              <td colspan="3" class="border-0"></td>
              <td class="fs-5 text-end border-primary text-primary fw-bold">GRAND TOTAL</td>
              <td class="fs-5 text-end border-primary text-primary fw-bold">Rs. <%= (total-discount) %>0</td>
            </tr>

            </tfoot>
          </table>
        </div>

        <%
          }
         }else{
        %>
        <div class="col-6">
          <h5>00<%= orderId %></h5>
          <h2><%= cname %></h2><br/>

          <span><%= address %></span><br/>
          <span><%= el %></span>
        </div>

        <div class="col-6 text-end mt-4">
          <h1 class="text-primary">INVOICE 01</h1>
          <span class="fw-bold">Date & Time of Invoice : </span>&nbsp;
          <%
            Query<InvoiceItemEntity> invoiceItemEntityQuery = hibernateSession.createQuery("SELECT ii " +
                            "FROM InvoiceItemEntity ii " +
                            "INNER JOIN ii.invoiceByInvoiceId i " +
                            "WHERE i.orderId= :orderId", InvoiceItemEntity.class)
                    .setParameter("orderId", orderId);
            InvoiceItemEntity invoiceItem = invoiceItemEntityQuery.uniqueResult();

            Query<InvoicePaymentEntity> invoicePaymentEntityQuery = hibernateSession.createQuery("SELECT ip " +
                            "FROM InvoicePaymentEntity ip " +
                            "WHERE ip.invoiceId= :invoiceId", InvoicePaymentEntity.class)
                    .setParameter("invoiceId", invoiceItem.getInvoiceId());
            InvoicePaymentEntity invoicePayment = invoicePaymentEntityQuery.uniqueResult();
          %>
          <sapan class="fw-bold"><%= invoiceItem.getInvoiceByInvoiceId().getDate() %></sapan>
        </div>

      </div>
    </div>

    <div class="col-12">
      <table class="table">
        <thead>

        <tr class="border border-1 border-white">
          <th>#</th>
          <th>Order ID & Product</th>
          <th class="text-end">Unit Price</th>
          <th class="text-end">Quantity</th>
          <th class="text-end">Total</th>
        </tr>

        </thead>
        <tbody>
        <tr style="height: 72px;">
          <td class="bg-primary text-white fs-3"><%= invoiceItem.getInvoiceId() %></td>
          <td>
            <span class="fw-bold text-primary text-decoration-underline p-2"><%= orderId %></span>
            <br/>
            <%
              Query<StockEntity> stockEntityQuery = hibernateSession.createQuery("SELECT s FROM StockEntity s " +
                              "INNER JOIN s.bookByBookId b " +
                              "INNER JOIN b.categoryByCategoryId c " +
                              "INNER JOIN b.bookConditionByBookConditionId bc " +
                              "INNER JOIN b.authorByAuthorId a " +
                              "INNER JOIN b.publisherByPublisherId p " +
                              "INNER JOIN b.languageBylanguageId l " +
                              "INNER JOIN b.editionByEditionId e WHERE s.id= :stockId", StockEntity.class)
                      .setParameter("stockId", invoiceItem.getStockId());

              StockEntity stockItem = stockEntityQuery.uniqueResult();
              double total = invoiceItem.getQty() * stockItem.getSellingPrice();
            %>
            <span class="fw-bold fs-3 text-primary p-2"><%= stockItem.getBookByBookId().getTitle() %></span>
          </td>
          <td class="fw-bold fs-6 text-end pt-3 bg-secondary text-white">Rs. <%= stockItem.getSellingPrice() %>0</td>
          <td class="fw-bold fs-6 text-end pt-3"><%= stockItem.getQty() %></td>
          <td class="fw-bold fs-6 text-end bg-primary text-white">Rs. <%= total %>0</td>
        </tr>
        </tbody>

        <tfoot>

        <tr>
          <td colspan="3" class="border-0"></td>
          <td class="fs-5 text-end">SUBTOTAL</td>
          <td class="text-end">Rs. <%= total %>0</td>
        </tr>

        <tr>
          <td colspan="3" class="border-0"></td>
          <td class="fs-5 text-end border-primary">Discount</td>
          <td class="text-end border-primary">Rs.
            <%
              double discount = 0;
              if(total > 250000){
                discount = (total/100)*1;
            %>
            <%= discount %>
            <%
            }else if(total > 500000){
              discount = (total/100)*2;
            %>
            <%= discount %>
            <%
            }else if(total>1000000){
              discount = (total/100)*5;
            %>
            <%= discount %>
            <%
            }else{
            %>
            <%= discount %>
            <%
              }
            %>0</td>
        </tr>

        <tr>
          <td colspan="3" class="border-0"></td>
          <td class="fs-5 text-end border-primary text-primary fw-bold">GRAND TOTAL</td>
          <td class="fs-5 text-end border-primary text-primary fw-bold">Rs. <%= (total-discount) %>0</td>
        </tr>

        </tfoot>
      </table>
    </div>
    <%
      }
    %>

    <div class="col-4 text-center" style="margin-top: -100px;">
      <span class="fs-1 fw-bold text-success">Thank you!</span>
    </div>

    <div class="col-12 mt-3 border-0 border-start border-5 border-primary rounded"
         style="background-color: #e7f2ff;">
      <div class="row">
        <div class="col-12 mt-3 mb-3">
          <label class="form-label fw-bold fs-5">NOTICE :</label>
          <label class="form-label fs-6">Purchased item can return befor 7 days of Delivery</label>
        </div>
      </div>
    </div>

    <div class="col-12">
      <hr class="border border-1 border-primary"/>
    </div>

    <div class="col-12 text-black-50 text-center mb-3">
      <label class="form-label fs-5 text-black-50 fw-bold">
        Invoice was created on a computer and is valid without the signature and Seal.
      </label>
    </div>

  </div>
</div>

<jsp:include page="footer.jsp" />

</div>
</div>

<script src="assets/js/script.js"></script>
<script src="js/html2canvas.min.js"></script>
<script src="js/jsPDF/dist/jspdf.min.js"></script>
</body>
</html>
