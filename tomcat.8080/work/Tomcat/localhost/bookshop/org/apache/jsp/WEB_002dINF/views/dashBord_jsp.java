/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-29 04:09:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.calm.webdb.entity.EmployeeEntity;
import java.util.List;
import org.hibernate.SessionFactory;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.calm.webdb.entity.UsersEntity;
import org.hibernate.query.Query;
import com.calm.webdb.entity.EmpProfileImageEntity;

public final class dashBord_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.hibernate.Transaction");
    _jspx_imports_classes.add("com.calm.webdb.entity.EmpProfileImageEntity");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.calm.webdb.entity.UsersEntity");
    _jspx_imports_classes.add("org.hibernate.SessionFactory");
    _jspx_imports_classes.add("org.hibernate.query.Query");
    _jspx_imports_classes.add("com.calm.webdb.util.HibernateUtil");
    _jspx_imports_classes.add("org.hibernate.Session");
    _jspx_imports_classes.add("com.calm.webdb.entity.EmployeeEntity");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

        session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
        List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
        if (employees != null) {
            for (EmployeeEntity employee : employees) {

                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session1 = sessionFactory.openSession();
                Transaction transaction = session1.beginTransaction();


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"col-12 col-lg-2 shadow mx-3 my-3\" style=\"background-color: rgb(241, 214, 214);\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"align-items-start col-12\">\r\n");
      out.write("            <div class=\"row g-1 text-center\">\r\n");
      out.write("\r\n");
      out.write("                ");


                    Query<EmpProfileImageEntity> query = session1.createQuery("SELECT e FROM EmpProfileImageEntity e WHERE e.employeeEmpEmail = :email", EmpProfileImageEntity.class)
                            .setParameter("email", employee.getEmpEmail());
                    List<EmpProfileImageEntity> empProfileImages = query.getResultList();
                    transaction.commit();
                    session1.close();
                    boolean existEmpProfileImage = false;
                    String imgPath = null;
                    for (EmpProfileImageEntity empProfileImage : empProfileImages) {
                            existEmpProfileImage = true;
                            imgPath = empProfileImage.getPath();
                    }
                    if(existEmpProfileImage){
                
      out.write("\r\n");
      out.write("                <div class=\"col-4 py-2 d-none d-lg-block rounded\" style=\"background-color: rgb(241, 214, 214);\">\r\n");
      out.write("                    <img src=\"");
      out.print( imgPath );
      out.write("\" style=\"height: 40px; margin-left: 80px;\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    }else{
                
      out.write("\r\n");
      out.write("                <div class=\"col-4 bg-light py-2 d-none d-lg-block bg-dark\">\r\n");
      out.write("                    <img src=\"assets/resources/user_icon.svg\" style=\"height: 40px; margin-left: 80px;\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 mt-5\">\r\n");
      out.write("                    <h4 class=\"text-black\">");
      out.print( employee.getFname()+" "+employee.getLname() );
      out.write("</h4>\r\n");
      out.write("                    <hr class=\"border border-1 border-white\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"nav flex-column nav-pills me-3 mt-3\">\r\n");
      out.write("                    <div class=\"nav flex-column text-black-50 text-lg-start\">\r\n");
      out.write("                        <a class=\"nav-link fs-5 active\" href=\"adminPanel\">Dashbord</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"grn\">GRN</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\" \">Invoice</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"stock.php\">Manage Stock</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"addproduct\">Add Book</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"manageusers.php\">Manage Users</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"manageProducts.php\">Manage Categories</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"#\" onclick=\"empRegModal();\">Employee Registration</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"viewEmployee.php\">View Employee</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"#\" onclick=\"vendorModal();\">Vendors Registration</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"vendorUpdate.php\">View Vendors</a>\r\n");
      out.write("                        <a class=\"nav-link fs-5 text-black-50\" href=\"sellingHistory.php\">Selling History</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 mt-3\">\r\n");
      out.write("                    <hr class=\"border border-1 border-white\"/>\r\n");
      out.write("                    <h4 class=\"text-white\">Selling History</h4>\r\n");
      out.write("                    <hr class=\"border border-1 border-white\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 mt-3 d-grid\">\r\n");
      out.write("                    <h5 class=\"text-white fw-bold\">From Date</h5>\r\n");
      out.write("                    <input type=\"date\" class=\"form-control\" />\r\n");
      out.write("                    <h5 class=\"text-white fw-bold\">To Date</h5>\r\n");
      out.write("                    <input type=\"date\" class=\"form-control\" />\r\n");
      out.write("                    <a class=\"btn btn-primary fw-bold mt-2\" href=\"#\">View Selling</a>\r\n");
      out.write("                    <hr class=\"border border-1 border-white\"/>\r\n");
      out.write("                    <hr class=\"border border-1 border-white\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

    }
}else{

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    alert(\"Please Sign In First\");\r\n");
      out.write("    fetch(\"adminSignIn\", {\r\n");
      out.write("        method: \"GET\"\r\n");
      out.write("    }).then(response => response.text())\r\n");
      out.write("        .then(data => {\r\n");
      out.write("            document.open();\r\n");
      out.write("            document.write(data);\r\n");
      out.write("            document.close();\r\n");
      out.write("        });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

    }

      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
