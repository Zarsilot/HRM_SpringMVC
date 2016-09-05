<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据分析</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.1.0.js"></script>
<script type="text/javascript" src="<%=path%>/js/highcharts.js"></script>

</head>
<body>
	<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
	<script type="text/javascript" src="<%=path%>/js/analyze.js"></script>
</body>
</html>