<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%--	静态包含base标签 jquery,css--%>
    <%@include file="/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <%@ include file="/common/login_succed.jsp" %>
</div>
<div id="main">
    <table>
        <tr>
            <td>订单编号</td>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
        </tr>
        <c:forEach items="${requestScope.orderdetails}" var="item">
            <tr>
                <td> ${item.orderId}</td>
                <td> ${item.name}</td>
                <td> ${item.count}</td>
                <td> ${item.price}</td>
                <td> ${item.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>