<%-- 
    Document   : menu
    Created on : Mar 6, 2022, 1:55:24 AM
    Author     : Minh Hoàng
--%>
<%@page import="shopping.Item"%>
<%@page import="shopping.Cart"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="HomeController">Vegetable and Fruit</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation"></button>
        <span class="navbar-toggler-icon"></span>
        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">  
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <%
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

                    if (loginUser != null) {
                        if (loginUser.getRoleID().equals(("AD"))) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="admin.jsp">Manager Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" name="managerProduct" href="ManagerProduct">Manager Product</a>
                </li>
                <%
                        }
                    }
                    if (loginUser != null) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello <%= loginUser.getFullName()%> </a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="LogoutConTroller">Logout</a>                   
                </li>
                <%
                    }
                %>
                <%
                    if (loginUser == null) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="login.html">Login</a>
                </li>
                <%
                    }
                %>              

            </ul>
            <%
                String search = (String) request.getParameter("txt");
                if (search == null) {
                    search = "";
                }

            %>
            <form action="SearchProduct" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." value="<%=search%>">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <%
                    Cart cart = (Cart) session.getAttribute("CART");
                    int totalquantity = 0;
                    if (cart != null) {
                        for (Item p : cart.getCart().values()) {
                            totalquantity += p.getQuatity();
                        }
                    }
                %>
                <a class="btn btn-success btn-sm ml-3" href="cart.jsp">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light"><%=totalquantity%></span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Cửa hàng rau củ quả chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp sản phẩm organic</p>
    </div>
</section>
<!--end of menu-->
