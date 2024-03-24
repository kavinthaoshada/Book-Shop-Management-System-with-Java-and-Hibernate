<%@ page import="com.calm.webdb.entity.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.UsersEntity" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.EmpProfileImageEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
        List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
        if (employees != null) {
            for (EmployeeEntity employee : employees) {

                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session1 = sessionFactory.openSession();
                Transaction transaction = session1.beginTransaction();

%>


<div class="col-12 col-lg-2 shadow mx-3 my-3" style="background-color: rgb(241, 214, 214);">
    <div class="row">

        <div class="align-items-start col-12">
            <div class="row g-1 text-center">

                <%

                    Query<EmpProfileImageEntity> query = session1.createQuery("SELECT e FROM EmpProfileImageEntity e WHERE e.employeeEmpEmail = :email", EmpProfileImageEntity.class)
                            .setParameter("email", employee.getEmpEmail());
                    List<EmpProfileImageEntity> empProfileImages = query.getResultList();
                    transaction.commit();
                    session1.close();
                    boolean existEmpProfileImage = false;
                    String imgPath = null;
                    for (EmpProfileImageEntity empProfileImage : empProfileImages) {
                            existEmpProfileImage = true;
                            imgPath = empProfileImage.getPath();
                    }
                    if(existEmpProfileImage){
                %>
                <div class="col-4 py-2 d-none d-lg-block rounded" style="background-color: rgb(241, 214, 214);">
                    <img src="<%= imgPath %>" style="height: 40px; margin-left: 80px;"/>
                </div>
                <%
                    }else{
                %>
                <div class="col-4 bg-light py-2 d-none d-lg-block bg-dark">
                    <img src="assets/resources/user_icon.svg" style="height: 40px; margin-left: 80px;"/>
                </div>
                <%
                    }
                %>

                <div class="col-12 mt-5">
                    <h4 class="text-black"><%= employee.getFname()+" "+employee.getLname() %></h4>
                    <hr class="border border-1 border-white"/>
                </div>

                <div class="nav flex-column nav-pills me-3 mt-3">
                    <div class="nav flex-column text-black-50 text-lg-start">
                        <a class="nav-link fs-5 active" href="adminPanel">Dashbord</a>
                        <a class="nav-link fs-5 text-black-50" href="grn">GRN</a>
                        <a class="nav-link fs-5 text-black-50" href=" ">Invoice</a>
                        <a class="nav-link fs-5 text-black-50" href="stock">Manage Stock</a>
                        <a class="nav-link fs-5 text-black-50" href="addproduct">Add Book</a>
                        <a class="nav-link fs-5 text-black-50" href="manageUsers">Manage Users</a>
                        <a class="nav-link fs-5 text-black-50" href="manageProducts">Manage Categories</a>
                        <a class="nav-link fs-5 text-black-50" href="#" onclick="empRegModal();">Employee Registration</a>
                        <a class="nav-link fs-5 text-black-50" href="viewEmployee">View Employee</a>
                        <a class="nav-link fs-5 text-black-50" href="#" onclick="vendorModal();">Vendors Registration</a>
                        <a class="nav-link fs-5 text-black-50" href="vendorUpdate">View Vendors</a>
                        <a class="nav-link fs-5 text-black-50" href="sellingHistory">Selling History</a>
                    </div>
                </div>

                <div class="col-12 mt-3">
                    <hr class="border border-1 border-white"/>
                    <h4 class="text-white">Selling History</h4>
                    <hr class="border border-1 border-white"/>
                </div>

                <div class="col-12 mt-3 d-grid">
                    <h5 class="text-white fw-bold">From Date</h5>
                    <input type="date" class="form-control" />
                    <h5 class="text-white fw-bold">To Date</h5>
                    <input type="date" class="form-control" />
                    <a class="btn btn-primary fw-bold mt-2" href="#">View Selling</a>
                    <hr class="border border-1 border-white"/>
                    <hr class="border border-1 border-white"/>
                </div>

            </div>
        </div>

    </div>
</div>

<%
    }
}else{
%>
<script>
    alert("Please Sign In First");
    fetch("adminSignIn", {
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

