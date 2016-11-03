<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HRM后台管理</title>
</head>
<body>
	<h1>欢迎管理员！</h1>
	<h2><s:message code="hrm.welcome"></s:message></h2>
	
	<!-- spring的JSP标签，模型中必须添加一个key为Employee的对象，需要在controller的Model中注册 -->
	<form:form method="POST" cammandName="Employee">
		<form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error" />
		<form:password path="pswd"/>
		<input type="submit" value="提交">
	</form:form>
</body>
</html>