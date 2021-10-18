<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<%--静态导入--%>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 50px;
	}
	span{
		color: orange;
	}
</style>
</head>
<body>

<%@include file="/pages/common/loginSuccessHead.jsp"%>

<div id="main">
		
		<h1>你的订单已结算，订单号为 <span> 【${requestScope.order.orderId}】</span></h1>
		<h1>下单时间: <span><fmt:formatDate value="${requestScope.order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></h1>
		<h1>总金额:<span>${requestScope.order.price}</span>&nbsp;当前状态:<span>${requestScope.order.status}</span></h1>

	</div>

	<%--静态导入页脚--%>
	<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>