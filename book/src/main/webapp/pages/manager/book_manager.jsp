<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.atguigu.pojo.Page" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%></head>
<body>
<script>
	$(function (){
		$("a.deleteClass").click(function (){
			return confirm("确定删除这本图书吗?");
		})
	})
</script>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%--	静态包含图书菜单--%>
		<%@include file="/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
			<td>书名</td>
			<td>价格</td>
			<td>作者</td>
			<td>销量</td>
			<td>库存</td>
			</tr>
			<c:forEach  items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.saleds}</td>
				<td>${book.stock}</td>
				<td><a href="${pageContext.request.contextPath}/manager/bookservlet?action=getbook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a class="deleteClass" href="${pageContext.request.contextPath}/manager/bookservlet?action=delete&id=${book.id}&pageNo=${requestScope.page.items.size()==1? requestScope.page.pageNo-1:requestScope.page.pageNo}">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<%--						判断添加图书的时候是不是该页面的最后一条，是就页面加1--%>
				<td><a href="pages/manager/book_edit.jsp?action=add&pageNo=
				${requestScope.page.pageTotalCount%requestScope.page.pageSize>0?requestScope.page.pageNo:requestScope.page.pageNo+1 }">添加图书</a></td>
			</tr>
		</table>
		<div id="page_nav">
<%--			如果是不是第一页才显示首页和上一页--%>
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="${pageContext.request.contextPath}/manager/bookservlet?action=page&pageNo=1">首页</a>
				<a href="${pageContext.request.contextPath}/manager/bookservlet?action=page&
			pageNo=${requestScope.page.pageNo-1}">上一页</a>
				<a href="${pageContext.request.contextPath}/manager/bookservlet?action=page&
			pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
			</c:if>
			【${requestScope.page.pageNo}】
<%--		如果不是最后一页就显示下一页和尾页--%>
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="${pageContext.request.contextPath}/manager/bookservlet?action=page&
			pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>
				<a href="${pageContext.request.contextPath}/manager/bookservlet?action=page&
			pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a  href="${pageContext.request.contextPath}/manager/bookservlet?action=page&
			pageNo=${requestScope.page.pageTotal}">末页</a>

			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
			到第<input  value=${requestScope.page.pageNo} name="pn" id="pn_input"/>页
			<input id="searchpage" type="button" value="确定">
			<script type="text/javascript">
				$(function (){
					$("#searchpage").click(function (){
						let val = $("#pn_input").val();
						if (val<1||val>${requestScope.page.pageTotal}){
								// js有个对象是location地址栏，location的属性href是地址栏的地址
							alert("页码非法")
						}else{
							location.href="${pageContext.request.contextPath}/manager/bookservlet?action=page&pageNo="+val;
						}
					});
				});
			</script>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>