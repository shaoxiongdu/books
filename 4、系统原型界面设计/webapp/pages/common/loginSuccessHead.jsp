<%--
  Created by IntelliJ IDEA.
  User: 杜少雄
  Date: 2021/10/18
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <a href="admin"><img class="logo_img" alt="" src="static/img/weixin.png" ></a>
    <span class="wel_word">网上书城</span>
    <div>

        <%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
        <c:if test="${not empty sessionScope.loginUser}">
            <span>欢迎<span class="um_span">${sessionScope.loginUser.account}</span>光临维信书城</span>
            <a href="clientServlet?action=index">书城首页</a>
            <a href="pages/cart/cart.jsp">购物车</a>
            <a href="orderServlet?action=showOrdersByUserId">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;&nbsp;
        </c:if>

    </div>
</div>
</body>
</html>
