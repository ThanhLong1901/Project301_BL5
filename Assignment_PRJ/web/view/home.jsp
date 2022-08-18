<%-- 
    Document   : home
    Created on : Aug 16, 2022, 10:12:11 PM
    Author     : Long
--%>

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
        <table border="1">
            <tr>
                <th rowspan="2">Nhân Viên</th>
                    <%--List Ngày Trong Tháng--%>
                    <c:forEach items="${dates}" var="d">   
                    <th colspan="3">
                        <fmt:formatDate pattern = "EEE dd-MM" value = "${d.value}"/>
                    </th>
                </c:forEach>
                <th colspan="3">Tổng</th>
                <th rowspan="2">Tổng Số Lượng</th>
                <th rowspan="2">Tổng Lương</th>
            </tr>

            <tr>
                <%--Số Lượng theo List Ngày--%>
                <c:forEach items="${dates}" var="d"> 
                    <%--List Sản Phẩm (Cột ngày)--%>  
                    <c:forEach items="${listP}" var="lp">   
                        <th>${lp.pname}</th>
                        </c:forEach>
                    </c:forEach>
                    <%--List Sản Phẩm (Cột tính tổng)--%>
                    <c:forEach items="${listP}" var="lp">   
                    <th>${lp.pname}</th>
                    </c:forEach>
            </tr>

            <%--List Nhân Viên--%>
            <c:forEach items="${listE}" var="lnv">   
                <tr>
                    <td>${lnv.ename}</td>
                    <%--Số Lượng Cột Theo List Ngày--%>
                    <c:forEach items="${dates}" var="d">   
                        <td>100</td>
                        <td>200</td>
                        <td>310</td>

                        <%--Hiện ra được số được số lượng sản phẩm nhưng chưa đúng ngày--%>
                        <%--<c:forEach items="${lnv.timesheets}" var="ts">
                            <c:forEach items="${listP}" var="lp">
                                <c:if test="${d.value == ts.cidate && ts.p.pid == lp.pid}">
                                    <td>${ts.getAmount()}</td>
                                </c:if>
                            </c:forEach>
                        </c:forEach>--%>

                    </c:forEach> 

                    <%--Tổng số lượng từng loại--%>    
                    <c:forEach items="${listP}" var="lp">
                        <c:set value="${lp.pid}" var="pid"/>
                        <td>${lnv.getSumAmoutProductWorking(pid)}</td>
                    </c:forEach>

                    <%--Tổng tất cả số lượng tất cả các loại--%>     
                    <td>${lnv.getSumAmoutAllProductWorking()}</td>

                    <%--Tổng lương--%>
                    <!--<td>Lương</td>-->
                    <td>${lnv.getSumSalaryWorking()}</td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
