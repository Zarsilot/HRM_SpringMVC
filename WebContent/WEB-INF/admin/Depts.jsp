<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/dialog.css">   
	<script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
</head>
<body>
	<!-- onclick="javascript:addDept()" -->
	<div>
		<a id="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
		<a id="del" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		<a id="mod" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a> 
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
	<!-- 新增部门对话框  -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<div class="ftitle">部门信息</div><hr>
		<form id="fm" method="post">
			<div class="fitem">
				<label>部门编号:</label>
				<input name="deptId" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>部门名称:</label>
				<input name="deptName" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>部门地址:</label>
				<input name="locName">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a id="save" href="#" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	<!--  <div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10" style="background:#efefef;border:1px solid #ccc;"></div> 
	-->
	<script type="text/javascript" src="<%=path %>/js/dept.js"></script>
	
</body>
</html>