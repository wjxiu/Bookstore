<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.atguigu.pojo.Page" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单</title>
    <%--	静态包含base标签 jquery,css--%>
    <%@include file="/common/head.jsp"%><style type="text/css">
    h1 {
        text-align: center;
        margin-top: 200px;
    }

    h1 a {
        color:red;
    }

    input {
        text-align: center;
    }
</style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif" >
    <span class="wel_word">编辑图书</span>
    <%--	静态包含图书菜单--%>
    <%@include file="/common/manager_menu.jsp"%>
</div>

<div id="main">
    <form action="${pageContext.request.contextPath}/manager/bookservlet">
        <table>
            <%--					告诉bookservlet这个是添加图书，同时不显示给用户看--%>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <%--						判断添加图书的时候是不是该页面的最后一条，--%>
                <input type="hidden" name="pageNo" value=${param.pageNo}>
                <%--						如果是有参数的就是修改图书，没有参数的是添加图书--%>
                <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
                <input type="hidden" name="id" value="${requestScope.querybook.id}">
                <td><input name="name" type="text" value="${requestScope.querybook.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.querybook.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.querybook.author}"/></td>
                <td><input name="saleds" type="text" value="${requestScope.querybook.saleds}"/></td>
                <td><input name="stock" type="text" value="${requestScope.querybook.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>

        </table>
    </form>


</div>
<%@include file="/common/footer.jsp"%>
</body>
</html>