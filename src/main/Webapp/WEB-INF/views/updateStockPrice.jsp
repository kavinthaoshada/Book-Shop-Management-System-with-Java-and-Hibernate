<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.StockEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.GrnItemEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String stockId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Infinity | Stock Price Update</title>

  <link rel="icon" href="assets/resources/infinity_logo2.svg" />
  <link rel="stylesheet" href="assets/css/bootstrap.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
  <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="sun-body">
<div class="container-fluid">
  <div class="row">
    <%
      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
      Session hibernateSession = sessionFactory.openSession();
      Transaction transaction = hibernateSession.beginTransaction();
      Query<StockEntity> stockEntityQuery = hibernateSession.createQuery("SELECT s FROM StockEntity s " +
              "WHERE s.id= :stockId", StockEntity.class)
              .setParameter("stockId", stockId);
      StockEntity stockItem = stockEntityQuery.uniqueResult();
    %>

    <div class="col-12 col-md-6 col-lg-4 offset-md-3 offset-lg-4 border border-3 border-success rounded text-center" style="margin-top: 200px;">

      <div class="col-12">
        <p class="title02">Price Update</p>
        <span class="text-danger" id="msg2"></span>
      </div>

      <div class="col-12">
        <label class="form-label fw-bold">ID</label>
        <input type="text" class="form-control bg-transparent text-black" id="s_id" value="<%= stockId %>" disabled/>
      </div>
      <div class="col-12">
        <label class="form-label fw-bold">Selling Price</label>
        <input type="text" class="form-control bg-transparent text-black" id="s_price" pattern="[1-9][0-9]*" value="<%= stockItem.getSellingPrice() %>"/>
      </div>
      <div class="col-12">
        <label class="form-label fw-bold">Delivery fee Colombo</label>
        <input type="text" class="form-control bg-transparent text-black" id="dow" pattern="[1-9][0-9]*" value="<%= stockItem.getDeliveryFeeColombo() %>"/>
      </div>
      <div class="col-12 mb-3">
        <label class="form-label fw-bold">Delivery fee Other</label>
        <input type="text" class="form-control bg-transparent text-black" id="doc" pattern="[1-9][0-9]*" value="<%= stockItem.getDeliveryFeeOther() %>"/>
      </div>
      <%
        Query<GrnItemEntity> grnItemEntityQuery = hibernateSession.createQuery("SELECT gi FROM GrnItemEntity gi " +
                "WHERE gi.stockId= :stockId", GrnItemEntity.class)
                .setParameter("stockId", stockId);
        GrnItemEntity grnItem = grnItemEntityQuery.uniqueResult();
      %>

      <input type="hidden" id="b_price" value="<%= grnItem.getBuyingPrice() %>"/>

      <div class="col-12 mb-5">
        <button class="btn btn-success col-12" onclick="spriceUpdate();">Register</button>
      </div>

    </div>

  </div>
</div>
<%
  transaction.commit();
  hibernateSession.close();
%>

<script src="assets/js/script.js"></script>
</body>
</html>
