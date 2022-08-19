<%-- 
    Document   : demo
    Created on : Aug 16, 2022, 11:31:00 AM
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
        <h2 style="text-align: center">BẢNG CHẤM CÔNG</h2>
        <table border="1">
            <tr>    
                <th rowspan="3">STT</th>
                <th rowspan="3">Họ tên</th>

                <%--colspan = số lượng cột loại ngày trong tháng--%>
                <th colspan="31">Ngày Trong Tháng</th>  
                <th rowspan="3">Tổng Cộng</th>

                <%--colspan = số lượng cột loại nghỉ phép--%>
                <th colspan="${sizeDOT}" rowspan="2">Ngày nghỉ</th>
            </tr>

            <tr>
                <%--Cột Ngày Trong Tháng Hàng Thứ--%>
                <c:forEach items="${dates}" var="dates">
                    <th>
                        <fmt:formatDate pattern = "EEE" value = "${dates.value}" /> <br/>
                    </th>
                </c:forEach>
            </tr>
            <tr>
                <%--Cột Ngày Trong Tháng Hàng Ngày--%>
                <c:forEach items="${dates}" var="dates">
                    <th>
                        <fmt:formatDate pattern = "dd" value = "${dates.value}" /> <br/>
                    </th>
                </c:forEach>

                <%--Cột Ngày Nghỉ--%>
                <c:forEach items="${listDOT}" var="listDOT">
                    <th>${listDOT.dotnotation}</th> 
                    </c:forEach>

            </tr>

            <%--<c:forEach begin="1" end="5">--%>
            <c:forEach items="${listE}" var="listE">
                <tr>
                    <%--Cột TT--%>
                    <td style="text-align: center">${listE.eid}</td>

                    <%--Cột Tên--%>
                    <td>${listE.ename}</td>

                    <%--Cột Ngày--%>
                    <c:forEach items="${dates}" var="dates">
                        <td>
                            <c:forEach items="${listE.timesheets}" var="lts">
                                <c:if test="${dates.value eq lts.cidate}">
                                    L
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                    <td style="text-align: center">${listE.getAllDayWorking()}</td>

                    <%--Cột Ngày Nghỉ--%>
                    <c:forEach items="${listDOT}" var="listDOT">
                        <th>A</th>
                    </c:forEach>

                </tr>
            </c:forEach>

            <%--</c:forEach>--%>
        </table>

        <br/><br/><br/>     
        <span style="font-weight: bold">Ký Hiệu Chấm Công</span>        
        <table border="1px" width="15%" style="margin-top: 10px">
            <c:forEach items="${listDOT}" var="listDOT">
                <tr>
                    <td width="80%">${listDOT.dottitle}</td>
                    <td width="20%" style="text-align: center">${listDOT.dotnotation}</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
