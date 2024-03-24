<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.EmployeeEntity" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Employee View</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="dashBord.jsp"/>
        <%
            List<EmployeeEntity> empSessions = (List<EmployeeEntity>)session.getAttribute("a");
            if(empSessions != null){
              for(EmployeeEntity empSession : empSessions){
                  if(empSession.getEmployeeTypeId()==1){
                      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                      Session hibernateSession = sessionFactory.openSession();
                      Transaction transaction = hibernateSession.beginTransaction();

        %>

        <div class="col-12 col-lg-9">
            <div class="row">

                <div class="row">
                    <div class="col-12 col-lg-12 ">

                        <div class="col-12 col-lg-6">
                            <span class="fs-1 text-center text-success">View Employee</span>
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

                                                <div class="col-2 bg-primary text-end">
                                                    <label class="form-label fs5 fw-bold text-white">Email</label>
                                                </div>
                                                <div class="col-1 bg-secondary text-end">
                                                    <label class="form-label fs5 fw-bold text-white">Username</label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black">Mobile Number</label>
                                                </div>
                                                <div class="col-2 bg-secondary text-end">
                                                    <label class="form-label fs-5 fw-bold text-white">Name</label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black">Joined Date</label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <div class="col-10 offset-1">
                                    <hr class=" hr-break-1"/>
                                </div>
                                <%
                                    Query<EmployeeEntity> employeeEntityQuery = hibernateSession.createQuery("SELECT e FROM EmployeeEntity e " +
                                            "WHERE e.empEmail != 'none'", EmployeeEntity.class);
                                    List<EmployeeEntity> employees = employeeEntityQuery.getResultList();
                                    for(EmployeeEntity employee : employees){
                                %>

                                <!-- loop -->
                                <div class="col-12 col-lg-11 offset-1 ml-2 mb-1 shadow" style="background-color: rgb(234, 238, 195);">
                                    <div class="row">
                                        <div class="col-12" id="loadResults">
                                            <div class="row" id="box">

                                                <div class="col-2 bg-primary text-end">
                                                    <label class="form-label fs5 fw-bold text-white"><%= employee.getEmpEmail() %></label>
                                                </div>
                                                <div class="col-1 bg-secondary text-end">
                                                    <label class="form-label fs5 fw-bold text-white"><%= employee.getUsername() %></label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black"><%= employee.getMobile() %></label>
                                                </div>
                                                <div class="col-2 bg-secondary text-end">
                                                    <label class="form-label fs-5 fw-bold text-white"><%= employee.getFname()+" "+employee.getLname() %></label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <label class="form-label fs-5 fw-bold text-black"><%= employee.getJoinedDate() %></label>
                                                </div>
                                                <div class="col-2 text-end" style="background-color: rgb(234, 238, 195);">
                                                    <div class="row">
                                                        <%
                                                           if(employee.getStatus()==1){
                                                        %>
                                                        <button class="btn btn-danger col-11 my-1 mx-3" onclick="empBlock('<%= employee.getEmpEmail() %>');">Inactive</button>
                                                        <%
                                                           }else if(employee.getStatus()==0) {
                                                        %>
                                                        <button class="btn btn-warning col-11 my-1 mx-3" onclick="empBlock('<%= employee.getEmpEmail() %>');">Active</button>
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

            </div>
        </div>
    </div>
</div>

<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

<%
           transaction.commit();
           hibernateSession.close();
       }else{
%>

<script>
    alert("Access Denied!");
    fetch("adminpanel", {
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
