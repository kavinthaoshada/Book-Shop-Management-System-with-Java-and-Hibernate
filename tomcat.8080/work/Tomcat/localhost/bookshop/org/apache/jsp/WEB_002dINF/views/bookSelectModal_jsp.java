/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-29 08:20:24 UTC
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
import com.calm.webdb.entity.CategoryEntity;
import java.util.List;

public final class bookSelectModal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.calm.webdb.entity.CategoryEntity");
    _jspx_imports_classes.add("org.hibernate.SessionFactory");
    _jspx_imports_classes.add("com.calm.webdb.util.HibernateUtil");
    _jspx_imports_classes.add("org.hibernate.Session");
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
      out.write("<!--book select modal -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"testModal\">\r\n");
      out.write("    <div class=\"modal-dialog\" >\r\n");
      out.write("        <div class=\"modal-content\" style=\"width: 900px;\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Select Book</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                <!--  -->\r\n");
      out.write("                <div class=\"col-12 justify-content-center\">\r\n");
      out.write("                    <div class=\"row mb-3\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-4 col-lg-1 offset-4 offset-lg-1 logo-img\"></div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-8 col-lg-6\">\r\n");
      out.write("                            <div class=\"input-group input-group-lg mt-3 mb-3\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" aria-label=\"Text input with dropdown button\" id=\"basic_search_txt\" />\r\n");
      out.write("\r\n");
      out.write("                                <select class=\"btn btn-outline-primary\" id=\"basic_search_select\">\r\n");
      out.write("                                    <option value=\"0\" readonly>Select Category</option>\r\n");
      out.write("                                    ");

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
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <option value=\"");
      out.print( category.getId());
      out.write('"');
      out.write('>');
      out.print( category.getName());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-2 d-grid gap-2\">\r\n");
      out.write("                            <button class=\"btn btn-primary mt-3 search-btn\" onclick=\"basicSearch(0);\">Search</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--  -->\r\n");
      out.write("                <div class=\"col-12\" id=\"basicSearchResult\"></div>\r\n");
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
      out.write("                            <!-- <button class=\"btn btn-primary col-12\" onclick=\"vendorRegister();\">Register</button> -->\r\n");
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
      out.write("<!-- book select modal-->\r\n");
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
