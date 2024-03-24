<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
    if (employees != null) {
        for (EmployeeEntity employee : employees) {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session hibernateSession = sessionFactory.openSession();
            Transaction transaction = hibernateSession.beginTransaction();

%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Infinity | Admin | Manage Products</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/style.css" />
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="icon" href="assets/resources/logo.svg" />
</head>

<body class="">

<div class="container-fluid">
    <div class="row">

        <div class="col-12 bg-light text-center">
            <h2 class="text-primary fw-bold">View All Stock and Manage Categories</h2>
        </div>

        <div class="col-12 mt-3">
            <div class="row">

                <div class="offset-0 offset-lg-3 col-12 col-lg-6 mb-3">
                    <div class="row">

                        <div class="col-9">
                            <input type="text" class="form-control" />
                        </div>

                        <div class="col-3 d-grid">
                            <button class="btn btn-warning">Search</button>
                        </div>

                    </div>
                </div>

            </div>
        </div>

        <div class="col-12 mt-3 mb-3 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-2 col-lg-1 bg-primary py-2 text-end">
                    <span class="fs-4 fw-bold text-white">#</span>
                </div>

                <div class="col-2 bg-light d-none d-lg-block py-2 ">
                    <span class="fs-4 fw-bold">Book Image</span>
                </div>

                <div class="col-4 col-lg-2 bg-primary py-2 ">
                    <span class="fs-4 fw-bold text-white">Title</span>
                </div>

                <div class="col-4 col-lg-2 bg-light py-2 ">
                    <span class="fs-4 fw-bold">Price</span>
                </div>

                <div class="col-4 col-lg-2 bg-primary py-2 ">
                    <span class="fs-4 fw-bold text-white">QTY</span>
                </div>

                <div class="col-2 bg-light d-none d-lg-block py-2 ">
                    <span class="fs-4 fw-bold">Date Time Added</span>
                </div>

                <div class="col-2 col-lg-1 bg-white"></div>

            </div>
        </div>

        <%

                String page1 = request.getParameter("page");
                int pageNo = 0;
                if(!page1.isEmpty()){
                    pageNo = 1;
                }

                Query<StockEntity> stockEntityQuery = hibernateSession.createQuery("SELECT s " +
                        "FROM StockEntity s", StockEntity.class);
                List<StockEntity> stockItems = stockEntityQuery.getResultList();
                int stockItemsResultSize = stockItems.size();

            int resultPerPage = 10;
            int numberOfPage = (int) Math.ceil((double) stockItemsResultSize / resultPerPage);;

            int pageFirstResult = (pageNo - 1) * resultPerPage;

            Query<GrnItemEntity> grnItemEntityQuery = hibernateSession.createQuery("SELECT gi FROM GrnItemEntity gi " +
                    "INNER JOIN gi.grnByGrnId g " +
                    "INNER JOIN gi.StockByStockId s " +
                    "INNER JOIN s.bookByBookId b", GrnItemEntity.class)
                    .setFirstResult(pageFirstResult)
                    .setMaxResults(resultPerPage);
            List<GrnItemEntity> grnItems = grnItemEntityQuery.getResultList();

            int c = 0;

            for(GrnItemEntity grnItem : grnItems){
            c++;
        %>

        <div class="col-12 mb-3 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row">

                <div class="col-2 col-lg-1 bg-primary py-2 text-end">
                    <div class="fs-4 fw-bold text-white"><%= grnItem.getStockByStockId().getId() %></div>
                </div>

                <%
                    Query<ImagesEntity> imagesEntityQuery = hibernateSession.createQuery("SELECT i FROM ImagesEntity i " +
                            "WHERE i.productId= :bookId", ImagesEntity.class)
                            .setParameter("bookId", grnItem.getStockByStockId().getBookId());
                    ImagesEntity image = imagesEntityQuery.uniqueResult();
                %>

                <div class="col-2 bg-light py-2 d-none d-lg-block" onclick="viewProductModal(<%= grnItem.getStockByStockId().getId() %>);">
                    <img src="<%= image.getCode() %>" style="height: 40px ; margin-left: 80px ;" />
                </div>

                <div class="col-4 col-lg-2 bg-primary py-2 ">
                    <span class="fs-4 fw-bold text-white"><%= grnItem.getStockByStockId().getBookByBookId().getTitle() %></span>
                </div>

                <div class="col-4 col-lg-2 bg-light py-2 d-lg-block">
                    <span class="fs-4 fw-bold "><%= grnItem.getStockByStockId().getSellingPrice() %></span>
                </div>

                <div class="col-4 col-lg-2 bg-primary py-2 d-none d-lg-block">
                    <span class="fs-4 fw-bold text-white"><%= grnItem.getStockByStockId().getQty() %></span>
                </div>

                <div class="col-2 bg-light py-2 d-none d-lg-block">
                            <span class="fs-4 fw-bold ">
                            <%= grnItem.getGrnByGrnId().getDateTime() %>
                            </span>
                </div>

                <div class="col-2 col-lg-1 bg-white py-2 d-grid">



                </div>

            </div>
        </div>

        <!-- modal 1 -->
        <div class="modal" tabindex="-1" id="viewproductmodal<%= grnItem.getStockByStockId().getId() %>">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"><%= grnItem.getStockByStockId().getBookByBookId().getTitle() %></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="offset-lg-4 col-4">
                            <img src="<%= image.getCode() %>" style="height: 150px;" class="img-fluid" />
                        </div>
                        <div class="col-12">
                            <span class="fs-5 text-success fw-bold"><%= grnItem.getStockByStockId().getBookByBookId().getTitle() %></span><br/>
                            <span class="fs-5 fw-bold">Price :</span>&nbsp;
                            <span class="fs-5">Rs. <%= grnItem.getStockByStockId().getSellingPrice() %>0</span><br/>
                            <span class="fs-5 fw-bold">Quantity :</span>&nbsp;
                            <span class="fs-5"><%= grnItem.getStockByStockId().getQty() %> Products left</span><br/>
                            <span class="fs-5 fw-bold">Description :</span>&nbsp;
                            <span class="fs-5"><%= grnItem.getStockByStockId().getBookByBookId().getDescription() %></span><br/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal 1 -->

        <%
            }
        %>

        <!-- pagination -->
        <div class="col-12 text-center justify-content-center align-content-center d-flex mb-4 mt-3">
            <div class="pagination">
                <a href="<%
                            String hash ="#";
                            String param = "?page="+(pageNo - 1);
                            String param1 = "?page="+(pageNo);
                            String param2 = "?page="+(pageNo + 1);
                                if(pageNo <= 1){
                        %>
                        <%= hash %>
                        <%
                            }else{
                        %>
                        <%= param %>
                        <%
                            }
                        %>">&laquo;</a>
                <%
                        for(int pageNumber = 1; pageNumber <= numberOfPage; pageNumber++){

                            if(pageNumber == pageNo){
                %>
                <a href="<%= param1 %>" class="active"><%= pageNumber %></a>
                <%
                    }else{
                %>
                <a href="<%= param1 %>"><%= pageNumber %></a>
                <%
                            }
                        }
                %>
                <a href="<%
                        if(pageNo >= numberOfPage){
                            %>
                            <%= hash %>
                            <%
                                }else{
                                %>
                                <%= param2 %>
                                <%
                                }
                                %>">&raquo;</a>
            </div>
        </div>
        <!-- pagination -->

        <div class="col-12 text-center">
            <h3>Manage Category</h3>
        </div>

        <div class="col-12 mb-3 shadow" style="background-color: rgb(234, 238, 195);">
            <div class="row g-2">
                <%
                        Query<CategoryEntity> categoryEntityQuery = hibernateSession.createQuery("SELECT c " +
                        "FROM CategoryEntity c", CategoryEntity.class);
                        List<CategoryEntity> categories = categoryEntityQuery.getResultList();

                for(CategoryEntity category : categories){
                %>

                <div class="col-12 col-lg-3 border border-danger" style="height: 50px;">
                    <div class="row">

                        <div class="col-8 mt-2">
                            <label><%= category.getName() %></label>
                        </div>

                        <div class="col-4 border-start border-secondary text-center mt-2" onclick="deleteCategoryVerify('<%= employee.getEmpEmail() %>', <%= category.getId() %>);">
                            <label class="form-label fs-4"><i class="bi bi-trash3-fill"></i></label>
                        </div>

                    </div>
                </div>

                <%
                        }
                %>

                <div class="col-12 col-lg-3 border border-danger bg-success" style="height: 50px;">
                    <div class="row">

                        <div class="col-8 mt-2">
                            <label class="form-label fw-bold fs-5">Add New Category</label>
                        </div>

                        <div class="col-4 border-start border-secondary text-center mt-2" onclick="addNewcategory();">
                            <label class="form-label fs-4"><i class="bi bi-shield-fill-plus"></i></label>
                        </div>

                    </div>
                </div>

            </div>
        </div>

        <!-- modal 2 -->
        <div class="modal" tabindex="-1" id="addCategoryModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>Add New Category</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="col-12">
                            <label class="form-label">New Category Name :</label>
                            <input type="text" class="form-control" id="n">
                        </div>
                        <div class="col-12">
                            <label class="form-label">Your Email Address :</label>
                            <input type="text" class="form-control" id="e">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="categoryVerifyModal();">Add Category</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal 2 -->

        <!-- modal 2 -->
        <div class="modal" tabindex="-1" id="addCategoryModalVerification">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>Verification</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="col-12">
                            <label class="form-label">Verification Code :</label>
                            <input type="text" class="form-control" id="t">
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="saveCategory();">Verify & Save</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal 2 -->

        <!-- modal 4 -->
        <div class="modal" tabindex="-1" id="deleteCategoryModalVerification">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>Verification</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="col-12">
                            <label class="form-label">Verification Code :</label>
                            <input type="text" class="form-control" id="vt">
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="deleteCategory();">Delete Category</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal 4 -->

    </div>
</div>
<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>

</html>

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
