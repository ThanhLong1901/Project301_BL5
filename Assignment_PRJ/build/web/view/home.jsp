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
        <table border="1" style="background-color: beige    ">
            <tr>    
                <th rowspan="3" style="background-color: #FF7A00">STT</th>
                <th rowspan="3" style="background-color: #FF7A00">Họ Tên</th>

                <%--colspan = số lượng cột loại ngày trong tháng--%>
                <th colspan="31" style="background-color: #FF7A00">Ngày Trong Tháng</th>  
                <th rowspan="3" style="background-color: #FF7A00">Tổng Cộng</th>

                <%--colspan = số lượng cột loại nghỉ phép--%>
                <th colspan="3" rowspan="2" style="background-color: #FF7A00">Ngày Nghỉ</th>
            </tr>

            <tr>
                <%--Cột Ngày Trong Tháng Hàng Thứ--%>
                <c:forEach items="${dates}" var="dates">
                    <th style="background-color: orange">
                        <fmt:formatDate pattern = "EEE" value = "${dates.value}" /> <br/>
                    </th>
                </c:forEach>
            </tr>
            <tr>
                <%--Cột Ngày Trong Tháng Hàng Ngày--%>
                <c:forEach items="${dates}" var="dates">
                    <th style="background-color: #FFD78D">
                        <fmt:formatDate pattern = "dd" value = "${dates.value}" /> <br/>
                    </th>
                </c:forEach>

                <%--Cột Ngày Nghỉ--%>
                <%--<c:forEach items="${listDOT}" var="listDOT" begin="1">--%>
                <th style="background-color: #FFD78D">Nghỉ Không Lương</th> 
                <th style="background-color: #FFD78D">Nghỉ Lễ</th> 
                <th style="background-color: #FFD78D">Nghỉ Phép</th> 
                    <%--</c:forEach>--%>

            </tr>

            <%--<c:forEach begin="1" end="5">--%>
            <c:forEach items="${listE}" var="listE">
                <tr>
                    <%--Cột TT--%>
                    <td style="text-align: center;background-color: orange">${listE.eid}</td>

                    <%--Cột Tên--%>
                    <td style="background-color: #FFD78D">${listE.ename}</td>

                    <%--Cột Ngày--%>
                    <c:forEach items="${dates}" var="dates">
                        <td 
                            <c:if test="${dates.dow eq 1 or dates.dow eq 7}">
                                style="background-color: #F8CBAD" 
                            </c:if>
                            style="text-align: center"
                            >
                            <c:forEach items="${listE.timesheets}" var="lts">
                                <c:if test="${dates.value eq lts.cidate}">
                                    <a style="color: #56B600">L</a>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${listE.dayoff}" var="lrs">
                                <c:if test="${dates.value >= lrs.fromdate and dates.value <= lrs.todate}">
                                    <c:choose>
                                        <c:when test="${lrs.dot.dotid == 2 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">Ô</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 3 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">CÔ</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 4 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">TS</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 5 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">T</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 6 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">CN</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 7 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">NL</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 8 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">NB</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 9 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">P</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 10 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">1/2K</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 11 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">K</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 12 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">N</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 13 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">1/2P</a>
                                        </c:when>
                                        <c:when test="${lrs.dot.dotid == 14 and lrs.e.eid == listE.eid}">
                                            <a style="color: red">N</a>
                                        </c:when>
                                    </c:choose> 
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>

                    <%--Cột Tổng Ngày Đi Làm--%>    
                    <td style="text-align: center">${listE.getAllDayWorking()}</td>

                    <%--Cột Ngày Nghỉ--%>
                    <%--<c:forEach items="${listDOT}" var="listDOT" begin="1">--%>
                    <td style="text-align: center">${listE.getSumDayOff(11)}</td>
                    <td style="text-align: center">${listE.getSumDayOff(7)}</td>
                    <td style="text-align: center">${listE.getSumDayOff(9)}</td>
                    <%--</c:forEach>--%>
                </tr>
            </c:forEach>

            <%--</c:forEach>--%>
        </table>

        <br/><br/><br/>     
        <span style="font-weight: bold">Ký Hiệu Chấm Công</span>        
        <table border="1px" width="20%" style="margin-top: 10px">
            <c:forEach items="${listDOT}" var="listDOT">
                <tr>
                    <td width="80%" style="background-color: orange">${listDOT.dottitle}</td>
                    <td width="20%" style="text-align: center; background-color: #FFD78D">${listDOT.dotnotation}</td>
                </tr>
            </c:forEach>
        </table>
        <br/><br/>
        <span style="margin-top: 50px">
            <a href="salary" 
               style="background-color: #FFD78D; padding: 10px 20px; border-radius: 20px;
               text-decoration: none; color: black"
               >Bảng Lương Tháng của nhân viên</a>
        </span>
    </body>
</html>
