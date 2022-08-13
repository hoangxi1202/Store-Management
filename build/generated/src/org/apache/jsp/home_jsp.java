package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shopping.Catagory;
import shopping.Product;
import java.util.List;
import user.UserDTO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!------ Include the above in your HEAD tag ---------->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/styleHome.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <nav aria-label=\"breadcrumb\">\n");
      out.write("                            <ol class=\"breadcrumb\">\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"Home.jsp\">Home</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item\"><a href=\"#\">Category</a></li>\n");
      out.write("                                <li class=\"breadcrumb-item active\" aria-current=\"#\">Sub-category</li>\n");
      out.write("                            </ol>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "left.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                        ");

                            List<Product> list = (List<Product>) request.getAttribute("LIST_PRODUCT");
                            for (Product p : list) {
                        
      out.write(" \n");
      out.write("                        <div class=\"col-12 col-md-6 col-lg-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <img class=\"card-img-top\" src=\"");
      out.print( p.getImage());
      out.write("\" alt=\"Card image cap\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h4 class=\"card-title show_txt\"><a href=\"DetailController?productID=");
      out.print(p.getProductID());
      out.write("\" title=\"View Product\">");
      out.print( p.getProductName());
      out.write("</a></h4>\n");
      out.write("                                    <p class=\"card-text show_txt\">");
      out.print( p.getProductName());
      out.write("</p>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col\">\n");
      out.write("                                            <p class=\"btn btn-danger btn-block\">");
      out.print( p.getPrice());
      out.write("</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col\">\n");
      out.write("\n");
      out.write("                                            <a href=\"cart?productID=");
      out.print(p.getProductID());
      out.write("\" class=\"btn btn-success btn-block\">Add to cart</a>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
