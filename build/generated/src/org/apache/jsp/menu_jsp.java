package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shopping.Item;
import shopping.Cart;
import user.UserDTO;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--begin of menu-->\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"HomeController\">Vegetable and Fruit</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"></button>\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        <div class=\"collapse navbar-collapse justify-content-end\" id=\"navbarsExampleDefault\">\n");
      out.write("            <ul class=\"navbar-nav m-auto\">  \n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#\"></a>\n");
      out.write("                </li>\n");
      out.write("                ");

                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

                    if (loginUser != null) {
                        if (loginUser.getRoleID().equals(("AD"))) {
                
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"admin.jsp\">Manager Account</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"ManagerProduct\">Manager Product</a>\n");
      out.write("                </li>\n");
      out.write("                ");

                        }
                    }
                    if (loginUser != null) {
                
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Hello ");
      out.print( loginUser.getFullName());
      out.write(" </a>\n");
      out.write("                </li> \n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"LogoutConTroller\">Logout</a>                   \n");
      out.write("                </li>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                ");

                    if (loginUser == null) {
                
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"login.html\">Login</a>\n");
      out.write("                </li>\n");
      out.write("                ");

                    }
                
      out.write("              \n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            ");

                String search = (String) request.getParameter("txt");
                if (search == null) {
                    search = "";
                }

            
      out.write("\n");
      out.write("            <form action=\"SearchProduct\" method=\"post\" class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                <div class=\"input-group input-group-sm\">\n");
      out.write("                    <input name=\"txt\" type=\"text\" class=\"form-control\" aria-label=\"Small\" aria-describedby=\"inputGroup-sizing-sm\" placeholder=\"Search...\" value=\"");
      out.print(search);
      out.write("\">\n");
      out.write("                    <div class=\"input-group-append\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-secondary btn-number\">\n");
      out.write("                            <i class=\"fa fa-search\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                    Cart cart = (Cart) session.getAttribute("CART");
                    int totalquantity = 0;
                    if (cart != null) {
                        for (Item p : cart.getCart().values()) {
                            totalquantity += p.getQuatity();
                        }
                    }
                
      out.write("\n");
      out.write("                <a class=\"btn btn-success btn-sm ml-3\" href=\"cart.jsp\">\n");
      out.write("                    <i class=\"fa fa-shopping-cart\"></i> Cart\n");
      out.write("                    <span class=\"badge badge-light\">");
      out.print(totalquantity);
      out.write("</span>\n");
      out.write("                </a>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<section class=\"jumbotron text-center\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1 class=\"jumbotron-heading\">Cửa hàng rau củ quả chất lượng cao</h1>\n");
      out.write("        <p class=\"lead text-muted mb-0\">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp sản phẩm organic</p>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<!--end of menu-->\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
