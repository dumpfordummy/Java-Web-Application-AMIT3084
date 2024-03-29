<%-- 
    Document   : welcome
    Created on : May 2, 2023, 3:47:02 PM
    Author     : Pua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styling/welcomeCSS.css">
        <%@include file="components/common_css_js.jsp" %>
        <title><%= getServletContext().getInitParameter("companyName") %> - Welcome</title>
    </head>
    <body>
        <div class="overlay">
            <div class="container d-flex flex-column justify-content-center align-items-center vh-100">
                <header class="text-center">
                    <form action="home" method="get">
                        <button type="submit" class="header-btn">
                            <h1 class="text-uppercase header-txt"><strong>Louis J</strong></h1>
                        </button>
                    </form>
                </header>
            </div>
        </div>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
