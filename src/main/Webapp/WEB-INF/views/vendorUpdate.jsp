<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.VendorEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Vendors View</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="dashBord.jsp" />

        <div class="col-12 col-lg-9">
            <div class="row">

                <div class="row">
                    <div class="col-12 col-lg-12 ">

                        <div class="col-12 col-lg-6">
                            <span class="fs-1 text-center text-success">View Vendors</span>
                        </div>

                        <div class="col-12">
                            <hr class="hr-break-1"/>
                        </div>

                        <div class="col-12">
                            <div class="col-12 mx-2 my-2">

                                <!--  -->
                                <div class="col-12 col-lg-11 offset-1 ml-2 shadow" style="background-color: rgb(234, 238, 195);">
                                    <div class="row">

                                        <div class="col-12" id="loadResults">
                                            <div class="row" id="box">

                                                <div class="col-1 bg-primary text-end">
                                                    <label class="form-label fs5 fw-bold text-white">ID</label>
                                                </div>
                                                <div class="col-1 bg-secondary text-end">
                                                    <label class="form-label fs5 fw-bold text-white">Name</label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black">Mobile Number</label>
                                                </div>
                                                <div class="col-3 bg-secondary text-end">
                                                    <label class="form-label fs-5 fw-bold text-white">Publication</label>
                                                </div>
                                                <div class="col-4 text-end" style="background-color: rgb(234, 238, 195);">
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <div class="col-10 offset-1">
                                    <hr class=" hr-break-1"/>
                                </div>

                                <%
                                    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                    Session hibernateSession = sessionFactory.openSession();
                                    Transaction transaction = hibernateSession.beginTransaction();
                                    Query<VendorEntity> vendorEntityQuery = hibernateSession.createQuery("SELECT v " +
                                            "FROM VendorEntity v", VendorEntity.class);
                                    List<VendorEntity> vendors = vendorEntityQuery.getResultList();
                                    for(VendorEntity vendor : vendors){
                                %>
                                <!-- loop -->
                                <div class="col-12 col-lg-11 offset-1 ml-2 shadow" style="background-color: rgb(234, 238, 195);">
                                    <div class="row">
                                        <div class="col-12" id="loadResults">
                                            <div class="row" id="box">

                                                <div class="col-1 bg-primary text-end">
                                                    <label class="form-label fs5 fw-bold text-white"><%= vendor.getId() %></label>
                                                </div>
                                                <div class="col-1 bg-secondary text-end">
                                                    <label class="form-label fs5 fw-bold text-white"><%= vendor.getName() %></label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black"><%= vendor.getMobile() %></label>
                                                </div>
                                                <div class="col-3 bg-secondary text-end">
                                                    <label class="form-label fs-5 fw-bold text-white" ><%= vendor.getPublication() %></label>
                                                </div>
                                                <div class="col-5 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <div class="row">
                                                        <a href='vendorUpdatePage?id=<%= vendor.getId() %>' class="btn btn-warning col-5 my-1 mx-3">Update</a>
                                                        <%
                                                          if(vendor.getStatus()==1){
                                                        %>
                                                        <button class="btn btn-danger col-5 my-1 mx-3" onclick="vendorBlock(<%= vendor.getId() %>);">Inactive</button>
                                                        <%
                                                          }else if(vendor.getStatus()==1){
                                                        %>
                                                        <button class="btn btn-warning col-5 my-1 mx-3" onclick="vendorBlock(<%= vendor.getId() %>);">Active</button>
                                                        <%
                                                          }
                                                        %>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- loop -->
                                <%
                                 }
                                %>
                                <!--  -->
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="modals.jsp" />
                <%
                    for(VendorEntity vendorModal : vendors){
                %>
                <!--vendor update modal -->

                <div class="modal" tabindex="-1" id="vendorUpdateModal<%= vendorModal.getId() %>">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Vendor Update</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">


                            <div class="col-12">
                                <p class="title02">Vendor Update</p>
                                <span class="text-danger" id="msg2"></span>
                            </div>

                            <div class="col-12">
                                <label class="form-label">ID</label>
                                <input type="text" class="form-control" id="m_id"  disabled/>
                            </div>
                            <div class="col-12">
                                <label class="form-label">Name</label>
                                <input type="text" class="form-control" id="m_name"  disabled/>
                            </div>
                            <div class="col-12">
                                <label class="form-label">Mobile Number</label>
                                <input type="text" class="form-control" id="m_mno"/>
                            </div>
                            <div class="col-12">
                                <label class="form-label">Publication</label>
                                <input type="text" class="form-control" id="m_pub"/>
                            </div>
                        </div>

                        <div class="modal-footer">

                            <div class="col-12 d-grid">
                                <div class="row">
                                    <div class="col-6">
                                        <button class="btn btn-primary col-12" onclick="vendorUpdateProcess(<%= vendorModal.getId() %>);">Update</button>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- vendor update modal-->
        <%
            }
        %>
    </div>
</div>
</div>
</div>

<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>
