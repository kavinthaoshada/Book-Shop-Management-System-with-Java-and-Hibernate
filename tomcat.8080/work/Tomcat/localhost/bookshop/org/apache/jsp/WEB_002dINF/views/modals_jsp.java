/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-29 04:58:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import org.hibernate.SessionFactory;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.calm.webdb.entity.GenderEntity;
import java.util.List;
import com.calm.webdb.entity.EmployeeTypeEntity;

public final class modals_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.calm.webdb.entity.GenderEntity");
    _jspx_imports_classes.add("org.hibernate.SessionFactory");
    _jspx_imports_classes.add("com.calm.webdb.util.HibernateUtil");
    _jspx_imports_classes.add("org.hibernate.Session");
    _jspx_imports_classes.add("com.calm.webdb.entity.EmployeeTypeEntity");
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
      out.write("<!--vendor registration modal -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"vendorModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Vendor Registration</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <p class=\"title02\">Vendor Registration</p>\r\n");
      out.write("                    <span class=\"text-danger\" id=\"msg2\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Name</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"r_name\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Mobile Number</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"mno\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Publication</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"pub\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 d-grid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <button class=\"btn btn-primary col-12\" onclick=\"vendorRegister();\">Register</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- vendor registration modal-->\r\n");
      out.write("\r\n");
      out.write("<!-- emp reg modal 2 -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"empreg\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Employee Registration</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <p class=\"title02\">Register New Employee</p>\r\n");
      out.write("                    <span class=\"text-danger\" id=\"msg\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">First Name</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"fname\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Last Name</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"lname\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Username</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"uname\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Email</label>\r\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Password</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Mobile</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"mobile\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Gender</label>\r\n");
      out.write("                        <select class=\"form-select\" id=\"gender\">\r\n");
      out.write("\r\n");
      out.write("                            ");

                                // Assuming Database is a Java class with a search method
                                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                                Session session1 = sessionFactory.openSession();
                                Transaction transaction = session1.beginTransaction();

                                // Assuming your entity class is "Gender" and you have a Gender class mapped in Hibernate
                                List<GenderEntity> genders = session1.createQuery("FROM GenderEntity", GenderEntity.class).list();


                                StringBuilder options = new StringBuilder();

                                for (GenderEntity gender : genders) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print( gender.getId());
      out.write('"');
      out.write('>');
      out.print( gender.getName());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Employee Type</label>\r\n");
      out.write("                    <select class=\"form-select\" id=\"emp_type\">\r\n");
      out.write("\r\n");
      out.write("                        ");

                            List<EmployeeTypeEntity> empTypes = session1.createQuery("FROM EmployeeTypeEntity", EmployeeTypeEntity.class).list();

                            transaction.commit();
                            session1.close();

                            for (EmployeeTypeEntity empType : empTypes) {
//                                    System.out.println(gender.getId()+" : "+gender.getName());
                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( empType.getId());
      out.write('"');
      out.write('>');
      out.print( empType.getName());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 d-grid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <button class=\"btn btn-primary col-12\" onclick=\"empReg();\">Register</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- emp reg modal 2-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
