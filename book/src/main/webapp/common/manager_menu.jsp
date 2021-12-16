<%--
  Created by IntelliJ IDEA.
  User: xiu
  Date: 2021/10/25
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <%@include file="/common/head.jsp"%>--%>
    <title>Title</title>
</head>
<body>
    <div>
        <a href="manager/bookservlet?action=page&pageNo=1">图书管理</a>
        <a href="${pageContext.request.contextPath}/orderservlet?action=allOrders">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</body>
</html>
