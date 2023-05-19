<%@page import="uts.isd.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webpage.css"> 
        <title>Access Logs</title>
    </head>
    <body>
        <%@include file="./navbar.jsp"%>
        <h1>Access Logs</h1>
        <%
            String requestDate = (String) request.getAttribute("requestDate");
            String fieldDate = requestDate == null ? "" : requestDate;
        %>
        <table>
            <form action="FilterAccessLogServlet" method="POST">
                <tr>
                    <td><label for="lname">Date</label></td> 
                    <td><input class="searchField" type="text" name="accessDate" placeholder="yyyy-mm-dd" value="<%=fieldDate%>"></input></td>
                    <td><input type="submit" value="Filter" class="filterButton"></td>
                </tr>
            </form>
        </table>
        <%
            String accessLogError = (String) request.getAttribute("accessLogError");
        %>
        <p style="color:red"><%=accessLogError == null ? "" : accessLogError%></p>
        <%
            ArrayList<AccessLog> accessLog = new ArrayList<AccessLog>();
            ArrayList<AccessLog> filterAccessLog = (ArrayList<AccessLog>) request.getAttribute("filterAccessLog");
            if (filterAccessLog != null) {
                accessLog = filterAccessLog;
            } else {
                accessLog = (ArrayList<AccessLog>) session.getAttribute("accessLog");
            }
        %>
        <table>
            <tr>
                <th>User ID</th>
                <th>Date & Time</th>
                <th>Event</th>
            </tr>
            <%
                for (AccessLog log : accessLog) {
            %>

            <tr>
                <td><p><%=log.getUserID()%></p></td>
                <td><p><%=log.getAccessDateTime()%></p></td>
                <td><p><%=log.getEvent()%></p></td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>
