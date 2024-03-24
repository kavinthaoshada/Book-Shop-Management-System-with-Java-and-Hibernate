<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.GenderEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.EmployeeTypeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--vendor registration modal -->

<div class="modal" tabindex="-1" id="vendorModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Vendor Registration</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">


                <div class="col-12">
                    <p class="title02">Vendor Registration</p>
                    <span class="text-danger" id="msg2"></span>
                </div>

                <div class="col-12">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" id="r_name"/>
                </div>
                <div class="col-12">
                    <label class="form-label">Mobile Number</label>
                    <input type="text" class="form-control" id="mno"/>
                </div>
                <div class="col-12">
                    <label class="form-label">Publication</label>
                    <input type="text" class="form-control" id="pub"/>
                </div>



            </div>



            <div class="modal-footer">

                <div class="col-12 d-grid">
                    <div class="row">
                        <div class="col-6">
                            <button class="btn btn-primary col-12" onclick="vendorRegister();">Register</button>
                        </div>
                    </div>


                </div>


            </div>
        </div>
    </div>
</div>
</div>

<!-- vendor registration modal-->

<!-- emp reg modal 2 -->

<div class="modal" tabindex="-1" id="empreg">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Employee Registration</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">


                <div class="col-12">
                    <p class="title02">Register New Employee</p>
                    <span class="text-danger" id="msg"></span>
                </div>

                <div class="row">
                    <div class="col-6">
                        <label class="form-label">First Name</label>
                        <input type="text" class="form-control" id="fname"/>
                    </div>
                    <div class="col-6">
                        <label class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lname"/>
                    </div>
                </div>

                <div class="col-12">
                    <label class="form-label">Username</label>
                    <input type="text" class="form-control" id="uname"/>
                </div>

                <div class="col-12">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" id="email"/>
                </div>
                <div class="col-12">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" id="password"/>
                </div>

                <div class="row">
                    <div class="col-6">
                        <label class="form-label">Mobile</label>
                        <input type="text" class="form-control" id="mobile"/>
                    </div>
                    <div class="col-6">
                        <label class="form-label">Gender</label>
                        <select class="form-select" id="gender">

                            <%
                                // Assuming Database is a Java class with a search method
                                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                Session session1 = sessionFactory.openSession();
                                Transaction transaction = session1.beginTransaction();

                                // Assuming your entity class is "Gender" and you have a Gender class mapped in Hibernate
                                List<GenderEntity> genders = session1.createQuery("FROM GenderEntity", GenderEntity.class).list();


                                StringBuilder options = new StringBuilder();

                                for (GenderEntity gender : genders) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                            %>

                            <option value="<%= gender.getId()%>"><%= gender.getName()%></option>

                            <%
                                }
                            %>


                        </select>
                    </div>
                </div>
                <div class="col-12">
                    <label class="form-label">Employee Type</label>
                    <select class="form-select" id="emp_type">

                        <%
                            List<EmployeeTypeEntity> empTypes = session1.createQuery("FROM EmployeeTypeEntity", EmployeeTypeEntity.class).list();

                            transaction.commit();
                            session1.close();

                            for (EmployeeTypeEntity empType : empTypes) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                        %>

                        <option value="<%= empType.getId()%>"><%= empType.getName()%></option>

                        <%
                            }
                        %>
                    </select>
                </div>

            </div>

            <div class="modal-footer">

                <div class="col-12 d-grid">
                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary col-12" onclick="empReg();">Register</button>
                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>
</div>

<!-- emp reg modal 2-->




