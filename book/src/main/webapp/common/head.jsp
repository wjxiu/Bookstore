<%--
  Created by IntelliJ IDEA.
  User: xiu
  Date: 2021/10/25
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String path=request.getScheme()+
            "://" +request.getServerName()+
            ":"+
            request.getServerPort()+
            request.getContextPath()+"/";
%>
<base href=<%=path%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/jquery-1.7.2.js"></script>
</body>
</html>
