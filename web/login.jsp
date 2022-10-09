<%-- 
    Document   : login
    Created on : 5-Oct-2022, 10:04:37 AM
    Author     : Aster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="post">
        Username: <input type="text" id="username" value="${username}"><br>
        Password: <input type="text" id="password" value="${password}"><br>
        <input type="submit" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
