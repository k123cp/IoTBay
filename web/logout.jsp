<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webpage.css"> 
        <title>Logout</title>
    </head>
    <header>
        <h1>IoTBay</h1>
    </header>
    <body class="noNavBody">
        <h1>Logout</h1>
        <%
            String logoutMessage = (String) request.getAttribute("logoutMessage");
        %>
        <p><%=logoutMessage%><br> Click <a id="nothing" href = index.jsp>here</a> to return to the homepage.</p>
    </body>
</html>
