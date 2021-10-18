<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%--静态导入--%>
	<%@ include file="/pages/common/head.jsp"%>
	<style>
		#page_nav {
			font-size: 30px;
			margin: 30px auto;
		}
		#page_nav a{
			color: blue;
		}
		#page_nav span{
			color: red;
		}
	</style>

	<script type="text/javascript">

		$(function (){
			$("button.addToCart").click(function () {

				let bookId = $(this).attr("id");

				location.href = "${requestScope.basePath}cartServlet?action=addItem&bookId=" + bookId;

			});
		})

	</script>
</head>
<body>
<div id="header">

	<%@include file="/pages/common/loginSuccessHead.jsp"%>

</div>

<div style="text-align: center;width: 1200px">
	<c:if test="${empty sessionScope.cart.items}">
		<%--购物车为空的输出--%>
		<span></span>
		<div>
			<span style="color: red">当前购物车为空</span>
		</div>
	</c:if>
	<c:if test="${not empty sessionScope.cart.items}">
		<%--购物车非空的输出--%>
		<span>您的购物车中有【<span style="color: red;font-size: 25px"> ${sessionScope.cart.totalCount}</span>】件商品</span>
		<div>
			您刚刚将【<span style="color: red;font-size: 25px">${sessionScope.lastName}</span>】加入到了购物车中
		</div>
	</c:if>
</div>
	<div id="main">
		<div id="book" style="display: flex;flex-wrap: wrap">
			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list" style="text-align: center">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name" style="margin-top: 10px">
							<h4 class="sp2">${book.name}</h4>
						</div>
						<div class="book_author" style="margin-top: 10px">
							<h4>
								<span class="sp2">${book.author}</span>&nbsp;
								<span class="sp2" style="color: red">${book.price}元</span>&nbsp;
							</h4>

						</div>

						<div class="book_sales" style="margin-top: 10px">
							<h4>
								<span class="sp1">销量:</span>
								<span class="sp2">${book.sales}</span>&nbsp;

							</h4>

						</div>
						<div class="book_sales" style="margin-top: 10px">
							<h4>
								<span class="sp1">库存:</span>
								<span class="sp2">${book.stock}</span>
							</h4>

						</div>

						<div class="book_add" style="width: 150px">
							<button id="${book.id}" class="addToCart" style="margin: 5px 0 0 10px;width: 130px">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

	</div>

<div id="page_nav">
	<c:if test="${requestScope.page.pageNo>1}">
		<a href="clientServlet?action=page&pageNo=1&pageSize=10">首页</a>&nbsp;
		<a href="clientServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>&nbsp;
	</c:if>
	【当前第 <span>${requestScope.page.pageNo}</span>页,共<span>${requestScope.page.totalPageNo}</span>页,<span>${requestScope.page.totalCount}</span>条记录】
	<c:if test="${requestScope.page.pageNo < requestScope.page.totalPageNo}">
		<a href="clientServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>&nbsp;
		<a href="clientServlet?action=page&pageNo=${requestScope.page.totalPageNo}">末页</a>&nbsp;
	</c:if>
	到第<input style="height: 30px;font-size: 20px"
			 value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
	<input id="pn_btn" style="height: 30px;font-size: 20px" type="button" value="确定">
	<script>

		$("#pn_btn").click(()=>{

			let pageNo = $("#pn_input").val();

			if(pageNo < 1 || pageNo > ${requestScope.page.totalPageNo}){
				alert("跳转页码错误，请重试呐！")
				return;
			}

			location.href = "clientServlet?action=page&pageNo=" + pageNo;

		})

	</script>
</div>


	<%--静态导入页脚--%>
	<%@ include file="/pages/common/bottom.jsp"%>
</body>
</html>