/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-10-12 19:03:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.calm.webdb.entity.UsersEntity;
import java.util.List;
import org.hibernate.SessionFactory;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.calm.webdb.entity.WatchlistEntity;
import com.calm.webdb.entity.StockEntity;
import com.calm.webdb.entity.ImagesEntity;

public final class wachlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.calm.webdb.entity.UsersEntity");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("org.hibernate.SessionFactory");
    _jspx_imports_classes.add("org.hibernate.query.Query");
    _jspx_imports_classes.add("com.calm.webdb.entity.StockEntity");
    _jspx_imports_classes.add("com.calm.webdb.util.HibernateUtil");
    _jspx_imports_classes.add("org.hibernate.Session");
    _jspx_imports_classes.add("com.calm.webdb.entity.WatchlistEntity");
    _jspx_imports_classes.add("com.calm.webdb.entity.ImagesEntity");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Infinity | Wachlist</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"icon\" href=\"assets/resources/infinity_logo2.svg\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("   ");

        session.setMaxInactiveInterval(1800); // Set session timeout to 30 minutes
        List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
        if (users != null) {
        for (UsersEntity user : users) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session1 = sessionFactory.openSession();
            Transaction transaction = session1.beginTransaction();

   
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-12 border border-1 border-secondary rounded\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <label class=\"form-label fs-1 fw-bolder\">wachlist &hearts;</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-12 col-lg-6\">\r\n");
      out.write("                            <hr class=\"hr-break-1\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"offset-lg-2 col-12 col-lg-6 mb-3\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Search In Wachlist...\" id=\"txt\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-12 col-lg-2 mb-3 d-grid\">\r\n");
      out.write("                                    <button class=\"btn btn-outline-primary\" onclick=\"basicSearchWatchlist(0,'");
      out.print( user.getEmail() );
      out.write("')\">Search</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <hr class=\"hr-break-1\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-11 col-lg-2 border-0 border-end border-1 border-primary\">\r\n");
      out.write("\r\n");
      out.write("                            <nav aria-label=\"breadcrumb\">\r\n");
      out.write("                                <ol class=\"breadcrumb\">\r\n");
      out.write("                                    <li class=\"breadcrumb-item\"><a href=\"#\" onclick=\"home();\">Home</a></li>\r\n");
      out.write("                                    <li class=\"breadcrumb-item active\" aria-current=\"page\">wachlist</li>\r\n");
      out.write("                                </ol>\r\n");
      out.write("                            </nav>\r\n");
      out.write("                            <nav class=\"nav nav-pills flex-column\">\r\n");
      out.write("                                <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">My Wachlist</a>\r\n");
      out.write("                                <a class=\"nav-link\" href=\"cart\">My Cart</a>\r\n");
      out.write("                                <a class=\"nav-link\" href=\"#\">Recents</a>\r\n");
      out.write("                            </nav>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        ");

                            Query<WatchlistEntity> query = session1.createQuery("SELECT w FROM WatchlistEntity w " +
                                    "WHERE w.usersEmail= :usersEmail", WatchlistEntity.class)
                                    .setParameter("usersEmail", user.getEmail());
                            List<WatchlistEntity> watchlistItems = query.getResultList();


                        if(watchlistItems.isEmpty()){

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- no item -->\r\n");
      out.write("                        <div class=\"col-12 col-lg-9\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-12 emptyView\"></div>\r\n");
      out.write("                                <div class=\"col-12 text-center\">\r\n");
      out.write("                                    <label class=\"form-label fs-1 fw-bold\">\r\n");
      out.write("                                        You have no Item in your watchlist yet.\r\n");
      out.write("                                    </label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"offset-lg-4 col-12 col-lg-4 d-grid mb-3\">\r\n");
      out.write("                                    <a href=\"home\" class=\"btn btn-warning fs-3 fw-bold\" onclick=\"home();\">\r\n");
      out.write("                                        Start Shopping\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- no item -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ");

                         }else{
                        
      out.write("\r\n");
      out.write("                        <!-- have products -->\r\n");
      out.write("                        <div class=\"col-12 col-lg-9\" id=\"resultPage\">\r\n");
      out.write("                            <div class=\"row g-2\">\r\n");
      out.write("                                ");

                                    for(WatchlistEntity watchlistItem : watchlistItems){

                                    Query<StockEntity> query1 = session1.createQuery("SELECT s FROM StockEntity s " +
                                            "INNER JOIN s.bookByBookId b " +
                                            "INNER JOIN b.categoryByCategoryId c " +
                                            "INNER JOIN b.bookConditionByBookConditionId bc " +
                                            "INNER JOIN b.authorByAuthorId a " +
                                            "INNER JOIN b.publisherByPublisherId p " +
                                            "INNER JOIN b.languageBylanguageId l " +
                                            "INNER JOIN b.editionByEditionId e " +
                                            "WHERE s.id= :stockID", StockEntity.class)
                                            .setParameter("stockID", watchlistItem.getStockId());
                                    StockEntity stockItem = query1.uniqueResult();

                                    Query<ImagesEntity> query2 = session1.createQuery("SELECT i FROM ImagesEntity i " +
                                                    "WHERE i.productId= :productId", ImagesEntity.class)
                                            .setParameter("productId", stockItem.getBookId());
                                    ImagesEntity image = query2.uniqueResult();

//                            for($x=0; $x<$watchlist_num; $x++){
//                                $watchlist_data = $watchlist_rs->fetch_assoc();
//                                $product_id = $watchlist_data["stock_id"];
//
//                                $product_rs = Database::search("SELECT `book`.`id` AS `book_id`,`book`.`title`,`book`.`description`,
//                                `book`.`pages`,`category`.`name` AS `category`,`condition`.`name` AS `condition`,
//                                `author`.`name` AS `author`,`publisher`.`name` AS `publisher`,`language`.`name` AS `language`,
//                                `edition`.`name` AS `edition`,`stock`.`id` AS `stock_id`,`stock`.`selling_price`,`stock`.`qty`,`stock`.`delivery_fee_colombo`,`stock`.`delivery_fee_other`
//                                FROM `stock` INNER JOIN `book` ON `stock`.`book_id`=`book`.`id`
//                                INNER JOIN `category` ON `book`.`category_id`=`category`.`id`
//                                INNER JOIN `condition` ON `book`.`condition_id`=`condition`.`id`
//                                INNER JOIN `author` ON `book`.`author_id`=`author`.`id`
//                                INNER JOIN `publisher` ON `book`.`publisher_id`=`publisher`.`id`
//                                INNER JOIN `language` ON `book`.`language_id`=`language`.`id`
//                                INNER JOIN `edition` ON `book`.`edition_id`=`edition`.`id`
//                                WhERE `stock`.`id`='".$watchlist_data["stock_id"]."'");
//                                $product_data = $product_rs->fetch_assoc();


//                                $img_rs = Database::search("SELECT * FROM `images` WHERE
//                                `product_id`='".$product_data["book_id"]."'");
//                                $img_data = $img_rs->fetch_assoc();


                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"card mb-3 mx-0 mx-lg-2 col-12\">\r\n");
      out.write("                                    <div class=\"row g-0\">\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            <img src=\"");
      out.print( image.getCode() );
      out.write("\" class=\"img-fluid rounded-start\" style=\"height: 270px;\"/>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-5\">\r\n");
      out.write("                                            <div class=\"card-body\">\r\n");
      out.write("                                                <h5 class=\"card-title fw-bold fs-2 text-success\">");
      out.print( stockItem.getBookByBookId().getTitle() );
      out.write("</h5>\r\n");
      out.write("                                                <span class=\"fs-4 text-black-50\">Author : ");
      out.print( stockItem.getBookByBookId().getAuthorByAuthorId().getName() );
      out.write("</span>\r\n");
      out.write("                                                <br/>\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black-50\">Condition : ");
      out.print( stockItem.getBookByBookId().getConditionByConditionId().getName() );
      out.write("</span>\r\n");
      out.write("                                                <br/>\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black-50\">Language : </span>\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black-50\">");
      out.print( stockItem.getBookByBookId().getLanguageBylanguageId().getName() );
      out.write("</span>\r\n");
      out.write("                                                <br/>\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black-50\">Price : </span>&nbsp;&nbsp;\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black\">Rs. ");
      out.print( stockItem.getSellingPrice() );
      out.write("0</span>\r\n");
      out.write("                                                <br/>\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black-50\">Quantity : </span>&nbsp;&nbsp;\r\n");
      out.write("                                                <span class=\"fs-5 fw-bold text-black\">");
      out.print( stockItem.getQty() );
      out.write(" Items Available</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-3 mt-4\">\r\n");
      out.write("                                            <div class=\"card-body d-lg-grid\">\r\n");
      out.write("                                                <a href='singleProductView?id=");
      out.print( stockItem.getId() );
      out.write("' class=\"btn btn-outline-success mb-2\">Buy Now</a>\r\n");
      out.write("                                                <a onclick=\"addToCart(");
      out.print( stockItem.getId() );
      out.write(");\" class=\"btn btn-outline-secondary mb-2\">Add to Cart</a>\r\n");
      out.write("                                                <a class=\"btn btn-outline-danger\" onclick=\"removeFromWatchlist(");
      out.print( watchlistItem.getId() );
      out.write(");\">Remove</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            ");


                             }
                            
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- have products -->\r\n");
      out.write("                        ");

                        }

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/script.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");

        transaction.commit();
        session1.close();
    }
}else{

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    alert(\"Please Sign In First\");\r\n");
      out.write("    fetch(\"\", {\r\n");
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
