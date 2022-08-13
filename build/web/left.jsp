<%-- 
    Document   : left
    Created on : Mar 6, 2022, 2:06:24 AM
    Author     : Minh Hoàng
--%>

<%@page import="shopping.Catagory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <%
                List<Catagory> listC = (List<Catagory>) request.getAttribute("LIST_CATAGORY");
                String tag = (String) request.getAttribute("TAG");
                if (tag == null) {
                    tag = "";
                }
                for (Catagory c : listC) {
            %>                        
            <li class="list-group-item text-white <%=tag.equals(c.getCatagoryID())?"active":""%> "><a href="SearchCatagory?catagoryID=<%=c.getCatagoryID()%>"><%= c.getCatagoryName()%></a></li>
                <%
                    }
                %>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" />
            <h5 class="card-title">${p.name}</h5>
            <p class="card-text">${p.title}</p>
            <p class="bloc_left_price">${p.price} $</p>
        </div>
    </div>
</div>
