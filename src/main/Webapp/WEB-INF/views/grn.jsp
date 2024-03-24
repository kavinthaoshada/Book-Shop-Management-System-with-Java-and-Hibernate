<%@ page import="com.calm.webdb.entity.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.VendorEntity" %>
<%@ page import="com.calm.webdb.entity.PaymentTypeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
    if (employees != null) {
        for (EmployeeEntity employee : employees) {

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | GRN</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="">
<div class="container-fluid">
    <div class="row gy-3">

        <div class="col-12 text-center">
            <h2 class="h2 text-success fw.bold">Create New GRN</h2>
        </div>

        <div class="col-12 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-12 col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label lbl1 fw-bold">Select Vendor</label>
                        </div>
                        <div class="col-12 mb-3">
                            <select class="form-select" id="vendor">
                                <option value="0">Select Vendor</option>
                                <%
                                    // Assuming Database is a Java class with a search method
                                    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                    Session session1 = sessionFactory.openSession();
                                    Transaction transaction = session1.beginTransaction();

                                    // Assuming your entity class is "Gender" and you have a Gender class mapped in Hibernate
                                    List<VendorEntity> vendors = session1.createQuery("FROM VendorEntity", VendorEntity.class).list();


                                    for (VendorEntity vendor : vendors) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                                %>

                                <option value="<%= vendor.getId()%>"><%= vendor.getName()%></option>

                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary mt-3 search-btn col-12" onclick="testModal();">Select Book</button>
                        </div>
                        <div class="col-6">
                            <label class="form-label lbl1 fw-bold">Book ID</label>
                        </div>
                        <div class="col-6">
                            <label class="form-label lbl1 fw-bold">Book Name</label>
                        </div>
                        <div class="col-6 mb-2">
                            <label class="form-label lbl1" id="bookID">None</label>
                        </div>
                        <div class="col-6 mb-2">
                            <label class="form-label lbl1" id="bookName">None</label>
                        </div>
                    </div>
                </div>



                <div class="col-12 col-lg-4">
                    <div class="row">
                        <label class="form-label fw-bold lbl1">Add Quantity</label>
                        <input type="number" class="form-control" value="0" min="0" id="qty"/>
                    </div>
                </div>

                <hr/>

                <div class="col-12">
                    <div class="row">

                        <div class="col-12">
                            <label class="form-label fw-bold lbl1">Delivery Costs</label>
                        </div>

                        <div class="col-12 col-lg-6">
                            <div class="row">

                                <div class="col-12 offset-lg-1 col-lg-3">
                                    <label >Delivery cost within Colombo</label>
                                </div>
                                <div class="col-12 col-lg-8">
                                    <div class="input-group mb-3">
                                        <span class="input-group-text">Rs.</span>
                                        <input type="text" class="form-control" aria-label="Amount (to the nearest rupee)" id="dwc">
                                        <span class="input-group-text">.00</span>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="col-12 col-lg-6">
                            <div class="row">

                                <div class="col-12 offset-lg-1 col-lg-3">
                                    <label >Delivery cost out of Colombo</label>
                                </div>
                                <div class="col-12 col-lg-8">
                                    <div class="input-group mb-3">
                                        <span class="input-group-text">Rs.</span>
                                        <input type="text" class="form-control" aria-label="Amount (to the nearest rupee)" id="doc">
                                        <span class="input-group-text">.00</span>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>

                <hr/>

                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label fw-bold lbl1">Buying Price</label>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">Rs.</span>
                            <input type="text" class="form-control" aria-label="Amount (to the nearest rupee)" id="bprice">
                            <span class="input-group-text">.00</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label fw-bold lbl1">Selling Price</label>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">Rs.</span>
                            <input type="text" class="form-control" aria-label="Amount (to the nearest rupee)" id="sprice">
                            <span class="input-group-text">.00</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-primary mt-3 search-btn col-12" onclick="addtogrn();">Add to GRN</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-12">
            <table class="table" id="grntable">
                <thead>

                <tr class="border border-1 border-white">
                    <th class="text-center">Book ID</th>
                    <th class="text-center">Book Name</th>
                    <th class="text-center">Quantity</th>
                    <th class="text-center">Delivery Fee Colombo</th>
                    <th class="text-center">Delivery Fee Other</th>
                    <th class="text-center">Buying Price</th>
                    <th class="text-center">Selling Price</th>
                    <th class="text-center">Total</th>
                </tr>

                </thead>
                <tbody class="text-black fs-3 fw-bold">
                <!-- <tr style="height: 72px;">
                    <td class="bg-primary text-white fs-3">001</td>
                    <td class="bg-primary text-white fs-3">Mother</td>
                    <td class="fw-bold fs-6 text-end pt-3 bg-secondary text-white">Hasitha</td>
                    <td class="fw-bold fs-6 text-end pt-3">5</td>
                    <td class="fw-bold fs-6 text-end bg-primary text-white">Rs. 300 .00</td>
                    <td class="fw-bold fs-6 text-end bg-primary text-white">Rs. 500 .00</td>
                    <td class="fw-bold fs-6 text-end bg-primary text-white">Rs. 1500 .00</td>
                </tr> -->
                </tbody>

                <!-- <tfoot>

                <tr>
                    <td colspan="3" class="border-0"></td>
                    <td class="fs-5 text-end">SUBTOTAL</td>
                    <td class="text-end" id="subtotal">Rs. 0 .00</td>
                </tr>

                <tr>
                    <td colspan="3" class="border-0"></td>
                    <td class="fs-5 text-end ">Discount</td>
                    <td class="text-end ">Rs. 200 .00</td>
                </tr>

                <tr>
                    <td colspan="3" class="border-0"></td>
                    <td class="fs-5 text-end text-white fw-bold">GRAND TOTAL</td>
                    <td class="fs-5 text-end text-white fw-bold">Rs. 1300 .00</td>
                </tr>

                </tfoot> -->
            </table>
        </div>

        <div class="col-12 col-lg-4 offset-lg-8 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-12 fs-5">
                    <label class="form-label lbl1 text-black col-6 fs-6">SUBTOTAL</label>
                    <div class="col-6">
                        <label class="form-label lbl1 text-black col-2 fs-6">Rs.</label>
                        <label class="form-label lbl1 text-black col-2 fs-6" id="subtotal">0</label>
                        <label class="form-label lbl1 text-black col-2 fs-6">.00</label>
                    </div>

                    <hr/>

                </div>

            </div>
        </div>

        <div class="col-12 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-12 col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label lbl1 fw-bold">Select Payment Type</label>
                        </div>
                        <div class="col-12 mb-3">
                            <select class="form-select" id="ptype">
                                <%
                                    List<PaymentTypeEntity> paymentTypes = session1.createQuery("FROM PaymentTypeEntity", PaymentTypeEntity.class).list();

                                    transaction.commit();
                                    session1.close();

                                    for (PaymentTypeEntity paymentType : paymentTypes) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                                %>

                                <option value="<%= paymentType.getId()%>"><%= paymentType.getName()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label fw-bold lbl1">Payment</label>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">Rs.</span>
                            <input type="text" class="form-control" aria-label="Amount (to the nearest rupee)" onkeyup="balanceCal();" id="payment">
                            <span class="input-group-text">.00</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label fw-bold lbl1">Balance</label>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">Rs.</span>
                            <input type="text" class="form-control bg-transparent" aria-label="Amount (to the nearest rupee)" id="balance" disabled>
                            <span class="input-group-text">.00</span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mb-5">
                    <div class="row">
                        <div class="col-12">
                            <button class="btn btn-success mt-3 search-btn col-12" onclick="creategrn();">Print GRN</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
<jsp:include page="bookSelectModal.jsp"/>

<script src="assets/js/script.js"></script>
<script src="assets/js/grnScript.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

<%
    }
}else{
%>

<script>
    alert("Please Sign In First");
    // window.location = "adminSignin.php";
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
