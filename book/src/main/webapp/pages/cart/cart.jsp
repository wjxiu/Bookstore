<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%>
	<script>
		$(function (){
			// 给输入框绑定 onchange内容发生改变事件
			$(".updatecount").change(function (){
				//获得数量
				count=this.value;
				//获得名字
				let val = $("#bookid").val();
				alert("bookid="+val);
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@ include file="/common/login_succed.jsp"%>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${sessionScope.cart.totalCount>0}">
				<c:forEach items="${sessionScope.cart.items}" var="item">
					<tr>
						<td>${item.name}</td>
					<td ><input class="updatecount" type="text" value="${item.count}" style="width: 50px"></td>
					<td>${item.price}</td>
					<td>${item.totalPrice}</td>
					<td><a href="${pageContext.request.contextPath}/cartservlet?action=deleteItem&id=${item.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.cart.totalCount==0}">
			<td colspan="5">
				<a href="${pageContext.request.contextPath}/index.jsp">购物车没有东西，快去购买吧</a>
			</td>
			</c:if>
		</table>
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<c:if test="${sessionScope.cart.items.size()>0}">
				<span class="cart_span"><a href="${pageContext.request.contextPath}/cartservlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="${pageContext.request.contextPath}/orderservlet?action=createOrder">去结账</a></span>
			</c:if>
		</div>
	
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>