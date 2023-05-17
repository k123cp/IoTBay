<%-- 
    Document   : register
    Created on : 9 Apr. 2023, 7:05:18 pm
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>

 

     <body>
        <h1 class="form-title">Register</h1>
       <form action = "welcome.jsp" method="post">
            <table>
                <tr>
                    <td>
                        <label for="email">E-mail:</label>
                    </td>
                    <td>
                        <input type ="text" id="email" name="email" required><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="name">Name:</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="name" required>
                    </td>
               
                </tr>
                
                <tr>
                    <td>
                        <label for name="password">Password:</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="username">Username:</label>                     
                    </td>
                    <td>
                        <input type="username" id="username" name="username" required>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="address">Address:</label>                     
                    </td>
                    <td>
                        <input type="address" id="address" name="address" required>
                    </td>
                </tr>
              
            </table>
            <a href="index.jsp">Cancel</a>
            <input type="submit" value="Sign up">
          
           
        </form>
    </body>
 
</html>
