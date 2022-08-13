<%-- 
    Document   : index
    Created on : Mar 10, 2022, 3:25:21 PM
    Author     : Minh Hoàng
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<title>Login by Google</title>
</head>
<body>
  <h1>Bạn đã đăng nhập thành công bằng tài khoản</h1>
  <%
    String id = request.getAttribute("id").toString();
//    String name = request.getAttribute("name").toString();
    String email = request.getAttribute("email").toString();
//    out.print("Id: " + id);
//    out.print("<br/>Name: " + name);
    out.print("Email: " + email);
  %>
  <a href="LoginGGController?userID=<%=email%>">Home</a>
</body>
</html>