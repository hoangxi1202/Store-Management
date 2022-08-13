<%-- 
    Document   : home
    Created on : Mar 4, 2022, 6:12:18 PM
    Author     : Minh Hoàng
--%>

<%@page import="shopping.Catagory"%>
<%@page import="shopping.Product"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/styleHome.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row">
                        <%
                            List<Product> list = (List<Product>) request.getAttribute("LIST_PRODUCT");
                            for (Product p : list) {
                        %> 
                        <div class="col-12 col-md-6 col-lg-4">
                            <div class="card">
                                <img class="card-img-top" src="<%= p.getImage()%>" alt="Card image cap">
                                <div class="card-body">
                                    <h4 class="card-title show_txt"><a href="DetailController?productID=<%=p.getProductID()%>" title="View Product"><%= p.getProductName()%></a></h4>
                                    <p class="card-text show_txt"><%= p.getProductName()%></p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block"><%= p.getPrice()%></p>
                                        </div>
                                        <div class="col">

                                            <a href="cart?productID=<%=p.getProductID()%>" class="btn btn-success btn-block">Add to cart</a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>


            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
