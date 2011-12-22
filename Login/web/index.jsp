<%-- 
    Document   : index
    Created on : Dec 8, 2011, 1:42:17 PM
    Author     : CHIKI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="loginForm" method="POST" action="login">
            Login Programatically: 
            <br><br>
            Username:<input type="text" name="txtUserName" value="" /><br>
            Password:<input type="password" name="txtPassword" value="" /><br>
                <br>
                <input type="submit" value="Login" />
                <input type="reset" value="Clear" />  
         </form>
    </body>
</html>
