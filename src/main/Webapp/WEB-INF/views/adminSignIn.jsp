<%@ page import="com.calm.webdb.entity.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
    List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
    if (employees == null) {

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Infinity | Admins | Sign In</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" />

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />

    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>
<div class="row">
    <div class="col-12 col-lg-6">
        <!-- carousel -->
        <div id="carouselExampleCaptions" class="col-12 carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <a href="#" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></a>
                <a href="#" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></a>
                <a href="#" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></a>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="assets/resources/carousel2/pauline-loroy-tv8PIPPY3rQ-unsplash.jpg" class="d-block poster-img-1" style="height: 100vh;">
                    <div class="carousel-caption d-none d-md-block poster-caption">
                        <h5 class="poster-title">Welcome to Infinity Book Shop</h5>
                        <p class="poster-text">The World's Best Book shop.</p>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="assets/resources/carousel2/freddie-marriage-w8JiSVyjy-8-unsplash.jpg" class="d-block poster-img-1" style="height: 100vh;">
                </div>
                <div class="carousel-item">
                    <img src="assets/resources/carousel2/shiromani-kant-mo3FOTG62ao-unsplash.jpg" class="d-block poster-img-1" style="height: 100vh;">
                    <div class="carousel-caption d-none d-md-block poster-caption-1">
                        <h5 class="poster-title">Be Free...</h5>
                        <p class="poster-text">Experience the well shopping experience With Us.</p>
                    </div>
                </div>
            </div>
            <!-- <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button> -->
        </div>
        <!-- carousel -->

    </div>

    <div class="col-12 col-lg-6">

        <div class="col-12">
            <div class="row">
                <div class="col-12 logo"></div>
                <div class="col-12">
                    <p class="text-center title01">Hi, Welcome to Infinity Admins.</p>
                </div>
            </div>
        </div>

        <div class="col-12 p-5">
            <div class="row">
                <!--
                        <div class="col-6 d-done d-lg-block background"></div> -->

                <div class="col-12 col-lg-10 offset-lg-1 d-block">
                    <div class="row g-3">

                        <div class="col-12">
                            <p class="title02">Sign In to your account.</p>
                        </div>

                        <div class="col-12">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" id="em"/>
                        </div>

                        <div class="col-12 col-lg-6 d-grid">
                            <button class="btn btn-primary" onclick="adminVerification();">
                                Send Verification Code to login
                            </button>
                        </div>

                        <div class="col-12 col-lg-6 d-grid">
                            <button class="btn btn-danger">Back to Customer login</button>
                        </div>

                        <div class="col-12 text-center d-none d-lg-block fixed-bottom">
                            <p class="fw-bold text-black-50">&copy; 2022 Infinity.lk All Rights Reserved.</p>
                        </div>

                        <!-- modal -->

                        <div class="modal" tabindex="-1" id="verificationModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Admin Verification</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <label class="form-label">Enter the Verification code you got by an email</label>
                                        <input type="text" class="form-control" id="vcode"/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" onclick="verify();">Verify</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- modal -->

                    </div>
                </div>

            </div>
        </div>

    </div>

</div>
</div>
</div>
<!--  -->
<!--  -->
<!--  -->

<!-- <div class="container-fluid justify-content-center" style="margin-top: 100px;">
<div class="row align-content-center">



</div>
</div> -->


<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>
<%
}else{
%>
<script>
    fetch("adminPanel", {
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