<%-- 
    Document   : main
    Created on : 9 Apr. 2023, 8:47:39 pm
    Author     : John
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <h1>User Profile</h1>
        <table id="profile_table">
            <thead><th>Name</th><th>Username</th><th>E-mail</th><th>Address</th><th>Password</th></thead>
        <tr><td>${user.name}</td><td>${user.username}</td><td>${user.email}</td><td>${user.address}</td><td>${user.password}</td></tr>
        </table>
        <a href="logout.jsp">Logout</a>
    </body>
</html>
