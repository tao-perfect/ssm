<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <h1>添加书本</h1>
<f:form action="${ctx}/book/addBook" method="post" modelAttribute="book"><f:errors path="id" cssClass="errors"/>
    <label>书本名称</label><f:input path="bookname"/><f:errors path="bookname" cssClass="errors"/><br>
    <label>书本价格</label><f:input path="price"/><f:errors path="price" cssClass="errors"/><br>
    <label>书本类型</label>
    <f:select path="booktype">
        <f:option value="">---请选择---</f:option>
        <f:options items="${btype}" itemLabel="name" itemValue="id"/>
    </f:select><br>
    <input type="submit" value="提交">
</f:form>
</body>
</html>
