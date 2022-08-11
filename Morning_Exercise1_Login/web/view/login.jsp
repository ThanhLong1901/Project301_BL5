<%-- 
    Document   : login
    Created on : Aug 10, 2022, 10:05:30 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Login</h1>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td>
                        <input type="text" placeholder="Please enter Username" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type="password" placeholder="Please enter Password" name="password"/>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <a href="forget">Forget password?</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
