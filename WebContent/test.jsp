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
	<div id="dept">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
	</div>
	
	<div>
		<input class="easyui-datetimebox" name="birthday"     
        data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:180px">  
	</div>
	<div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10" style="background:#efefef;border:1px solid #ccc;"></div> 
<script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
<script type="text/javascript" src="<%=path %>/js/index.js"></script>
</body>
</html>