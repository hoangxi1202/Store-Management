<%-- 
    Document   : user
    Created on : Mar 2, 2022, 10:38:12 AM
    Author     : Minh Hoàng
--%>

<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                return;
            } else {
        %>
        <h1>Hello User role: <%= user.getFullName()%></h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <%
            }
        %> 
        <a href="shopping.jsp">Shopping Page</a>
    </body>
</html>
