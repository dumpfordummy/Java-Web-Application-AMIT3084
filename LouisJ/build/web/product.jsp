<%-- 
    Document   : product
    Created on : Apr 24, 2023, 8:51:24 PM
    Author     : Asus
--%>

<%@page import="model.ProductService"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/common_css_js.jsp" %>
        <%@include file="navbar.jsp" %>
        <link rel="stylesheet" type="text/css" href="styling/product.css">
        <title>Louis J - Product</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="filter-sidebar">
                        <div class="card-header">
                            <h5 class="mb-3 pb-2" style="border-bottom: 1px solid #111">Filter</h5>
                        </div>
                        <div class="card-body">
                            <form action="filterCategory" method="get">
                                <div class="form-group">
                                    <label for="category">Category</label>
                                    <select class="form-control" id="category" name="category">
                                        <option value="all">ALL</option>
                                        <option value="beltBag" id="beltBag">Belt Bag</option>
                                        <option value="clutchBag" id="clutchBag">Clutch Bag</option>
                                        <option value="backpack" id="backpack">Backpack</option>
                                    </select>
                                </div>
                                <br>
                                <label for="customRange2" class="form-label">Price range</label>
                                <div class="d-flex align-items-center">
                                    <input type="range" class="form-range me-2" value="<%=request.getAttribute("priceRangeInput")%>" style="width: 150px;" min="0" max="<%=request.getAttribute("maxPrice")%>" id="customRange2" name="priceRange">
                                    <input type="number" class="form-control" value="<%=request.getAttribute("priceRangeInput")%>" id="rangeValue" style="width: 80px;" min="0" max="<%=request.getAttribute("maxPrice")%>" name="priceRangeInput">
                                </div>
                                <br>
                                <div class="d-grid gap-2">
                                    <input type="submit" class="btnFilter" value="Apply Filter"></input>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-9">
                    <div class="row product">
                        <%
                            List<Product> productList = (List<Product>) request.getAttribute("productList");
                            for (Product product : productList) {
                        %>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="ccc">
                                    <p class="text-center"><img src="https://raw.githubusercontent.com/rxhack/productImage/main/1.jpg" class="imw"></p> 
                                </div>
                                <div class="card-body">
                                    <h5 class="text-center"><%=product.getName()%></h5> 
                                    <p class="text-center">Price: RM <%=product.getPrice()%></p>
                                    <p class="text-center"><input type="submit" name="Save" value="Learn More" class="cc1"></p>
                                </div>
                            </div>
                        </div>
                        <% }%> 
                    </div>
                </div>
            </div>
        </div>
        <script>
            const range = document.getElementById('customRange2');
            const rangeValue = document.getElementById('rangeValue');

            range.addEventListener('input', () => {
                rangeValue.value = range.value;
            });

            rangeValue.addEventListener('input', () => {
                range.value = rangeValue.value;
            });

            const params = new Proxy(new URLSearchParams(window.location.search), {
                get: (searchParams, prop) => searchParams.get(prop),
            });

            let value = params.category;
            document.getElementById(value).selected = true;
        </script>
    </body>
</html>
