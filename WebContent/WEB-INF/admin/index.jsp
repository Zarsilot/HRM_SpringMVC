<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/menu.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/icon.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css">
	    <script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.tabs.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.parser.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.panel.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.tree.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.form.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.messager.js"></script>
		
	</head>

	<body class="easyui-layout">
	<%
	String name = session.getAttribute("sname").toString();
	%>
	    <div data-options="region:'north',title:'North Title',split:true,noheader:true" style="height:80px;background:#b7fffc;">
	    	
	    	<div>
	    		<span>后台管理系统</span>
	    		<p style="float:right;padding:5px 10px;">欢迎您,<%=name %> ！| <a href="redirect:login" style="text-decoration:none">退出系统</a></p>
	    	</div>
	    	<a href="javascript:void(0)" id="mb" class="easyui-menubutton"     
        		data-options="menu:'#mm'">系统</a>   
			<div id="mm" style="width:150px;">   
			    <div>报工系统</div>   
			    <div>请假系统</div>   
			    <div>报销系统</div>   
			    <div>图表分析</div>  
			    <div class="menu-sep"></div>   
			    <div data-options="iconCls:'icon-remove'">Delete</div>   
			    <div>Select All</div>   
			</div> 
	    </div>   
	    <div data-options="region:'south',title:'South Title',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;background:#62c7c7">
	    	&copy;版权所有
	    </div>   
	    <div data-options="region:'west',title:'菜单栏',split:true" style="width:20%;" dir="ltr">	
				<div class="easyui-accordion" data-options="fit:true,border:false">   
			        <div title="系统参数" style="padding:5px;">   
			           <ul id="sysBox" data-options="url:'<%=path %>/tree.json'">
							
						</ul>
			        </div>   
			        <div title="用户管理" style="padding:5px;" lines="true">   
			            <ul id="funBox" class="easyui-tree">
							<li>
								<span>用户管理</span>
								<ul>
									<li>
										<span>参数一</span>
									</li>
									<li>用户列表</li>
								</ul>
							</li>
							<li>设置管理</li>
						</ul>  
			        </div>   
			        <div title="部门管理" data-options="selected:true" style="padding:5px">   
			            <ul id="deptBox" class="easyui-tree" lines="true">
							<li>
								<span>部门信息</span>
								<ul>
									<li id="sys1">参数一</li>
									<li id="deptList">部门列表</li>
								</ul>
							</li>
						</ul>   
			        </div>   
				</div>
	    </div>   
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    	<div id="tabs">
	    		<div title="起始页" style="padding:0 10px;display:block;text-align:center;">
	    			欢迎访问后台管理系统！
	    		</div>
	    	</div>
	    </div>  
	    
		<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
		<script type="text/javascript" src="<%=path %>/js/easyui-rtl.js"></script>
		<script type="text/javascript" src="<%=path %>/js/admin.js"></script>
	</body>
</html>