<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>维信会员登录页面</title>
		<%--静态导入--%>
		<%@ include file="/pages/common/head.jsp"%>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/weixin.png" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box" style="height: 500px">
							<div class="tit">
								<h1>维信书库后台管理系统</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">请输入用户名和密码</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text"
										   autocomplete="off" tabindex="1" name="account"
									value="${cookie.account.value}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
								<div style="color: red;font-size: 20px" class="message">
									${requestScope.get("message")}
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态导入页脚--%>
		<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>