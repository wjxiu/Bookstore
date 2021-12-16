<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
		<%--	静态包含图书菜单--%>
		<%@include file="/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>货物状态</td>
			</tr>
			<c:forEach items="${requestScope.orders}" var="item">
				<tr>
					<td>${item.orderId}</td>
					<td> ${item.createTime}</td>
					<td> ${item.price}</td>
					<td><a href="${pageContext.request.contextPath}/orderservlet?action=orderDetails&orderid=${item.orderId}">查看详情</a></td>
					<C:if test="${item.status.status==0}">
						<td>未发货</td>
						<td><a href="${pageContext.request.contextPath}/orderservlet?action=sendOrder&orderid=${item.orderId}">点击发货</a></td>
					</C:if>
					<C:if test="${item.status.status==1}">
						<td>已发货</td>
						<td><a href="${pageContext.request.contextPath}/orderservlet?action=receiveOrder&orderid=${item.orderId}">点击收货</a></td>
					</C:if>
					<C:if test="${item.status.status==2}">
						<td>用户已签收</td>
					</C:if>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="/common/footer.jsp"%>
</body>
</html>