<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%--静态导入--%>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 20px;
	}
	.orderInfo{
		text-align: center;
	}
	.orderInfo span,.totalPrice span{
		color: red;
	}
	.totalPrice{
		text-align: right;
		margin-right: 350px;
	}
</style>
</head>
<body>

<%@include file="/pages/common/loginSuccessHead.jsp"%>

<div id="main">
	<div class="orderInfo">
		<h2>订单号： <span> 【${requestScope.order.orderId}】</span></h2>
		<h2>
			下单时间:<span><fmt:formatDate value="${requestScope.order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>&nbsp;&nbsp;
			当前状态:<span>${requestScope.order.status}</span>
		</h2>
	</div>
	<table style="text-align: center">
		<tr>
			<th>书籍编号</th>
			<th style="width: 300px">书籍名称</th>
			<th>数量</th>
			<th>单价</th>
			<th>总价</th>
		</tr>
		<c:forEach items="${requestScope.orderItems}" var="orderItems">
			<tr>
				<td>${orderItems.id}</td>
				<td>《${orderItems.name}》</td>
				<td>${orderItems.count}个</td>
				<td>${orderItems.price}元</td>
				<td>${orderItems.totalPrice}元</td>
			</tr>
		</c:forEach>
	</table>
	<h2 class="totalPrice">总金额:<span>${requestScope.order.price}元</span>&nbsp;</h2>

</div>

	<%--静态导入页脚--%>
	<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>