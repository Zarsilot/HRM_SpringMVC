<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/icon.css">   
<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css"> 
</head>

<body>
	<ul id="testBox" class="easyui-tree">
		<li>
			<span>系统管理</span>
			<ul>
				<li>配置参数</li>
			</ul>
		</li>
		<li>设置管理</li>
	</ul>
	<ul id="box"></ul>
	
<script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
<script type="text/javascript" src="<%=path %>/js/index.js"></script>
</body>
</html>