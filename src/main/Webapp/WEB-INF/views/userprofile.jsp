<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>



<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Infinity | User Profile</title>

    <link rel="icon" href="assets/resources/logo.svg" />
    <link rel="stylesheet" href="assets/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/style.css" />

</head>
<body class="bg-primary" style="background-image: linear-gradient(rgb(255, 255, 255), rgb(255, 177, 229));">

<div class="container-fluid">
    <div class="row">

        <jsp:include page="header.jsp"/>
        <%
        List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
                if (users != null) {
                String user_email;
                for (UsersEntity user : users) {
                    user_email =user.getEmail();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();
        Query<UsersEntity> query = session1.createQuery("FROM UsersEntity u " +
                        "INNER JOIN u.genderByGenderId g WHERE u.email = :email", UsersEntity.class)
                .setParameter("email", user_email);
        List<UsersEntity> genderUPs = query.getResultList();

        Query<ProfileImageEntity> query1 = session1.createQuery("FROM ProfileImageEntity pi " +
                        "WHERE pi.usersEmail = :email", ProfileImageEntity.class)
                 .setParameter("email", user_email);
        List<ProfileImageEntity> upImages = query1.getResultList();

        Query<UserHasAddressEntity> query2 = session1.createQuery("FROM UserHasAddressEntity uha " +
          "INNER JOIN uha.cityByCityId c " +
          "INNER JOIN c.DistrictByDistrictId d " +
          "INNER JOIN d.ProvinceByProvinceId p " +
          "WHERE uha.usersEmail = :email", UserHasAddressEntity.class)
                 .setParameter("email", user_email);
        List<UserHasAddressEntity> upAddresses = query2.getResultList();

        transaction.commit();
        session1.close();
        for(UsersEntity genderUP : genderUPs ) {
        %>

        <div class="col-12 bg-body rounded mt-4 mb-4">
            <div class="row g-2">

                <div class="col-md-3 border-end">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <%
                            String path = null;
                            for(ProfileImageEntity upImage : upImages){
                                path = upImage.getPath();
                            }
                            if(path == null){
                        %>

                        <img id="viewimg" src="assets/resources/user_icon.svg" class="rounded mt-5" style="width: 150px;" />
                        <%
                        }else{
                        %>
                        <img id="viewimg" src="<%= path %>" class="rounded mt-5" style="width: 150px;" />
                        <%
                        }
                        %>

                        <span class="fw-bold"><%= genderUP.getFname()+" "+genderUP.getLname() %></span>
                        <span class="text-black-50"><%= genderUP.getEmail() %></span>

                        <input class="d-none" type="file" accept="img" id="profileimg" />
                        <label class="btn btn-primary mt-5" for="profileimg" onclick="changeImage();">Update Profile Image</label>

                    </div>
                </div>

                <div class="col-md-5 border-end">
                    <div class="p-3 py-5"></div>

                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="fw-bold">Profile Setting</h4>
                    </div>

                    <div class="row mt-3">

                        <div class="col-md-6">
                            <label class="form-label">First Name</label>
                            <input type="text" id="fn" class="form-control" value="<%= genderUP.getFname() %>"/>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Last Name</label>
                            <input type="text" id="ln" class="form-control" value="<%= genderUP.getLname() %>"/>
                        </div>

                        <div class="col-md-12">
                            <label class="form-label">Mobile</label>
                            <input type="text" id="mo" class="form-control" value="<%= genderUP.getMobile() %>"/>
                        </div>

                        <div class="col-md-12">
                            <label class="form-label">Password</label>
                            <div class="input-group mb-3">
                                <input type="password" class="form-control" aria-describedby="viewpassword" id="pwtxt" value="<%= genderUP.getPassword() %>" disabled>
                                <button class="btn btn-outline-primary" id="viewpassword" onclick="viewpw();"><i class="bi bi-eye-fill"></i></button>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" value="<%= genderUP.getEmail() %>" readonly />
                        </div>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Registered Date</label>
                            <input type="text" class="form-control" value="<%= genderUP.getJoinedDate() %>" readonly/>
                        </div>
                        <%
                            String line1 = null;
                            String line2 = null;
                            String postalCode = null;
                            for(UserHasAddressEntity upAddress : upAddresses){
                                line1 = upAddress.getLine1();
                                line2 = upAddress.getLine2();
                                postalCode = upAddress.getPostalCode();
                            }
                            if(line1 != null){
                        %>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Address Line 01</label>
                            <input type="text" id="l11" class="form-control" value="<%= line1 %>>" readonly/>
                        </div>

                        <%
                        }else{
                        %>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Address Line 01</label>
                            <input type="text" id="l1" class="form-control" value="" placeholder="Address line 01"/>
                        </div>

                        <%
                        }
                        %>

                        <%
                            if(line2 != null){
                        %>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Address Line 02</label>
                            <input type="text" id="l22" class="form-control" value="<%= line2 %>" readonly/>
                        </div>

                        <%
                           }else{
                        %>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Address Line 02</label>
                            <input type="text" id="l2" class="form-control" value="" placeholder="Address line 02"/>
                        </div>

                       <%
                           }
                       %>
                        <%
                            SessionFactory sessionFactory2 = HibernateUtil.getSessionFactory();
                            Session session2 = sessionFactory2.openSession();
                            Transaction transaction2 = session2.beginTransaction();

                            Query<CityEntity> c = session2.createQuery("FROM CityEntity", CityEntity.class);
                            List<CityEntity> cities = c.getResultList();
                            Query<DistrictEntity> d = session2.createQuery("FROM DistrictEntity", DistrictEntity.class);
                            List<DistrictEntity> districts = d.getResultList();
                            Query<ProvinceEntity> p = session2.createQuery("FROM ProvinceEntity", ProvinceEntity.class);
                            List<ProvinceEntity> provinces = p.getResultList();

                            transaction2.commit();
                            session2.close();

                        %>
                        <div class="col-md-6 mt-1">
                            <label class="form-label">Province</label>
                            <select id="pr" class="form-select">
                                <option value="0">Select Province</option>
                                <%
                                    for(ProvinceEntity province : provinces){
                                %>

                                <option value="<%= province.getId() %>"
                                <%
                                    for(UserHasAddressEntity upAddress : upAddresses){
                                    if(upAddress.getCityByCityId().getDistrictByDistrictId().getProvinceId()==province.getId()) {
                                %>
                                selected
                                <%
                                    }}
                                %>><%= province.getName()%></option>

                                <%
                                    }
                                %>


                            </select>
                        </div>

                        <div class="col-md-6 mt-1">
                            <label class="form-label">District</label>
                            <select class="form-select">
                                <option id="dr" value="0">Select District</option>
                                <%
                                    for(DistrictEntity district : districts){
                                %>

                                <option value="<%= district.getId() %>"
                                        <%
                                            for(UserHasAddressEntity upAddress : upAddresses){
                                            if(upAddress.getCityByCityId().getDistrictId()==district.getId()){
                                        %>
                                        selected
                                        <%
                                            }}
                                        %>><%= district.getName()%></option>

                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="col-md-6 mt-1">
                            <label class="form-label">City</label>
                            <select id="ci" class="form-select">
                                <option value="0">Select City</option>
                                <%
                                    for(CityEntity city : cities){
                                %>

                                <option value="<%= city.getId() %>"
                                        <%
                                            for(UserHasAddressEntity upAddress : upAddresses){
                                            if(upAddress.getCityId()==city.getId()){
                                        %>
                                        selected
                                        <%
                                            }}
                                        %>><%= city.getName()%></option>

                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="col-md-6 mt-1">
                            <label class="form-label">Postal Code</label>

                            <%
                                if(postalCode != null){
                            %>
                            <input type="text" id="pc" class="form-control" value="<%= postalCode %>"/>
                            <%
                                }else{
                            %>
                            <input type="text" id="pc" class="form-control" placeholder="Postel Code"/>
                            <%
                                }
                            %>

                        </div>

                        <div class="col-md-12 mt-1">
                            <label class="form-label">Gender</label>
                            <input type="text" class="form-control" value="<%= genderUP.getGenderByGenderId().getName() %>" readonly/>
                        </div>

                        <div class="col-md-12 d-grid mt-3 mb-3">
                            <button class="btn btn-primary" onclick="update_profile();">Update My Profile</button>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <%
        }
        %>
        <jsp:include page="footer.jsp"/>

    </div>
</div>


<script src="assets/script.js"></script>
</body>
</html>

<%
     }

   }else {
 %>

<script>
    // window.location = "";
    fetch("", {
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
