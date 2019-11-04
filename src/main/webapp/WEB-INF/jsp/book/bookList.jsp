<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/js/jquery-3.3.1.js"/>
    <script>
        /*function aa() {
            var bookname=$("#bookname").val()
            var args={"bookname":bookname}
            $.ajax({
                url : "/book/queryBookPager",
                type : "POST",
                async : true,
                contentType : "application/json",
                data :JSON.stringify(args),
                dataType : 'json',
                success : function(data) {
                    // console.log(data)
                    if (data.success === true) {
                        var a="<table  width='100%' border='1'><thead><th>书本编号</th><th>书本名称</th><th>书本价格</th><th>书本类型</th></thead>"
                        for(var i=0;i<data.msg.length;i++){
                            a+="<tr><td>"+data.msg[i].id+"</td><td>"+data.msg[i].bookname+"</td><td>"+data.msg[i].price+"</td><td>"+data.msg[i].booktype+"</td></tr>"
                        }
                         a+="</table>"
                        $("#tab").html(a)
                    }
                }
            });
        }*/

    </script>
</head>
<body>
    <h1>书本列表</h1>
<form action="${ctx}/book/queryBookPager" method="post">
    <label>书本名称：</label><input type="text" name="bookname"/>
    <input type="submit" value="查询">
</form>
    <%--<label>书本名称：</label><input type="text" name="bookname" id="bookname"/>
    <input type="button" value="查询" onclick="aa()">
    <div id="tab"></div>--%>
<table width="100%" border="1">
        <thead>
        <th>书本编号</th>
        <th>书本名称</th>
        <th>书本图片</th>
        <th>书本价格</th>
        <th>书本类型</th>
        <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookname}</td>
                <td>
                <c:if test="${empty book.bookimage}">
                    暂无图片
                </c:if>
                <c:if test="${not empty book.bookimage}">
                    <img src="${ctx}/bookFile/download?fileId=${book.bookimage}" width="50px" height="50px">
                </c:if>
                </td>
                <td>${book.price}</td>
                <td>${book.booktype}</td>
                <td><a href="${ctx}/book/toBookFile?id=${book.id}">上传图片</a>
                 <a href="${ctx}/bookFile/download?fileId=${book.bookimage}">下载图片</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
${pageBean}
</body>
</html>
