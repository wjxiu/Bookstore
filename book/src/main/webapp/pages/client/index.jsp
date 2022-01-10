<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>书城首页</title>
	<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%>
</head>
<body>
<script type="text/javascript">
</script>
<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">网上书城</span>
	<div>
		<c:if test="${empty sessionScope.user.username}">
			<a href="pages/user/login.jsp">登录</a> |
			<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
		</c:if>
		<c:if test="${not empty sessionScope.user.username}">
			<span>欢迎<span class="um_span">${sessionScope.user.username}
			<a href="${pageContext.request.contextPath}/orderservlet?action=myOrders">我的订单</a>
			<a href="userservlet?action=logOut">注销</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/cartservlet?action=cart">购物车</a>
			<a href="pages/manager/manager.jsp">后台管理</a>
		</c:if>

	</div>
</div>
<div id="main">
	<div id="book">
		<div class="book_cond">
			<form action="${pageContext.request.contextPath}/client/bookservlet" method="get">
				<input type="hidden" name="action" value="pageByPrice">
				<input type="hidden" name="pageNo" value="${requestScope.page.pageNo}">
				<input type="hidden" name="pageSize" value="${requestScope.page.pageSize}">
				价格：<input id="min" type="text" name="min" value="${param.min}" > 元 -
				<input id="max" type="text" name="max" value="${param.max}" > 元
				<input type="submit" value="查询" />
			</form>
		</div>
		<div style="text-align: center">
			<c:if test="${sessionScope.cart.totalCount>0}">

			<div>
				<span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
				您刚刚将<span style="color: red">${sessionScope.LastName}</span>加入到了购物车中
			</div>
			</c:if>
			<c:if test="${sessionScope.cart.totalCount==0}">
				<div style="color: red">
					你的购物车里没有东西，快去购买吧
				</div>
			</c:if>

		</div>
		<c:forEach items="${requestScope.page.items}" var="book">
		<div class="b_list">
			<div class="img_div">
				<img class="book_img" alt="" src="${book.img_path}"/>
			</div>
			<div class="book_info">
				<div class="book_name">
					<span class="sp1">书名:</span>
					<span class="sp2">${book.name}</span>
				</div>
				<div class="book_author">
					<span class="sp1">作者:</span>
					<span class="sp2">${book.author}</span>
				</div>
				<div class="book_price">
					<span class="sp1">价格:</span>
					<span class="sp2">${book.price}</span>
				</div>
				<div class="book_sales">
					<span class="sp1">销量:</span>
					<span class="sp2">${book.saleds}</span>
				</div>
				<div class="book_amount">
					<span class="sp1">库存:</span>
					<span class="sp2">${book.stock}</span>
				</div>
				<div class="book_add">
<%--					<button onclick="()">加入购物车</button>--%>
					<form method="post" action="${pageContext.request.contextPath}/cartservlet?action=addItem&id=${book.id}&name=${book.name}&price=${book.price}">
						<input type="submit" value="加入购物车">
					</form>
				</div>

			</div>
		</div>
		</c:forEach>

	</div>
	<%@include file="/common/page_nav.jsp"%>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2022
		</span>
</div>
</body>
</html>