<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息</title>
</head>
<body>
	<div id="dept">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a> 
	</div>	
	<div>
		<input class="easyui-datetimebox" name="birthday"     
        data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">  
	</div>
	
	<div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10" style="background:#efefef;border:1px solid #ccc;"></div> 
</body>
</html>