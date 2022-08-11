<%-- 
    Document   : list
    Created on : Aug 11, 2022, 10:39:01 AM
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
        <h1>List Request</h1>
        <table>
            <tr>
                <th>RequestID</th>
                <th>Content</th>
                <th>FromDate</th>
                <th>ToDate</th>
                <th>CreatedBy</th>
            </tr>
            <c:forEach items="${listRequest}" var="listR">
                <tr>
                    <td>${listR.id}</td>
                    <td>${listR.content}</td>
                    <td>${listR.fromDate}</td>
                    <td>${listR.toDate}</td>
                    <td>${listR.createdBy.username}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
