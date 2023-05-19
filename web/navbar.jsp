<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webpage.css"> 
    </head>
    <body>
        <%
            String userType = (String) session.getAttribute("userType");
            if (userType.equals("admin")) {
        %>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a id="name" href="welcome.jsp">IoTBay</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AccessLogServlet">System Access Logs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProductServlet">Manage Products</a>

            <li id="nav-right">
                <a id="logout-btn" href="LogoutServlet">Logout</a>
            </li>
        </ul>
        <%
            } else if (userType.equals("customer")) {
            Customer customer = (Customer) session.getAttribute("user");
        %>
        
        <ul class="navbar-nav">
            <li class="nav-item">
                <a id="name" href="welcome.jsp">IoTBay</a>
            </li>
            <li class="nav-item">
                <a  class="nav-link" href="main.jsp">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProductServlet">Browse Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="SavedOrderServlet">Current Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="OrderHistoryServlet">Order History</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ShipmentDetailServlet">Shipment History</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PaymentInformationServlet">Payment History</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AccessLogServlet">Access History</a>
            </li>
            <li id="nav-right">
                <a id="logout-btn" href="LogoutServlet">Logout</a>
            </li>
        </ul>
        
        <%
            } else if (userType.equals("staff")) {
            Staff staff = (Staff) session.getAttribute("user");
        %>
        
        <ul class="navbar-nav">
            <li class="nav-item">
                <a id="name" href="welcome.jsp">IoTBay</a>
            </li>
            <li class="nav-item">
                <a  class="nav-link" href="main.jsp">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProductServlet">Manage Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AccessLogServlet">Access History</a>
            </li>
            <li id="nav-right">
                <a id="logout-btn" href="LogoutServlet">Logout</a>
            </li>
        </ul>
        
        <% 
            } else {
        %>
       <ul class="navbar-nav">
            <li class="nav-item">
                <h3 id="name">IoTBay</h3>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProductServlet">Browse Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="SavedOrderServlet">Saved Order</a>
            </li>
            <li id="nav-right">
                <a id="logout-btn" href="LogoutServlet">Exit</a>
            </li>
        </ul>
        <% } %>
    </body>
</html>
