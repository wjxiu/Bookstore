<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%--	静态包含base标签 jquery,css--%>
	<%@include file="/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script src="static/jquery-1.7.2.js"></script>
	<script>
		$(function () {
			$("#sub_btn").click(function () {
				// 验证用户名
				let val = $("#username").val();
				var regex=/^\w{5,12}$/
				let b = regex.test(val);
				if (!b){
					$("span.errorMsg").text("用户名不合法");
					return b;
				}

				let pass = $("#password").val();
				var regex=/^\w{5,12}$/
				// 验证密码
				let test = regex.test(pass);
				if (!test){
					$("span.errorMsg").text("密码不合法");
					return false;
				}
				//验证确认密码
				let val1 = $("#repwd").val();
				if (val1!=pass){
					$("span.errorMsg").text("两次密码不一样");
					return false;
				}
				//验证邮箱
				let email = $("#email").val();
				var emailregex=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
				if (!emailregex.test(email)){
					$("span.errorMsg").text("邮箱不合法");
					return false;
				}
				let code = $("#code").val();
				code=$.trim(code);
				if (code ==null||code==""){
					$("span.errorMsg").text("验证码不能为空");
					return false;
				}

				$("span.errorMsg").text("");
			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("mes")==null?"请输入用户和密码":request.getAttribute("mes")%>--%>
									${empty requestScope.mes?"":requestScope.mes}
								</span>
							</div>
							<div class="form">
								<form action="userservlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
										   value="${requestScope.password}"
									/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 75px;"name="code" id="code"
									value="${requestScope.code}"
									/>
									<a href="javascript:document.location.reload(true);" title="" target="_self" >
										<img  src="${pageContext.request.contextPath}/kaptcha.jpg" style="float: right; width: 150px; height: 30px; margin-right: 40px">
									</a>

									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/common/footer.jsp"%>
</body>
</html>