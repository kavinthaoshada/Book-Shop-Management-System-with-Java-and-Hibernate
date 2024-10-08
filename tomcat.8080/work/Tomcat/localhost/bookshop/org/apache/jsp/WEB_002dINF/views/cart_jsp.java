/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.7
 * Generated at: 2023-10-12 18:42:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import org.hibernate.SessionFactory;
import com.calm.webdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.calm.webdb.entity.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("com.calm.webdb.entity");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.hibernate.Transaction");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("org.hibernate.SessionFactory");
    _jspx_imports_classes.add("org.hibernate.query.Query");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Infinity | Cart</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"icon\" href=\"assets/resources/infinity_logo2.svg\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");

            List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
            boolean existUser = false;
            String userEmail = null;
            if (users != null) {
                for (UsersEntity user : users) {
                    existUser = true;
                    userEmail = user.getEmail();
                }
            }
            if(existUser){
                double total = 0;
                double subTotal = 0;
                double shipping = 0;

        
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12 pt-2\" style=\"background-color: #E3E5E4;\">\r\n");
      out.write("            <nav aria-label=\"breadcrumb\">\r\n");
      out.write("                <ol class=\"breadcrumb\">\r\n");
      out.write("                    <li class=\"breadcrumb-item\">Home</li>\r\n");
      out.write("                    <li class=\"breadcrumb-item active\" aria-current=\"page\">Cart</li>\r\n");
      out.write("                </ol>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12 border border-0 border-secondary rounded mb-3\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <label class=\"form-label fs-1 fw-bold\">Basket <i class=\"bi bi-cart3 fs-2\"></i></label>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 col-lg-6\">\r\n");
      out.write("                    <hr class=\"hr-break-1\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12 col-lg-6 offset-0 offset-lg-3 mb-3\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Search in Busket..\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <hr class=\"hr-break-1\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                    Session session1 = sessionFactory.openSession();
                    Transaction transaction = session1.beginTransaction();
                    Query<CartEntity> query = session1.createQuery("SELECT c FROM CartEntity c " +
                            "WHERE c.usersEmail= :usersEmail", CartEntity.class)
                            .setParameter("usersEmail", userEmail);
                    List<CartEntity> cartItems = query.getResultList();
                    int cartNumber=0;
                
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- empty -->\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12 emptycart\"></div>\r\n");
      out.write("                        <div class=\"col-12 text-center mb-2\">\r\n");
      out.write("                            <label class=\"form-label fs-1\">You have no item in your basket.</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-12 col-lg-4 offset-0 offset-lg-4 d-d-grid mb-4\">\r\n");
      out.write("                            <a href=\"#\" class=\"btn btn-primary fs-5 col-12\">Start Shoping</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- empty -->\r\n");
      out.write("\r\n");
      out.write("               ");


                   for(CartEntity cartItem : cartItems){
//                            $cart_data = $cart_rs->fetch_assoc();
                       cartNumber++;
                       Query<StockEntity> query1 = session1.createQuery("SELECT s FROM StockEntity s " +
                                       "INNER JOIN s.bookByBookId b " +
                                       "INNER JOIN b.categoryByCategoryId c " +
                                       "INNER JOIN b.bookConditionByBookConditionId bc " +
                                       "INNER JOIN b.authorByAuthorId a " +
                                       "INNER JOIN b.publisherByPublisherId p " +
                                       "INNER JOIN b.languageBylanguageId l " +
                                       "INNER JOIN b.editionByEditionId e " +
                                       "WHERE s.id= :stockId", StockEntity.class)
                               .setParameter("stockId", cartItem.getStockId());
//                       List<StockEntity> stockItems = query1.getResultList();
                       StockEntity stockItem = query1.uniqueResult();

//                $product_rs = Database::search("SELECT `book`.`id` AS `book_id`,`book`.`title`,`book`.`description`,
//                `book`.`pages`,`category`.`name` AS `category`,`condition`.`name` AS `condition`,
//                `author`.`name` AS `author`,`publisher`.`name` AS `publisher`,`language`.`name` AS `language`,
//                `edition`.`name` AS `edition`,`stock`.`selling_price`,`stock`.`qty`,`stock`.`delivery_fee_colombo`,`stock`.`delivery_fee_other`
//                FROM `stock` INNER JOIN `book` ON `stock`.`book_id`=`book`.`id`
//                INNER JOIN `category` ON `book`.`category_id`=`category`.`id`
//                INNER JOIN `condition` ON `book`.`condition_id`=`condition`.`id`
//                INNER JOIN `author` ON `book`.`author_id`=`author`.`id`
//                INNER JOIN `publisher` ON `book`.`publisher_id`=`publisher`.`id`
//                INNER JOIN `language` ON `book`.`language_id`=`language`.`id`
//                INNER JOIN `edition` ON `book`.`edition_id`=`edition`.`id`
//                WhERE `stock`.`id`='".$cart_data["stock_id"]."'");
//                $product_data = $product_rs->fetch_assoc();

                       total = total + (stockItem.getSellingPrice()*stockItem.getQty());

                       Query<UserHasAddressEntity> query2 = session1.createQuery("SELECT s FROM UserHasAddressEntity s " +
                                       "WHERE s.usersEmail= :usersEmail", UserHasAddressEntity.class)
                               .setParameter("usersEmail", userEmail);
                       UserHasAddressEntity addressData = query2.uniqueResult();
                       int cityId = addressData.getCityId();

//                $address_rs = Database::search("SELECT * FROM `user_has_address` WHERE
//                `users_email`='".$uemail."'");
//                $address_data = $address_rs->fetch_assoc();
//                $city_id = $address_data["city_id"];

                       Query<CityEntity> query3 = session1.createQuery("SELECT s FROM CityEntity s " +
                                       "WHERE s.id= :cityId", CityEntity.class)
                               .setParameter("cityId", cityId);
                       CityEntity districtData = query3.uniqueResult();
                       int districtId = districtData.getDistrictId();

//                $district_rs = Database::search("SELECT * FROM `city` WHERE `id`='".$city_id."'");
//                $district_data = $district_rs->fetch_assoc();
//                $district_id = $district_data["district_id"];

//                $ship = 0;
                double ship =0;

                if(districtId == 4){
                    ship = stockItem.getDeliveryFeeColombo();
                    shipping =shipping + stockItem.getDeliveryFeeColombo();
                }else{
                ship = stockItem.getDeliveryFeeOther();
                shipping =shipping + stockItem.getDeliveryFeeOther();
                }

                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 col-lg-9\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"card mb-3 mx-0 col-12\">\r\n");
      out.write("                            <div class=\"row g-0\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-md-12 mt-3 mb-3\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <hr>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-md-4\">\r\n");
      out.write("                                    ");

                                        Query<ImagesEntity> query4 = session1.createQuery("SELECT s FROM ImagesEntity s " +
                                                        "WHERE s.productId= :bookId", ImagesEntity.class)
                                                .setParameter("bookId", stockItem.getBookId());
                                        ImagesEntity imgData = query4.uniqueResult();
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"d-inline-block\" tabindex=\"0\" data-bs-toggle=\"popover\"\r\n");
      out.write("                                          data-bs-trigger=\"hover focus\" data-bs-content=\"");
      out.print( stockItem.getBookByBookId().getDescription() );
      out.write("\"\r\n");
      out.write("                                    title=\"Product Description\">\r\n");
      out.write("                                    <img src=\"");
      out.print( imgData.getCode() );
      out.write("\"\r\n");
      out.write("                                    class=\"img-fluid rounded-start\" style=\"max-width: 200px;\" />\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-md-5\">\r\n");
      out.write("                                    <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                                        <h3 class=\"card-title\">");
      out.print( stockItem.getBookByBookId().getTitle() );
      out.write("</h3>\r\n");
      out.write("                                        <span class=\"fw-bold text-black-50\">Author :");
      out.print( stockItem.getBookByBookId().getAuthorByAuthorId().getName() );
      out.write("</span>&nbsp;\r\n");
      out.write("                                        &nbsp;<span class=\"fw-bold text-black-50\">Condition :");
      out.print( stockItem.getBookByBookId().getConditionByConditionId().getName() );
      out.write("</span>\r\n");
      out.write("\r\n");
      out.write("                                        <br/>\r\n");
      out.write("\r\n");
      out.write("                                        <span class=\"fw-bold text-black-50 fs-5\">Price :</span>&nbsp;\r\n");
      out.write("                                        <span class=\"fw-bold text-black fs-5\">Rs. ");
      out.print( stockItem.getSellingPrice() );
      out.write("0</span>\r\n");
      out.write("\r\n");
      out.write("                                        <br/>\r\n");
      out.write("\r\n");
      out.write("                                        <span class=\"fw-bold text-black-50 fs-5\">Quantity :</span>&nbsp;\r\n");
      out.write("                                        <input type=\"number\" class=\"mt-3 border border-2 border-secondary fs-4 fw-bold px-3 cardqtytext\"\r\n");
      out.write("                                               value=\"");
      out.print( cartItem.getQty() );
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("                                        <br/><br/>\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                         if(districtId == 4){

                                        
      out.write("\r\n");
      out.write("                                        <span class=\"fw-bold text-black-50 fs-5\">Delivery fee :</span>&nbsp;\r\n");
      out.write("                                        <span class=\"fw-bold text-black fs-5\">Rs. ");
      out.print( stockItem.getDeliveryFeeColombo() );
      out.write("0</span>\r\n");
      out.write("                                        ");

                                         }else{
                                        
      out.write("\r\n");
      out.write("                                        <span class=\"fw-bold text-black-50 fs-5\">Delivery fee :</span>&nbsp;\r\n");
      out.write("                                        <span class=\"fw-bold text-black fs-5\">Rs. ");
      out.print( stockItem.getDeliveryFeeOther() );
      out.write("0</span>\r\n");
      out.write("                                        ");

                                         }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-md-3\">\r\n");
      out.write("                                    <div class=\"card-body d-grid\">\r\n");
      out.write("                                        <a href='singleProductView.php?id=");
      out.print( stockItem.getBookId() );
      out.write("' class=\"btn btn-outline-success mb-2\">Buy Now</a>\r\n");
      out.write("                                        <a href=\"#\" class=\"btn btn-outline-danger\" onclick=\"deleteFromCart(");
      out.print( cartItem.getId() );
      out.write(");\">Remove</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <hr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"col-md-12 mt-3 mb-3\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-6 col-md-6\">\r\n");
      out.write("                                            <span class=\"fw-bold fs-5 text-black-50\">Requested Total<i class=\"bi bi-info-circle\"></i></span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-6 col-md-6 text-end\">\r\n");
      out.write("                                            <span class=\"fw-bold fs-5 text-black-50\">Rs.");
      out.print( (stockItem.getSellingPrice()*cartItem.getQty())+ship );
      out.write("0</span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                ");


