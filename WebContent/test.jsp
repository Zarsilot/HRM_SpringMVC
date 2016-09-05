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
<link rel="stylesheet" type="text/css"
	href="<%=path %>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path %>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css">
</head>

<body>
	<ul id="testBox" class="easyui-tree">
		<li><span>系统管理</span>
			<ul>
				<li>配置参数</li>
			</ul></li>
		<li>设置管理</li>
	</ul>
	<div id="dept">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'">添加</a> <a href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'">保存</a> <a id="btn" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
	</div>

	<div>
		<input class="easyui-datetimebox" name="birthday"
			data-options="required:true,showSeconds:false" value="3/4/2010 2:3"
			style="width: 180px">
	</div>
	<div id="pp" class="easyui-pagination"
		data-options="total:2000,pageSize:10"
		style="background: #efefef; border: 1px solid #ccc;"></div>
	<script type="text/javascript">
	$(document).ready(
			function() {
				var title = {
					text : '月平均气温'
				};
				var subtitle = {
					text : 'Source: runoob.com'
				};
				var xAxis = {
					categories : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
							'八月', '九月', '十月', '十一月', '十二月' ]
				};
				var yAxis = {
					title : {
						text : 'Temperature (\xB0C)'
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				};
				var tooltip = {
					valueSuffix : '\xB0C'
				}

				var legend = {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				};

				var series = [
						{
							name : 'Tokyo',
							data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
									26.5, 23.3, 18.3, 13.9, 9.6 ]
						},
						{
							name : 'New York',
							data : [ -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
									24.1, 20.1, 14.1, 8.6, 2.5 ]
						},
						{
							name : 'Berlin',
							data : [ -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6,
									17.9, 14.3, 9.0, 3.9, 1.0 ]
						},
						{
							name : 'London',
							data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0,
									16.6, 14.2, 10.3, 6.6, 4.8 ]
						} ];

				var json = {};

				json.title = title;
				json.subtitle = subtitle;
				json.xAxis = xAxis;
				json.yAxis = yAxis;
				json.tooltip = tooltip;
				json.legend = legend;
				json.series = series;
				$('#container').highcharts(json);
			});
</script>
	<script type="text/javascript"
		src="<%=path %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
	<script type="text/javascript" src="<%=path %>/js/index.js"></script>
</body>
</html>