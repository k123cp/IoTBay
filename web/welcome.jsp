<%-- 
    Document   : welcome
    Created on : 9 Apr. 2023, 7:38:10 pm
    Author     : John
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to IoTBay</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
        %>
        <h1>Welcome <%= name%></h1>
        <p>Your username is <%= username%></p>
        <p>Your address is <%= address%></p>
        <p>Your password is <%= password%></p>
        <a href="index.jsp">Cancel</a>
        <a href="main.jsp">Main</a>
        <%
            User user = new User(name, username, email, password, address);
            session.setAttribute("user", user);
        %>
    </body>
</html>
