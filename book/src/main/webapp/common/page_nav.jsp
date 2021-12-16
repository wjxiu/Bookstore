<%--
  Created by IntelliJ IDEA.
  User: xiu
  Date: 2021/11/18
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--			如果是不是第一页才显示首页和上一页--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${pageContext.request.contextPath}${requestScope.page.url}&pageNo=1&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">首页</a>
        <a href="${pageContext.request.contextPath}${requestScope.page.url}&
			pageNo=${requestScope.page.pageNo-1}&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">上一页</a>
        <a href="${pageContext.request.contextPath}${requestScope.page.url}&
			pageNo=${requestScope.page.pageNo-1}&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">${requestScope.page.pageNo-1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <%--		如果不是最后一页就显示下一页和尾页--%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${pageContext.request.contextPath}${requestScope.page.url}&
			pageNo=${requestScope.page.pageNo+1}&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">${requestScope.page.pageNo+1}</a>
        <a href="${pageContext.request.contextPath}${requestScope.page.url}&
			pageNo=${requestScope.page.pageNo+1}&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">下一页</a>
        <a  href="${pageContext.request.contextPath}${requestScope.page.url}&
			pageNo=${requestScope.page.pageTotal}&min=${empty param.min? "":param.min}&max=${empty param.max? "":param.max}">末页</a>

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
                    location.href="${pageContext.request.contextPath}${requestScope.page.url}&pageNo="+val;
                }
            });
        });
    </script>
</div>
