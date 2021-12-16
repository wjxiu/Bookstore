<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%>
	<%@include file="/common/login_succed.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
	</div>
	<div id="main">
		
		<table>
			<tr>
				<td>订单编号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<C:forEach items="${sessionScope.myorders}" var="mymap">
				<tr>
					<td>${mymap.value.orderId}</td>
					<td>${mymap.value.createTime}</td>
					<td>${mymap.value.price}</td>
					<C:choose>
<%--						这里mymap.value.status.status 最后的status是getStatus()方法，只是这里省略了--%>
						<C:when test="${mymap.value.status.status==0}">
						<td>未发货</td>
						</C:when>
						<C:when test="${mymap.value.status.status==1}">
						<td>已发货</td>
						</C:when>
						<C:when test="${mymap.value.status.status==2}">
						<td>已签收</td>
						</C:when>
						<C:otherwise>
							<td>状态异常，请联系客服</td>
						</C:otherwise>
					</C:choose>
					<td><a href="${pageContext.request.contextPath}/orderservlet?action=orderDetails&orderid=${mymap.value.orderId}">查看详情</a></td>
				</tr>
			</C:forEach>

		</table>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>