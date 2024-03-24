<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.LanguageEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Add Books</title>

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>

<div class="container-fluid">
    <div class="row gy-3">

        <jsp:include page="dashBord.jsp"/>

        <div class="col-12 col-lg-9 shadow">
            <div class="row">

                <div class="col-12">
                    <div class="row">
                        <div class="col-12 text-center">
                            <label class="border-start border-start-5 border-5 border-success mt-4 mb-4 text-center col-12 fs-2 text-success" style="background-color: #c5f0c7; height: 50px;">
                                Add New Book
                            </label>
                        </div>

                        <div class="col-12 col-lg-10 offset-1 border border-1 rounded main-body shadow">
                            <div class="row">

                                <div class="col-12 col-lg-4">
                                    <div class="row">
                                        <div class="col-12">
                                            <label class="form-label lbl1">Select Book Category</label>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <select class="form-select" id="category">
                                                <option value="0">Select Category</option>
                                                <%
                                                    // Assuming Database is a Java class with a search method
                                                    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                                    Session session1 = sessionFactory.openSession();
                                                    Transaction transaction = session1.beginTransaction();

                                                    // Assuming your entity class is "Gender" and you have a Gender class mapped in Hibernate
                                                    List<CategoryEntity> categories = session1.createQuery("FROM CategoryEntity", CategoryEntity.class).list();


                                                    for (CategoryEntity category : categories) {
                                                %>

                                                <option value="<%= category.getId()%>"><%= category.getName()%></option>

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
                                            <label class="form-label lbl1">Add Author</label>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <input type="text" class="form-control" id="author"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-lg-4">
                                    <div class="row">
                                        <div class="col-12">
                                            <label class="form-label lbl1">Add Publisher</label>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <input type="text" class="form-control" id="publisher"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12">
                                    <hr class="hr-break-1"/>
                                </div>

                                <div class="col-lg-12">
                                    <div class="row">



                                        <div class="col-12 col-lg-6">
                                            <div class="row">
                                                <div class="col-12">
                                                    <label class="form-label lbl1">Add book title</label>
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <input type="text" class="form-control" id="title"/>
                                                </div>

                                            </div>

                                        </div>

                                        <div class="col-12 col-lg-6">
                                            <div class="row">
                                                <div class="col-12">
                                                    <label class="form-label fw-bold lbl1">Book Format</label>
                                                </div>
                                                <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                    <input class="form-check-input" type="checkbox" value="" id="hformat">
                                                    <label class="form-check-label" for="hformat">
                                                        Hardcover
                                                    </label>
                                                </div>
                                                <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                    <input class="form-check-input" type="checkbox" value="" id="eformat">
                                                    <label class="form-check-label" for="eformat">
                                                        eBook
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-12">
                                            <hr class="hr-break-1"/>
                                        </div>

                                        <div class="col-12">
                                            <div class="row">
                                                <div class="col-12 col-lg-6">
                                                    <div class="row">
                                                        <div class="col-12">
                                                            <label class="form-label fw-bold lbl1">Condition</label>
                                                        </div>
                                                        <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                            <input class="form-check-input" type="radio" name="condition" id="bn" checked/>
                                                            <label class="form-check-label" for="bn">
                                                                Brand New
                                                            </label>
                                                        </div>
                                                        <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                            <input class="form-check-input" type="radio" name="condition" id="us"/>
                                                            <label class="form-check-label" for="us">
                                                                Used
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-12 col-lg-6">
                                                    <div class="row">

                                                        <div class="col-12">
                                                            <label class="form-label lbl1 fw-bold">Select Language</label>
                                                        </div>
                                                        <div class="col-12 mb-3">
                                                            <select class="form-select" id="lang">
                                                                <option value="0">Select Language</option>
                                                                <%
                                                                    List<LanguageEntity> languages = session1.createQuery("FROM LanguageEntity", LanguageEntity.class).list();

                                                                    transaction.commit();
                                                                    session1.close();

                                                                    for (LanguageEntity language : languages) {
                                                                %>

                                                                <option value="<%= language.getId()%>"><%= language.getName()%></option>

                                                                <%
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>

                                                    </div>
                                                </div>



                                            </div>
                                        </div>

                                    </div>

                                    <hr class="hr-break-1"/>

                                    <!-- //k -->

                                    <div class="row">



                                        <div class="col-12">
                                            <div class="row">
                                                <!-- com -->
                                                <div class="col-12 col-lg-6">
                                                    <div class="row">
                                                        <div class="col-12">
                                                            <label class="form-label fw-bold lbl1">Edition</label>
                                                        </div>
                                                        <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                            <input class="form-check-input" type="radio" name="Edition" id="fprint" checked/>
                                                            <label class="form-check-label" for="fprint">
                                                                First Print
                                                            </label>
                                                        </div>
                                                        <div class="offset-1 col-11 col-lg-3 ms-5 form-check">
                                                            <input class="form-check-input" type="radio" name="Edition" id="rprint"/>
                                                            <label class="form-check-label" for="rprint">
                                                                Reprint
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- com -->

                                                <div class="col-12 col-lg-6">
                                                    <div class="row">

                                                        <label class="form-label fw-bold lbl1">Pages</label>
                                                        <input type="number" class="form-control" value="0" min="0" id="pages"/>

                                                    </div>
                                                </div>



                                            </div>
                                        </div>

                                    </div>

                                    <hr class="hr-break-1"/>

                                    <div class="col-12">
                                        <div class="row">

                                            <div class="col-12">
                                                <label class="form-label fw-bold lbl1">Description</label>
                                            </div>
                                            <div clas="col-12">
                                                <textarea class="form-control" cols="30" rows="25" id="description"></textarea>
                                            </div>

                                        </div>
                                    </div>

                                    <hr class="hr-break-1"/>

                                    <div class="col-12">
                                        <label class="form-label fw-bold lbl1">Add images</label>
                                    </div>
                                    <div class="offset-lg-3 col-12 col-lg-6">
                                        <div class="row">
                                            <div class="col-4 offset-lg-4 border border-primary rounded">
                                                <img class="img-fluid" src="assets/resources/addproduct/addproductimg.svg" id="preview0" style="width: 250px;"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-12 offset-lg-3 col-lg-6 d-grid mt-3">

                                        <input type="file" accept="img/*" class="d-none" id="imageuploader" multiple/>
                                        <label for="imageuploader" class="col-12 btn btn-primary" onclick="changeProductImage();">Upload image</label>

                                    </div>

                                </div>


                            </div>
                            <hr class="hr-break-1">



                            <div class="offset-lg-4 col-12 col-lg-4 d-grid mb-3 mt-2">
                                <button class="btn btn-success fw-bold" onclick="addproduct();">Add Book</button>
                            </div>



                        </div>

                    </div>
                </div>


            </div>
        </div>
        <jsp:include page="modals.jsp"/>

    </div>
</div>

<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>
