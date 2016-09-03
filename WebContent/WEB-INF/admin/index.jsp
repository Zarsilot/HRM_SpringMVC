<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/icon.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css">
	</head>

	<body class="easyui-layout">
	    <div data-options="region:'north',title:'North Title',split:true,noheader:true" style="height:80px;background:#ccc;">
	    	
	    	<div>
	    		<span>后台管理系统</span>
	    		<p style="float:right;padding:5px 10px;">欢迎您，| <a href="redirect:login" style="text-decoration:none">退出系统</a></p>
	    	</div>
	    </div>   
	    <div data-options="region:'south',title:'South Title',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;">
	    	&copy;版权所有
	    </div>   
	    <div data-options="region:'west',title:'菜单栏',split:true" style="width:20%;" dir="ltr">	
				<div class="easyui-accordion" data-options="fit:true,border:false">   
			        <div title="系统参数" style="padding:5px;">   
			           content1 
			        </div>   
			        <div title="功能管理" data-options="selected:true" style="padding:5px;">   
			            content2   
			        </div>   
			        <div title="用户管理" style="padding:5px">   
			            content3   
			        </div>   
				</div>
	    </div>   
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    	<div id="tabs">
	    		<div title="起始页" style="padding:0 10px;display:block;">
	    			欢迎访问后台管理系统！
	    		</div>
	    	</div>
	    </div>  
	    
	    <script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
		<script type="text/javascript" src="<%=path %>/js/easyui-rtl.js"></script>
		<script type="text/javascript" src="<%=path %>/js/admin.js"></script>
	</body>
</html>