<%-- 
    Document   : productDetail
    Created on : Apr 26, 2023, 9:37:05 PM
    Author     : Asus
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/common_css_js.jsp" %>
        <%@include file="navbar.jsp" %>    
        <title>Product Detail</title>
    </head>
    <body>
        <div class="container px-4 text-center">
            <div class="row gx-5">
                <div class="col">
                    <div class="p-3"><img src="image/belt_bag_home.png" class="card-img-top"></div>
                </div>
                <div class="col">
                    <div class="p-3">
                        <table>
                            <thead>
                                <tr>
                                    <th>Product ID</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Type</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Product product = (Product) session.getAttribute("product");
                                %>
                                <tr>
                                    <td><%=product.getProductid()%></td>
                                    <td><%=product.getName()%></td>
                                    <td><%=product.getDescription()%></td>
                                    <td><%=product.getType()%></td>
                                    <td><%=product.getCategory()%></td>
                                    <td><%=product.getPrice()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>