//                        }

                    }

                
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- sumary -->\r\n");
      out.write("                <div class=\"col-12 col-lg-3\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <label class=\"form-label fs-3 fw-bold\">Summary</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12\">\r\n");
      out.write("                            <hr />\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6 mb-3\">\r\n");
      out.write("                            <span class=\"fs-6 fw-bold\">items (");
      out.print( cartNumber );
      out.write(")</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6 text-end mb-3\">\r\n");
      out.write("                            <span class=\"fs-6 fw-bold\">Rs. ");
      out.print( total );
      out.write("0</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <span class=\"fs-6 fw-bold\">Shipping</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6 text-end\">\r\n");
      out.write("                            <span class=\"fs-6 fw-bold\">Rs. ");
      out.print( shipping );
      out.write("0</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12 mt-3\">\r\n");
      out.write("                            <hr />\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6 mt-2\">\r\n");
      out.write("                            <span class=\"fs-4 fw-bold\">Total</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6 mt-2 text-end\">\r\n");
      out.write("                            <span class=\"fs-4 fw-bold\">Rs. ");
      out.print( total+shipping );
      out.write("0</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-12 mt-3 mb-3 d-grid\">\r\n");
      out.write("                            <button class=\"btn btn-primary fs-5 fw-bold\">CHECKOUT</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- sumary -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle=\"popover\"]'))\r\n");
      out.write("    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {\r\n");
      out.write("        return new bootstrap.Popover(popoverTriggerEl)\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

    transaction.commit();
    session1.close();
}else{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    // window.location = \"\";\r\n");
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
      out.write("<!-- <script src=\"bootstrap.bundle.js\"></script>\r\n");
      out.write("<script src=\"bootstrap.js\"></script> -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
