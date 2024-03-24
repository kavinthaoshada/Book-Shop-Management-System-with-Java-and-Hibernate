<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.calm.webdb.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.calm.webdb.entity.ProfileImageEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Infinity | Manage Users</title>

  <link rel="icon" href="assets/resources/infinity_logo2.svg" />
  <link rel="stylesheet" href="assets/css/bootstrap.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
  <link rel="stylesheet" href="assets/css/style.css" />
</head>
<body class="">
<div class="container-fluid">
  <div class="row">


    <div class="col-12 bg-light text-center">
      <h2 class="text-primary fw-bold">Manage All Users</h2>
    </div>

    <div class="col-12 mt-3">
      <div class="row">
        <div class="offset-0 offset-lg-3 col-12 col-lg-5 mb-3">
          <div class="row">
            <div class="col-9">
              <input type="text" class="form-control"/>
            </div>
            <div class="col-3 d-grid">
              <button class="btn btn-warning">Search User</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="col-12 mb-3 mb-3 ml-3 shadow" style="background-color: rgb(234, 238, 195);">
      <div class="row">


        <div class="col-2 bg-light py-2 d-none d-lg-block">
          <span class="fs-4 fw-bold">Profile Image</span>
        </div>
        <div class="col-4 col-lg-2 bg-primary py-2">
          <span class="fs-4 fw-bold text-white">User Name</span>
        </div>
        <div class="col-4 col-lg-2 bg-light py-2 d-lg-block">
          <span class="fs-4 fw-bold">Email</span>
        </div>
        <div class="col-2 bg-primary py-2 d-none d-lg-block">
          <span class="fs-4 fw-bold text-white">Mobile</span>
        </div>
        <div class="col-3 bg-light py-2 d-none d-lg-block">
          <span class="fs-4 fw-bold">Registered Date</span>
        </div>
        <div class="col-2 col-lg-1 bg-white"></div>

      </div>
    </div>
<%
  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  Session hibernateSession = sessionFactory.openSession();
  Transaction transaction = hibernateSession.beginTransaction();
  Query<UsersEntity> usersEntityQuery = hibernateSession.createQuery("SELECT u FROM UsersEntity u", UsersEntity.class);
  List<UsersEntity> users = usersEntityQuery.getResultList();
  for(UsersEntity user : users){
%>

    <div class="col-12 mb-3 ml-3 shadow" style="background-color: rgb(234, 238, 195);">
      <div class="row">

        <%
          Query<ProfileImageEntity> profileImageEntityQuery = hibernateSession.createQuery("SELECT p FROM ProfileImageEntity p " +
                  "WHERE p.usersEmail= :userEmail", ProfileImageEntity.class)
                  .setParameter("userEmail", user.getEmail());
          ProfileImageEntity profileImage = profileImageEntityQuery.uniqueResult();
          if(profileImage != null){
        %>
        <div class="col-2 bg-light py-2 d-none d-lg-block" onclick="viewmsgmodal();">
          <img src="<?php echo $uimg_data['path']; ?>" style="height: 40px; margin-left: 80px;"/>
        </div>
        <%
                }else{
        %>
        <div class="col-2 bg-light py-2 d-none d-lg-block" onclick="viewmsgmodal();">
          <img src="assets/resources/user_icon.svg" style="height: 40px; margin-left: 80px;"/>
        </div>
        <%
                }
        %>
        <!--
                    <div class="col-2 bg-light py-2 d-none d-lg-block" onclick="viewmsgmodal();">
                        <img src="resources/profile_images/62a214be47859.png" style="height: 40px; margin-left: 80px;"/>
                    </div> -->
        <div class="col-4 col-lg-2 bg-primary py-2">
          <span class="fs-4 fw-bold text-white"><%= user.getFname()+" "+user.getLname() %></span>
        </div>
        <div class="col-4 col-lg-2 bg-light py-2 d-lg-block">
          <span class="fs-6 fw-bold"><%= user.getEmail() %></span>
        </div>
        <div class="col-2 bg-primary py-2 d-none d-lg-block">
          <span class="fs-4 fw-bold text-white"><%= user.getMobile() %></span>
        </div>
        <div class="col-2 bg-light py-2 d-none d-lg-block">
          <span class="fs-6 fw-bold"><%= user.getJoinedDate() %></span>
        </div>
        <div class="col-3 col-lg-1 bg-white py-2 d-grid" style="border-radius: 0px 25px 25px 0px;">
          <!-- <button class="btn btn-danger" onclick="userBlock();">Block</button> -->
          <%
                    if(user.getStatus()==1){
          %>
          <button class="btn btn-danger" onclick="userBlock('<%= user.getEmail() %>');">Block</button>
          <%
                    }else if(user.getStatus()==0) {
          %>
          <button class="btn btn-warning" onclick="userBlock('<%= user.getEmail() %>');">Unblock</button>
          <%
                    }
          %>
        </div>

      </div>
    </div>

    <%
            }
            transaction.commit();
            hibernateSession.close();
    %>

    <div class="col-12 text-center">
      <div class="pagination">
        <a href="#">&laquo;</a>
        <a href="#">1</a>
        <a href="#" class="active">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">&raquo;</a>
      </div>
    </div>

    <!-- Modal -->
    <div class="modal" tabindex="-1" id="viewMsgModal">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <h5 class="modal-title">My Message</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>

          <div class="modal-body">

            <!-- receve -->
            <div class="col-12 mt-2">
              <div class="row">
                <div class="col-8 bg-success rounded">
                  <div class="row">
                    <div class="col-12 pt-2">
                      <span class="text-white fs-4">Hello there!!!</span>
                    </div>
                    <div class="col-12 text-end pb-2">
                      <span class="text-white fs-6">2022-06-11 | 08:00:00</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- receve -->

            <!-- Send -->
            <div class="col-12 mt-2">
              <div class="row">
                <div class="offset-4 col-8 bg-success rounded">
                  <div class="row">
                    <div class="col-12 pt-2">
                      <span class="text-white fs-4">How are you!!!</span>
                    </div>
                    <div class="col-12 text-end pb-2">
                      <span class="text-white fs-6">2022-06-11 | 08:05:00</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- send -->

          </div>

          <div class="modal-footer">
            <div class="col-12">
              <div class="row">

                <div class="col-0">
                  <input type="text" class="form-control"/>
                </div>
                <div class="col-4 d-grid">
                  <button class="btn btn-primary">Send</button>
                </div>

              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
    <!-- Modal -->

  </div>
</div>

<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>
