<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登陆</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/easyui/themes/icon.css">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css"> 
		<script type="text/javascript" src="<%=path %>/easyui/plugins/jquery.validatebox.js"></script>
	</head>
	<body>
	<% 
	Cookie[] cookies = request.getCookies();
	String name = ""; 
	if(cookies != null){
		for(Cookie ck : cookies){
			if(ck.getName().equals("cname")){
				name = ck.getValue();
				break;
			}
		}
	}
	%>
				
				<!-- 
				<tr>
					<td height="24" align="center" bgcolor="#FFFFFF">
						验证码：
					</td>
					<td height="24" bgcolor="#FFFFFF">
						<input id="admincode" name="admincode" type="text" size="8">
						<img id="img" src="ImgCodeMakerServlet" onclick="changeImg()">		
					</td>
				</tr>
				 -->
		
		<form id="loginform" method="post" onsubmit="return checkForm()">   
			<fieldset style="width:260px;height:150px">
				<legend>登录框</legend>
				<label for="name">账号:</label>   
		        <input class="easyui-textbox" name="adminName" data-options="iconCls:'icon-man',required:true" style="width:160px">
		        	${requestScope.sname }
		        </input><br>  
		         <label for="pawd">密码:</label>   
		        <input class="easyui-textbox" name="adminpwd" type="password" data-options="iconCls:'icon-lock',required:true" style="width:160px">
		        	
		        </input> <br>
		         <label for="name">级别:</label>   
		         <input name="adminLevel" type="radio" value="1" style="width:30px">管理员</input>
		         <input name="adminLevel" type="radio" value="2" checked="checked" style="width:30px">用户</input> <br>       
			    <div>
			    	<input type="submit" name="Submit" value="进入系统">
							&nbsp;&nbsp;
					<input type="hidden" name="targetURL" value="">
			    </div>  
			</fieldset>
		</form>  
		
		<script type="text/javascript">
		    function checkForm(){
	    		var formId = document.getElementById("loginform");
	    		formId.action = "<%=path %>/login.do";
	    		return true;
		    }
		    
		    function changeImg(){
		    	var img = document.getElementById("img");
		    	img.src= "<%=path %>/ImgCodeMakerServlet";
		    }
		</script>
		<script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>/easyui/easyloader.js"></script>
	</body>
</html>