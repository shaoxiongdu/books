<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态导入--%>
	<%@  include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function (){
			$("button.deleteBtn").click(function () {

				let bookId = $(this).attr("bookId");

				location.href = "${requestScope.basePath}cartServlet?action=deleteItem&bookId=" + bookId;

			});
		})

	</script>
</head>
<body>

<%@include file="/pages/common/loginSuccessHead.jsp"%>

<div id="main">

	<form action="orderServlet?action=createOrder">
		<table>
			<tr>
				<th>商品名称</th>
				<th>数量</th>
				<th>单价</th>
				<th>金额</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="cartItem">
				<tr>
					<td>${cartItem.value.name}</td>
					<td>${cartItem.value.count}</td>
					<td>${cartItem.value.price}</td>
					<td>${cartItem.value.totalPrice}</td>
					<td> <button class="deleteBtn" bookId="${cartItem.value.id}">删除</button> </td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>

	</form>
	
	</div>

	<%--静态导入页脚--%>
	<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>