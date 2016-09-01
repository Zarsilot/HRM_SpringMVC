﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>

	<body>
		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>

		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
			<tr>
				<td align="center">
					您已经登陆到XXX人力资源管理系统，请使用
				</td>
			</tr>
		</table>

		<!-- 页面底部 -->
        <jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>