<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--给client的index进行显示，这里只负责跳转--%>
<%
	request.getRequestDispatcher("/client/bookservlet?action=page").forward(request, response);
%>