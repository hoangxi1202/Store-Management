<%-- 
    Document   : ViewCard
    Created on : Mar 3, 2022, 1:20:55 AM
    Author     : Minh Hoàng
--%>

<%@page import="shopping.Tea"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1>Ban chua chon san pham nao</h1>
        <%
        } else {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Product p : cart.getCart().values()) {
                        total += p.getQuatity() * p.getPrice();
                %>
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td><%= p.getId()%></td>
                    <td><%= p.getName()%></td>
                    <td>
                        <%--<%= // tea.getQuatity()%>--%>
                        <input type="number" name="quantity" value="<%= p.getQuatity() %>"/>                      
                    </td>
                    <td><%= p.getPrice()%></td>
                    <td><%= p.getQuatity() * tea.getPrice()%></td>
                    <td>
                        <input type="submit" name="action" value="Update Cart"/>
                        <input type="hidden" name="id" value="<%= p.getId() %>"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%> </h1>
    <%
        }
    %>
    <a href="HomeController">Add more</a>
</body>
</html>
