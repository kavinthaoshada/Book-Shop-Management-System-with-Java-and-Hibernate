<%@ page import="java.util.Map" %>
<%@ page import="com.calm.webdb.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>

<body>

<div class="col-12 mb-3 bodyD" style="height: 500px;">
    <div class="row mt-1 mb-1">

        <div class="col-12 col-lg-10 offset-lg-1 align-self-start shodowC animEfect"
             style="background-color: gray; opacity: 0.8;">
            <div class="col-12">
                <img src="assets/resources/infinity_logo2.svg" style="width: 100px;" />
                <span class="text-black fw-bold fs-1">Infinity Bookshop</span>
            </div>
            <div class="col-12">
                    <span class="text-lg-start label1 text-black fs-3">Welcome

                        <%
                            session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
                            List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
                            if (users != null) {
                                for (UsersEntity user : users) {
//                            Object user = session.getAttribute("u");
//                            if (user != null) {
//                                Map<String, String> data = (Map<String, String>) user;
                        %>

                        <%= user.getFname() %>

                        </span>

                <span class="text-lg-start label2 text-info fs-3" onclick="signout();">Sign Out</span>

                <%
                    }} else {
                %>
                <a href="#" onclick="signInModal();" class="fs-3 signA">Sign In or Register</a>
                <%
                    }
                %>

                <span class=" text-black fs-3 fw-bolder"> | Help and Contact</span>

            </div>

        </div>

    </div>

</div>
<div style="height: 100px;"></div>

<div
        class="col-lg-4 offset-lg-4 col-md-8 offset-md-2 col-10 offset-1 shadow rounded shodowC animEfect2"
        style="background-color: gray; margin-top: 450px; height: 100px; position: absolute;">
    <div class="row">

        <div class="col-12 align-self-end" style="text-align: center;">

            <div class="row">

                <div class="col-6 mt-3">
                    <div class="col-2 offset-1">
                        <button onclick="home();" class="bg-transparent" style="border: none;"><label
                                class="form-label fs-3 bi bi-house-fill"></label></button>
                    </div>
                </div>

                <div class="col-6 dropdown">
                    <button class="btn btn-light dropdown-toggle bg-transparent position-relative mt-3"
                            type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        <label class="form-label fs-3 bi bi-person-circle"></label>
                        Account
                        <%
                            if (users != null) {
                        %>
                        <span
                                class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-success p-2"><span
                                class="visually-hidden">unread messages</span></span>
                        <%
                        } else {
                        %>
                        <span
                                class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-danger p-2"><span
                                class="visually-hidden">unread messages</span></span>
                        <%
                            }
                        %>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="userProfile">My Profile</a></li>
                        <li><a class="dropdown-item" href="wachlist">Watch List</a></li>
                        <li><a class="dropdown-item" href="cart">Cart</a></li>
                        <li><a class="dropdown-item" href="purchasehistory">Purchase History</a></li>
                        <li><a class="dropdown-item" href="#">Messages</a></li>
                        <li><a class="dropdown-item" href="#">Saved</a></li>
                    </ul>
                </div>

                <div class="col-1 col-lg-3 ms-5 ms-lg-0 mt-1 cart-icon"></div>

            </div>
        </div>

    </div>
</div>

<script src="bootstrap.bundle.js"></script>
<script src="script.js"></script>

</body>

</html>
