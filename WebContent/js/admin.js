$(function(){
	//对tabs的模式定义
	$('#tabs').tabs({
		fit:true,
		border:false,
		closable:true,  
	});
	/*
	 * 通过导航栏打开窗口
	 */
//	$("#nav").tree({
//		url:'nav.do',
//		lines:true,
//		onLoadSuccess : function(node,data){
//			if(data){
//				$(data).each(function(index,value){
//					if(this.state == 'closed'){}
//					$('#nav').tree('expandAll');
//				});
//			}
//		},
//		onClick : function(node){
//			if(node.url){
//				if($('#tabs').tabs('exists',node.text)){
//					$('#tabs').tabs('select',node.text);
//				}else{
//					$('#tabs').tabs('add',{
//						title:node.text,
//						iconCls:node.iconCls,
//						closeable:true,
//						href:node.url,
//					});
//				}
//				
//			}
//		}
//	});
//	
	/*
	 * 系统参数
	 */
	$('#sysBox').tree({
//		url:'/tree.json',
//		url:'Emp/assignJob.do',
		lines:true,
		data: [{	
					"id":11,
					"text": "系统管理",
					"children": [
						{
							"id":111,
							"text": "工作日历"
						},
						{	
							id:112,
							"text": "程序信息"
						},
					]
				},
				{
					"id":12,
					"text": "系统管理"
				}]
	

	});
	$('#sysBox').tree({
		onClick : function(node){
//			if(node.id == 'deptList'){
//				if($('#tabs').tabs('exists',node.text)){
//					$('#tabs').tabs('select',node.text);
//				}else{
//					$('#tabs').tabs('add',{
//						title:node.text,
//						closeable:true,
//						href:'Dept/listView',
//					});
//				}
//			}else if(node.id == 'sys1'){
//			
//		    }
			
			//用switch替换if-else语句
			switch(node.id){
			case 111:
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
						closable:true,
						href:'Emp/assignJob.do',
					});
				}
			break;
			
			
			}
		}
	});
	//sysBox结束
	var selected = $('#deptBox').tree('getChecked');	
	/*
	 * 部门管理
	 */
	$('#deptBox').tree({
		onClick : function(node){
//			if(node.id == 'deptList'){
//				if($('#tabs').tabs('exists',node.text)){
//					$('#tabs').tabs('select',node.text);
//				}else{
//					$('#tabs').tabs('add',{
//						title:node.text,
//						closeable:true,
//						href:'Dept/listView',
//					});
//				}
//			}else if(node.id == 'sys1'){
//			
//		    }
			
			//用switch替换if-else语句
			switch(node.id){
			case 'deptList':
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
						closable:true,
						href:'Dept/listView',
					});
				}
			break;
			case 'sys1':
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
						closable:true,
						href:'Dept/sys1',
					});
				}
			break;
			case 'empAnalyze':
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
						closable:true,
						href:'Dept/analyze',
					});
				}
			break;
			case '111':
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
						closable:true,
						href:'Emp/assignJob.do',
					});
				}
			break;
			
			
			}
		}
	});
	//depBox结束
	
});