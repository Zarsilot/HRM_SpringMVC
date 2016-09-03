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
<script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
</head>

<body>
	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">   
	    <div title="Tab1" style="padding:20px;display:none;">   
	        tab1    
	    </div>   
	    <div title="Tab2" style="overflow:auto;padding:20px;display:none;">   
	        tab2    
	    </div>   
	    <div title="Tab3" style="padding:20px;display:none;">   
	        tab3    
	    </div>   
	</div>  

</body>
</html>