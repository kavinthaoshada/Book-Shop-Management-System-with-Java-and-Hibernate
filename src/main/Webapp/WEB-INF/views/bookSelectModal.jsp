<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.calm.webdb.util.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.calm.webdb.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--book select modal -->

<div class="modal" tabindex="-1" id="testModal">
    <div class="modal-dialog" >
        <div class="modal-content" style="width: 900px;">
            <div class="modal-header">
                <h5 class="modal-title">Select Book</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <!--  -->
                <div class="col-12 justify-content-center">
                    <div class="row mb-3">

                        <div class="col-4 col-lg-1 offset-4 offset-lg-1 logo-img"></div>

                        <div class="col-8 col-lg-6">
                            <div class="input-group input-group-lg mt-3 mb-3">
                                <input type="text" class="form-control" aria-label="Text input with dropdown button" id="basic_search_txt" />

                                <select class="btn btn-outline-primary" id="basic_search_select">
                                    <option value="0" readonly>Select Category</option>
                                    <%
                                        // Assuming Database is a Java class with a search method
                                        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                        Session session1 = sessionFactory.openSession();
                                        Transaction transaction = session1.beginTransaction();

                                        // Assuming entity class
                                        List<CategoryEntity> categories = session1.createQuery("FROM CategoryEntity", CategoryEntity.class).list();

                                        transaction.commit();
                                        session1.close();
                                        for (CategoryEntity category : categories) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                                    %>

                                    <option value="<%= category.getId()%>"><%= category.getName()%></option>

                                    <%
                                        }
                                    %>
                                </select>

                            </div>
                        </div>

                        <div class="col-2 d-grid gap-2">
                            <button class="btn btn-primary mt-3 search-btn" onclick="basicSearch(0);">Search</button>
                        </div>

                    </div>
                </div>
                <!--  -->
                <div class="col-12" id="basicSearchResult"></div>


            </div>



            <div class="modal-footer">

                <div class="col-12 d-grid">
                    <div class="row">
                        <div class="col-6">
                            <!-- <button class="btn btn-primary col-12" onclick="vendorRegister();">Register</button> -->
                        </div>
                    </div>


                </div>


            </div>
        </div>
    </div>
</div>
</div>

<!-- book select modal-->
