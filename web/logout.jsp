<%-- 
    Document   : logout
    Created on : 9 Apr. 2023, 8:48:03 pm
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session.invalidate();
        %>
        <h1>You have logged out.</h1>
        <a href="index.jsp">Return to home page</a>
    </body>
</html>
