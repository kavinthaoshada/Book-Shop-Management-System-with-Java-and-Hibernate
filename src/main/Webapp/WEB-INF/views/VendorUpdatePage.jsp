<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.VendorEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String vendorId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Vendors Update</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="">
<div class="container-fluid">
    <div class="row">

        <%
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session hibernateSession = sessionFactory.openSession();
            Transaction transaction = hibernateSession.beginTransaction();
            Query<VendorEntity> vendorEntityQuery = hibernateSession.createQuery("SELECT v FROM VendorEntity v " +
                    "WHERE v.id= :id", VendorEntity.class)
                    .setParameter("id", vendorId);
            VendorEntity vendor = vendorEntityQuery.uniqueResult();
        %>

        <div class="col-12 col-md-6 col-lg-4 offset-md-3 offset-lg-4 border border-3 border-success rounded text-center shadow" style="margin-top: 200px; background-color: rgb(234, 238, 195);">

            <div class="col-12">
                <p class="title02">Vendor Update</p>
                <span class="text-danger" id="msg2"></span>
            </div>

            <div class="col-12">
                <label class="form-label fw-bold">ID</label>
                <input type="text" class="form-control bg-transparent text-black" id="m_id" value="<%= vendorId %>" disabled/>
            </div>
            <div class="col-12">
                <label class="form-label fw-bold">Name</label>
                <input type="text" class="form-control bg-transparent text-black" id="m_name" value="<%= vendor.getName() %>" disabled/>
            </div>
            <div class="col-12">
                <label class="form-label fw-bold">Mobile Number</label>
                <input type="text" class="form-control bg-transparent text-black" id="m_mno" value="<%= vendor.getMobile() %>"/>
            </div>
            <div class="col-12 mb-3">
                <label class="form-label fw-bold">Publication</label>
                <input type="text" class="form-control bg-transparent text-black" id="m_pub" value="<%= vendor.getPublication() %>"/>
            </div>

            <div class="col-12 mb-5">
                <button class="btn btn-success col-12" onclick="vendorUpdateProcess();">Register</button>
            </div>

        </div>

    </div>
</div>

<script src="assets/js/script.js"></script>
</body>
</html>
