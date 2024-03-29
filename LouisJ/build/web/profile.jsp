<%-- 
    Document   : profile
    Created on : Apr 25, 2023, 4:59:20 PM
    Author     : CY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Employee"%>
<%@page import="util.UserSessionUtil"%>
<%@page import="interfaces.User"%>
<%@page import="model.Customer"%>
<%@page import="model.CustomerService"%>

<%! UserSessionUtil userSession;%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <%@include file="components/common_css_js.jsp" %>
        <%@include file="navbar.jsp" %> 
        <link rel="stylesheet" href="styling/profile.css"/>
    </head>
    <body>
        <%
            userSession = new UserSessionUtil(request.getSession());
            User currentUser = userSession.getCurrentLoginUser(request.getCookies());

        %>
        <div class="container emp-profile">

            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="/image/<%= currentUser.getUsertype()%>/<%= currentUser.getId()%>"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="profile-head">
                        <h5>
                            <%= currentUser.getUsername()%>
                        </h5>
                        <h6>
                            <%= currentUser.getUsertype()%>
                        </h6>
                        <br>
                        <br>
                        <br>
                        <br>
                        <hr>
                    </div>
                </div>
                <div class="col-md-2">
                    <button class="profile-edit-btn" onclick="location.href='/profileEdit'" >Edit Profile</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">

                </div>
                <div class="col-md-8">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>User Id</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getId()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Username</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getUsername()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Fullname</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getFullname()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getEmail()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Contact</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getContact()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Address</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= currentUser.getAddress()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
