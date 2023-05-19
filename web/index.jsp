<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webpage.css"> 
        <title>IoT Bay</title>
    </head>
    <header>
        <h1>IoTBay</h1>
    </header>
    <body class="noNavBody">
        <h1>Welcome to IoTBay!</h1>
        <h3>The largest online storefront for Internet of Thing devices</h3>
        <div class="container">
            <a class="mainbtn" href="registerSelect.jsp" >Register</a> 
            <a class="mainbtn" href="login.jsp" >Login</a>
            <a class="mainbtn" href="UserEnterServlet">View Products</a>
        </div>


        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
