$(function(){
	//登录
	$('#adminname').validatebox({
		required:true,
		missingMessage:'请输入管理员账号',
	});
	
	
	$('#tt').tabs({    
	    border:false,    
	    onSelect:function(title){    
	        alert(title+' is selected');    
	    }    
	}); 
	
	$("#box").tree({
		url:"tree.json",
		lines:true,
	});
});

$.parser.parse();