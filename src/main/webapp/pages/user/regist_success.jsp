<%@ page import="cn.shaoxiongdu.bean.User" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>维信会员注册页面</title>
	<%--静态导入--%>
	<%@ include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/weixin.png" >
				<span class="wel_word"></span>
				<div>
					<span>欢迎<span class="um_span"> ${sessionScope.get("loginUser").account}</span>登录 维信书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="index.html">注销</a>&nbsp;&nbsp;
					<a href="index.html">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.html">转到主页</a></h1>
	
		</div>

		<%--静态导入页脚--%>
		<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>