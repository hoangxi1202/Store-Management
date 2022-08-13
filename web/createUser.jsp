<%-- 
    Document   : createUser
    Created on : Mar 2, 2022, 10:29:47 PM
    Author     : Minh Hoàng
--%>

<%@page import="user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create new User</h1>
        <%
             UserError userError = (UserError)request.getAttribute("USER_ERROR");
             if (userError==null){
                 userError = new UserError();
             }
        %>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/>
            <%=userError.getUserIDError() %></br>
            Full Name<input type="text" name="fullName" required=""/>
            <%=userError.getFullNameError()%></br>
            Role ID<input type="text" name="roleID" required=""/>
            <%=userError.getRoleIDError()%></br>
            Password<input type="password" name="password" required=""/></br>
            Confirm<input type="password" name="confirm" required=""/>
            <%=userError.getConfirmError()%></br>
            <input type="submit" name="action"value="Create"/>
            <input type="reset" value="Reset"/>
            <%=userError.getMessageError()%>
        </form>
        <a href="login.html">Login</a>
    </body>
</html>
