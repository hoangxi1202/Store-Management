<%-- 
    Document   : shopping
    Created on : Mar 3, 2022, 12:01:19 AM
    Author     : Minh Hoàng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Milk Tea</title>
    </head>
    <body>
        <h1>Welcome to our store!</h1>
        <form action="MainController">
            Choose your tea:
            <select name="cmbTea">
                <option value="T01-Ice tea-10">Ice tea</option>
                <option value="T02-Pink tea-60">Pink tea</option>
                <option value="T03-Peach tea-50">Peach tea</option>
                <option value="T04-Matcha tea-30">Matcha tea</option>
            </select>
            <input type="number" name="quantity" value="1"/>
            <input type="submit" name="action" value="Add to cart"/>
            <input type="submit" name="action" value="View cart"/></br>
            <%
                String message = (String) request.getAttribute("SHOPPING_MESSAGE");
                if (message == null) {
                    message = "";
                }
            %>
            <%= message %>
        </form>
    </body>
</html>
