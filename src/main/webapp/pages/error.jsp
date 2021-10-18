<%--
  Created by IntelliJ IDEA.
  User: 杜少雄
  Date: 2021/10/15
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
    <%--静态导入--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style>
        div{
            text-align: center;
        }
        h2{
            color: red;
        }
    </style>
</head>
<body>
<div>
    <h2>
        ${requestScope.get("title")}
    </h2>
        <h5>
            ${requestScope.get("message")}
        </h5>

</div>

</body>
</html>
