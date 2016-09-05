$(function(){
//	$('#add').click(function(){
////		alert('添加');
//		$('#dlg').dialog('open').dialog('setTitle','新用户');
//		$('#fm').form('clear');
//		url = 'Dept/addDept.do';
//	});
	
	$('#add').click(addDept);
	$('#save').click(saveDept);
	$('#del').click(delOneDept);
	
	function addDept(){
		$('#dlg').dialog('open').dialog('setTitle','新用户');
		$('#fm').form('clear');
		url = 'Dept/addDept.do';
	}
	function saveDept(){
		$('#fm').form('submit',{
			url: 'Dept/addDept.do',
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
//				alert('关闭表单');
				$('#dlg').dialog('close');		// 关闭对话框
				$('#dg').datagrid('reload');	// 重新加载数据
//				var result = eval('('+result+')');
//				alert(result);
//				if (result.errorMsg){
//					$.messager.show({
//						title: 'Error',
//						msg: result.errorMsg
//					});
//				} else {
//					$('#dlg').dialog('close');		// 关闭对话框
//					$('#dg').datagrid('reload');	// 重新加载数据
//				}
			}
		});
	}
	//var row = $('#dg').datagrid('getSelected');
	//if (row){
//		$('#dlg').dialog('open').dialog('setTitle','修改部门');
//		$('#fm').form('load',row);
//		url = 'updDept.do?id='+row.deptId;
	//}
	//
	function delOneDept(){
		var row = $('#dg').datagrid('getSelected');
//		alert(row.deptId);
//		alert(typeof row);
		
		if (row != null){
			$.messager.confirm('提示','你确定要删除该用户吗?',function(r){
				if (r){
					$.post('Dept/delOneDept.do',{deptId:row.deptId},function(result){
						if (result.success){
							$('#dg').datagrid('reload');	// 重新加载数据
						} else {
							$.messager.show({	// 弹出错误
								title: 'Error',
								msg: result.errorMsg
							});
						}
					},'json');
				}
			});
		}
	}
	
});
