/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-19 05:45:30 UTC
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
import com.calm.webdb.util.CookieHelper;
import java.io.PrintWriter;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.calm.webdb.util.CookieHelper");
    _jspx_imports_classes.add("com.calm.webdb.entity.GenderEntity");
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- modal 1 -->\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"signInModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Sign In</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <p class=\"title02\">Sign In to your Account</p>\r\n");
      out.write("                    <span class=\"text-danger\" id=\"msg2\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Email</label>\r\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email2\" value=\"");
      out.print( (CookieHelper.getCookie(request, "email") != null) ? CookieHelper.getCookie(request, "email").getValue() : "" );
      out.write("\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Password</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password2\" value=\"");
      out.print( (CookieHelper.getCookie(request, "password") != null) ? CookieHelper.getCookie(request, "password").getValue() : "" );
      out.write("\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-6\">\r\n");
      out.write("                    <div class=\"form-check\">\r\n");
      out.write("                        <input class=\"form-check-input\" type=\"checkbox\" value=\"1\" id=\"rememberMe\">\r\n");
      out.write("                        <label class=\"form-check-label\">Remember Me</label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-6\">\r\n");
      out.write("                    <a href=\"#\" class=\"link-primary\" onclick=\"fogotPassword();\">Forgot Password</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <div class=\"col-12 d-grid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <button class=\"btn btn-primary col-12\" onclick=\"signIn();\">Sign In</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <button class=\"btn btn-danger col-12\" onclick=\"signUpModal();\">New to eShop? Join Now</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- modal 1-->\r\n");
      out.write("\r\n");
      out.write("<!-- modal 2 -->\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"signUpModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Sign Up</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <p class=\"title02\">Create New Account</p>\r\n");
      out.write("                    <span class=\"text-danger\" id=\"msg\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">First Name</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"fname\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Last Name</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"lname\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Email</label>\r\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label\">Password</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" />\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Mobile</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"mobile\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Gender</label>\r\n");
      out.write("                        <select class=\"form-select\" id=\"gender\">\r\n");
      out.write("                            ");

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
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                   <option value=\"");
      out.print( gender.getId());
      out.write('"');
      out.write('>');
      out.print( gender.getName());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("                                ");

                                }
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <div class=\"col-12 d-grid\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <button class=\"btn btn-primary col-12\" onclick=\"signUp();\">Sign Up</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <button class=\"btn btn-dark col-12\" onclick=\"signInModal();\">Already have an Account? Sign In</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- modal 2-->\r\n");
      out.write("\r\n");
      out.write("<!-- forgot password modal -->\r\n");
      out.write("<div class=\"modal\" tabindex=\"-1\" id=\"fogotPasswordModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">Reset Password</h5>\r\n");
      out.write("                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <div class=\"row g-3\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">New password</label>\r\n");
      out.write("                        <div class=\"input-group mb-3\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"np\" />\r\n");
      out.write("                            <button class=\"btn btn-secondary\" type=\"button\" id=\"npb\" onclick=\"showpassword1();\">\r\n");
      out.write("                                <i class=\"bi bi-eye-slash-fill\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <label class=\"form-label\">Re-type password</label>\r\n");
      out.write("                        <div class=\"input-group mb-3\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"rnp\" />\r\n");
      out.write("                            <button class=\"btn btn-secondary\" type=\"button\" id=\"rnpb\" onclick=\"showpassword2();\">\r\n");
      out.write("                                <i class=\"bi bi-eye-slash-fill\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-12\">\r\n");
      out.write("                        <label class=\"form-label\">Verification code</label>\r\n");
      out.write("                        <div class=\"input-group mb-3\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"vc\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" onclick=\"resetpassword();\">Reset Password</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- forgot password modal -->\r\n");
      out.write("\r\n");
      out.write("<footer class=\"shadow-lg text-black-50 pb-5 pt-4 bg-white\">\r\n");
      out.write("    <div class=\"col-12 text-center\">\r\n");
      out.write("        <a href=\"#\" style=\"text-decoration: none;\" class=\"text-black-50\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"text-decoration: none;\" class=\"text-black-50\">Features</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"text-decoration: none;\" class=\"text-black-50\">Pricing</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"text-decoration: none;\" class=\"text-black-50\">FAQs</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"text-decoration: none;\" class=\"text-black-50\">About</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <hr class=\"col-8 offset-2\" />\r\n");
      out.write("\r\n");
      out.write("    <div class=\"col-12 text-center\">\r\n");
      out.write("        <p>&copy; 2022 Infinity Book Shop(Pvt) Ltd, Inc</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/bootstrap.bundle.js\"></script>\r\n");
      out.write("<script src=\"assets/js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
