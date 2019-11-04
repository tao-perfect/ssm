<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>用户登录</h1>
${message}
<form action="${ctx}/user/userLogin" method="post">
    <label>用户账号：</label><input type="text" name="username"><br>
    <label>用户密码：</label><input type="text" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
