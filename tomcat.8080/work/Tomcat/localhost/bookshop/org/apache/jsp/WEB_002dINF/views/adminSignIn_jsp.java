/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-09-29 05:59:31 UTC
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

public final class adminSignIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
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

    session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
    List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
    if (employees == null) {


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("    <title>Infinity | Admins | Sign In</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" />\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"icon\" href=\"assets/resources/infinity_logo2.svg\" />\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-12 col-lg-6\">\r\n");
      out.write("        <!-- carousel -->\r\n");
      out.write("        <div id=\"carouselExampleCaptions\" class=\"col-12 carousel slide\" data-bs-ride=\"carousel\">\r\n");
      out.write("            <div class=\"carousel-indicators\">\r\n");
      out.write("                <a href=\"#\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></a>\r\n");
      out.write("                <a href=\"#\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></a>\r\n");
      out.write("                <a href=\"#\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"carousel-inner\">\r\n");
      out.write("                <div class=\"carousel-item active\">\r\n");
      out.write("                    <img src=\"assets/resources/carousel2/pauline-loroy-tv8PIPPY3rQ-unsplash.jpg\" class=\"d-block poster-img-1\" style=\"height: 100vh;\">\r\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block poster-caption\">\r\n");
      out.write("                        <h5 class=\"poster-title\">Welcome to Infinity Book Shop</h5>\r\n");
      out.write("                        <p class=\"poster-text\">The World's Best Book shop.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img src=\"assets/resources/carousel2/freddie-marriage-w8JiSVyjy-8-unsplash.jpg\" class=\"d-block poster-img-1\" style=\"height: 100vh;\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img src=\"assets/resources/carousel2/shiromani-kant-mo3FOTG62ao-unsplash.jpg\" class=\"d-block poster-img-1\" style=\"height: 100vh;\">\r\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block poster-caption-1\">\r\n");
      out.write("                        <h5 class=\"poster-title\">Be Free...</h5>\r\n");
      out.write("                        <p class=\"poster-text\">Experience the well shopping experience With Us.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"prev\">\r\n");
      out.write("                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"visually-hidden\">Previous</span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"next\">\r\n");
      out.write("                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"visually-hidden\">Next</span>\r\n");
      out.write("            </button> -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- carousel -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"col-12 col-lg-6\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-12 logo\"></div>\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <p class=\"text-center title01\">Hi, Welcome to Infinity Admins.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12 p-5\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <!--\r\n");
      out.write("                        <div class=\"col-6 d-done d-lg-block background\"></div> -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 col-lg-10 offset-lg-1 d-block\">\r\n");
      out.write("                    <div class=\"row g-3\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <p class=\"title02\">Sign In to your account.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <label class=\"form-label\">Email</label>\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"em\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12 col-lg-6 d-grid\">\r\n");
      out.write("                            <button class=\"btn btn-primary\" onclick=\"adminVerification();\">\r\n");
      out.write("                                Send Verification Code to login\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12 col-lg-6 d-grid\">\r\n");
      out.write("                            <button class=\"btn btn-danger\">Back to Customer login</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12 text-center d-none d-lg-block fixed-bottom\">\r\n");
      out.write("                            <p class=\"fw-bold text-black-50\">&copy; 2022 Infinity.lk All Rights Reserved.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- modal -->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"modal\" tabindex=\"-1\" id=\"verificationModal\">\r\n");
      out.write("                            <div class=\"modal-dialog\">\r\n");
      out.write("                                <div class=\"modal-content\">\r\n");
      out.write("                                    <div class=\"modal-header\">\r\n");
      out.write("                                        <h5 class=\"modal-title\">Admin Verification</h5>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"modal-body\">\r\n");
      out.write("                                        <label class=\"form-label\">Enter the Verification code you got by an email</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"vcode\"/>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"modal-footer\">\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"verify();\">Verify</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- modal -->\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--  -->\r\n");
      out.write("<!--  -->\r\n");
      out.write("<!--  -->\r\n");
      out.write("\r\n");
      out.write("<!-- <div class=\"container-fluid justify-content-center\" style=\"margin-top: 100px;\">\r\n");
      out.write("<div class=\"row align-content-center\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/script.js\"></script>\r\n");
      out.write("<script src=\"assets/js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

}else{

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    fetch(\"adminPanel\", {\r\n");
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
