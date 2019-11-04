<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1><t:message code="title"/> </h1>
<%--${book}
<img src="${pageContext.request.contextPath}/images/1.jpg">
<img src="images/1.jpg">--%>
<div>
    <a href="${ctx}/book/toAdd"><t:message code="add.label"/></a>
    <a href="${ctx}/book/toList"><t:message code="list.label"/></a>
</div>
<div>
    <shiro:hasPermission name="bookmanager:book:edit">
    <a href="${ctx}/book/queryListJSON">查询返回所有数据的JSON</a><br>
    </shiro:hasPermission>
    <a href="${ctx}/book/test">测试</a><br>
    <a href="${ctx}/test/queryTest">测试@RestController</a><br>
    <a href="${ctx}/book/queryListJSON">测试返回的是List&lt;Map&gt;</a><br>
    <a href="${ctx}/book/queryMapJson">测试返回的是Map集合</a><br>
    <a href="${ctx}/book/querySingleBookJson">测试的是单个Book</a><br>
</div>
<div>
    <a href="${ctx}/user/logout">安全退出</a>
</div>
<div>
    <shiro:hasRole name="管理员">
    <a href="${ctx}/changeLocale?locale=zh">中文</a>
    <a href="${ctx}/changeLocale?locale=en">English</a>
    </shiro:hasRole>
</div>
</body>
</html>