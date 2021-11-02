<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--静态导入--%>
    <%@ include file="/pages/common/head.jsp" %>
    <style>
        #page_nav {
            margin: 30px auto;
            font-size: 30px;
        }
		#page_nav a{
			color: blue;
		}
		#page_nav span{
			color: red;
		}
        td{
            border: 1px #e3e3e3 solid;
        }
    </style>
</head>
<body>

<%@include file="/pages/manager/managerHead.jsp"%>


<div id="main">
    <table style="font-size: 20px">
        <thead>
        <td align="right">
            <a href="pages/manager/book_edit.jsp">添加图书</a>
        </td>
        </thead>
        <tr>
            <td style="width: 300px" class="title">书籍名称</td>
            <td>封面</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>


        <c:forEach items="${requestScope.page.items}" var="book">
        <tr>
            <td style="width: 200px" class="title">${book.name}</td>
            <td style="height: 50px">
                <img src="${book.imgPath}" style="height: 100%" alt="">
            </td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.sales}</td>
            <td>${book.stock}</td>
            <td><a href="bookServlet?action=edit&id=${book.id}">编辑</a></td>
            <td><a class="deleteClass" href="bookServlet?action=delete&id=${book.id}">删除</a></td>
            </c:forEach>

        </tr>

    </table>

</div>

<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="bookServlet?action=page&pageNo=1">首页</a>&nbsp;
        <a href="bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>&nbsp;
    </c:if>
	【当前第 <span>${requestScope.page.pageNo}</span>页,共<span>${requestScope.page.totalPageNo}</span>页,<span>${requestScope.page.totalCount}</span>条记录】
    <c:if test="${requestScope.page.pageNo < requestScope.page.totalPageNo}">
        <a href="bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>&nbsp;
        <a href="bookServlet?action=page&pageNo=${requestScope.page.totalPageNo}">末页</a>&nbsp;
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

            location.href = "bookServlet?action=page&pageNo=" + pageNo;

        })

    </script>
</div>

<br>


<%--静态导入页脚--%>
<%@ include file="/pages/common/bottom.jsp" %>

<script>

    $(() => {

        $("a.deleteClass").click(function () {
            return confirm("你确定要删除图书【" + $(this).parent().parent().find(".title").text() + "】吗?");

        });

    })

</script>
</body>
</html>