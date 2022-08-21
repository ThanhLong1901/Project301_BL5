<%-- 
    Document   : salary
    Created on : Aug 19, 2022, 10:39:17 AM
    Author     : Long
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 style="text-align: center">BẢNG TÍNH LƯƠNG</h2>
        <table border="1" width="50%">
            <tr style="background-color: #FF7A00">
                <th>Họ Tên</th>
                <th>Mã Sản Phẩm</th>
                <th>Tên Sản Phẩm</th>
                <th>Giá Đơn</th>
                <th>Số Lượng</th>
                <th>Lương</th>
            </tr>
            <c:forEach items="${listE}" var="listE">
                <c:forEach items="${listP}" var="listP">
                    <tr style="background-color: #F5F5DC">
                        <td style="background-color: #FFD78D">${listE.ename}</td>
                        <td style="text-align: center">${listP.pid}</td>
                        <td>${listP.pname}</td>
                        <td style="text-align: center">${listP.pprice}</td>
                        <td style="text-align: center">${listE.getSumAmoutProductWorking(listP.pid)}</td>
                        <!--<td></td>-->
                        <td style="text-align: center; color: red">
                            <fmt:formatNumber type="number" maxFractionDigits = "3" value="${listE.getSumSalaryProductWorking(listP.pid)}"></fmt:formatNumber>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach> 
        </table>
        <br/><br/>
        <span style="margin-top: 50px">
            <a href="home" 
               style="background-color: #FFD78D; padding: 10px 20px; border-radius: 20px;
               text-decoration: none; color: black"
               >Bản Chấm Công của nhân viên</a>
        </span>
    </body>
</html>
