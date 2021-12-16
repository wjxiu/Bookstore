<%--
  Created by IntelliJ IDEA.
  User: xiu
  Date: 2021/10/25
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="${pageContext.request.contextPath}/orderservlet?action=myOrders">我的订单</a>
    <a href="userservlet?action=logOut">注销</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/index.jsp">返回</a>

</div>
</body>
</html>
