<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.GenderEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.util.CookieHelper" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>

<body>

<!-- modal 1 -->
<div class="modal" tabindex="-1" id="signInModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Sign In</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <div class="col-12">
                    <p class="title02">Sign In to your Account</p>
                    <span class="text-danger" id="msg2"></span>
                </div>

                <div class="col-12">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" id="email2" value="<%= (CookieHelper.getCookie(request, "email") != null) ? CookieHelper.getCookie(request, "email").getValue() : "" %>"/>
                </div>
                <div class="col-12">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" id="password2" value="<%= (CookieHelper.getCookie(request, "password") != null) ? CookieHelper.getCookie(request, "password").getValue() : "" %>"/>
                </div>

                <div class="col-6">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="1" id="rememberMe">
                        <label class="form-check-label">Remember Me</label>
                    </div>
                </div>

                <div class="col-6">
                    <a href="#" class="link-primary" onclick="fogotPassword();">Forgot Password</a>
                </div>
            </div>

            <div class="modal-footer">
                <div class="col-12 d-grid">
                    <div class="row">
                        <div class="col-6">
                            <button class="btn btn-primary col-12" onclick="signIn();">Sign In</button>
                        </div>
                        <div class="col-6">
                            <button class="btn btn-danger col-12" onclick="signUpModal();">New to eShop? Join Now</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- modal 1-->

<!-- modal 2 -->
<div class="modal" tabindex="-1" id="signUpModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Sign Up</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <div class="col-12">
                    <p class="title02">Create New Account</p>
                    <span class="text-danger" id="msg"></span>
                </div>

                <div class="row">
                    <div class="col-6">
                        <label class="form-label">First Name</label>
                        <input type="text" class="form-control" id="fname" />
                    </div>
                    <div class="col-6">
                        <label class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lname" />
                    </div>
                </div>

                <div class="col-12">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" />
                </div>
                <div class="col-12">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" />
                </div>

                <div class="row">
                    <div class="col-6">
                        <label class="form-label">Mobile</label>
                        <input type="text" class="form-control" id="mobile" />
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

                                transaction.commit();
                                session1.close();
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

            </div>

            <div class="modal-footer">
                <div class="col-12 d-grid">
                    <div class="row">
                        <div class="col-6">
                            <button class="btn btn-primary col-12" onclick="signUp();">Sign Up</button>
                        </div>
                        <div class="col-6">
                            <button class="btn btn-dark col-12" onclick="signInModal();">Already have an Account? Sign In</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- modal 2-->

<!-- forgot password modal -->
<div class="modal" tabindex="-1" id="fogotPasswordModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Reset Password</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row g-3">
                    <div class="col-6">
                        <label class="form-label">New password</label>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" id="np" />
                            <button class="btn btn-secondary" type="button" id="npb" onclick="showpassword1();">
                                <i class="bi bi-eye-slash-fill"></i>
                            </button>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="form-label">Re-type password</label>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" id="rnp" />
                            <button class="btn btn-secondary" type="button" id="rnpb" onclick="showpassword2();">
                                <i class="bi bi-eye-slash-fill"></i>
                            </button>
                        </div>
                    </div>
                    <div class="col-12">
                        <label class="form-label">Verification code</label>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="vc" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="resetpassword();">Reset Password</button>
            </div>
        </div>
    </div>
</div>
<!-- forgot password modal -->

<footer class="shadow-lg text-black-50 pb-5 pt-4 bg-white">
    <div class="col-12 text-center">
        <a href="#" style="text-decoration: none;" class="text-black-50">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="text-decoration: none;" class="text-black-50">Features</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="text-decoration: none;" class="text-black-50">Pricing</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="text-decoration: none;" class="text-black-50">FAQs</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="text-decoration: none;" class="text-black-50">About</a>
    </div>
    <hr class="col-8 offset-2" />

    <div class="col-12 text-center">
        <p>&copy; 2022 Infinity Book Shop(Pvt) Ltd, Inc</p>
    </div>
</footer>

<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/script.js"></script>

</body>

</html>

