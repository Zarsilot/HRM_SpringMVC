$(function(){
	$('#tabs').tabs({
		fit:true,
		border:false,
		closeable:true,
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
	
	var selected = $('#deptBox').tree('getChecked');	
	$('#deptBox').tree({
//		url:'Depts.jsp',
//		onClick:function(node){
//			alert(node.text);
//		}
		onClick : function(node){
			if(node){
				if($('#tabs').tabs('exists',node.text)){
					$('#tabs').tabs('select',node.text);
				}else{
					$('#tabs').tabs('add',{
						title:node.text,
//						iconCls:node.iconCls,
						closeable:true,
						href:'Dept/listView',
					});
				}
			}
		}
	});
	
	
});