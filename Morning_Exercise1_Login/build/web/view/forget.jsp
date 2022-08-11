<%-- 
    Document   : forget
    Created on : Aug 10, 2022, 11:04:35 PM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Forget</h1>
        <h3>${requestScope.error}</h3>
        <form action="forget" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td>
                        <input type="text" placeholder="Please enter Username" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>Question:</td>
                    <td>
                        <select name="qid">
                            <option>What is questions?</option>
                            <c:forEach items="${questions}" var="q">
                                <option value="${q.id}">${q.content}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Answer:</td>
                    <td>
                        <input type="text" placeholder="Please enter Answer" name="answer"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Submit" /> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
