<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>部门信息</title>

</head>
<body>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" noClick="addDept()">添加</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> 
		<input type="text" name="searchDept"/> 
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a> 
		<label>起始日期：</label>
		<input class="easyui-datetimebox" name="startDate" 
		data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">  
		<label>截止日期：</label>
		<input class="easyui-datetimebox" name="deadDate" 
		data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">
	</div>	

	<div id="dept">
		<table id="dg" title="部门列表" class="easyui-datagrid"
			url="Dept/listAll.do"
			toolbar="#toolbar"
			rownumbers="true" fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<th field="deptId" width="50">部门编号</th>
					<th field="deptName" width="50">部门名称</th>
					<th field="locName" width="50">地址</th>
				</tr>
			</thead>
		</table>
	</div>
	<!--  <div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10" style="background:#efefef;border:1px solid #ccc;"></div> 
	-->
	<!-- <script type="text/javascript" src="<%=path %>/js/dept.js"></script> -->
	<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.window.js"></script>
	
</body>
</html>