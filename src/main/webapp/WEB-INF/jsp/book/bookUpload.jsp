<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<form action="${ctx}/bookFile/upload" method="post" enctype="multipart/form-data">
    <label>书本编号：</label><input type="text" name="id" value="${param.id}" >
    <label>书本图片：</label><input type="file" name="bookFile"/>
    <input type="submit" value="上传图片"/>
</form>
</body>
</html>
