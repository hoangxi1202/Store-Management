<%-- 
    Document   : cart
    Created on : Mar 6, 2022, 3:40:32 PM
    Author     : Minh Hoàng
--%>

<%@page import="user.UserDAO"%>
<%@page import="shopping.OderDetail"%>
<%@page import="user.OderDAO"%>
<%@page import="shopping.Item"%>
<%@page import="shopping.Cart"%>
<%@page import="java.util.List"%>
<%@page import="shopping.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/styleHome.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                            <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase">Đơn Giá</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase">Số Lượng</div>
                                            </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                OderDAO dao = new OderDAO();
                                                UserDAO dao1 = new UserDAO();
                                                String id = (String)session.getAttribute("ODERID");
                                                int total =0;
                                                List<OderDetail> newOderDetail = dao.getOderDetail(id);                                             
                                                for (OderDetail p : newOderDetail) {
                                                    Product product = dao1.getProduct(p.getProductID());
                                                    total += p.getQuantity()* p.getPrice();
                                            %>
                                            <tr>
                                                <th scope="row">
                                        <div class="p-2">
                                            <img src="<%=product.getImage()%>" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"><%=product.getProductName()%></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                            </div>
                                        </div>
                                        </th>
                                        <td class="align-middle">
                                            <strong><%=p.getPrice()%></strong>
                                        </td>
                                        <td class="align-middle">
                  
                                            <strong><%=p.getQuantity()%></strong>
                   
                                        </td>
                                        
                                        </tr>  
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <%
                            String mess = (String) session.getAttribute("MESSAGE");
                            if (session.getAttribute("MESSAGE") == null || mess.equals("don hang cua ban da dc them!")) {
                                mess = "";
                            }
                        %>
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                                        <div class="input-group-append border-0">
                                            <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold"><%=mess%></div>
                            </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>

                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong><%=Math.round(total * 10) / 10%></strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong><%=Math.round(total * 0.1 * 10) / 10%></strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold"><%=Math.round(total * 1.1 * 10) / 10%> ₫</h5>
                                        </li>
                                    </ul><a href="checkout.jsp" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
</html>
