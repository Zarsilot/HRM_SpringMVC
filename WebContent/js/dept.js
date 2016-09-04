/**
 * 
 */
$(function(){
	$('#dept').datagrid({
//		url:'Dept/listAll.do',
		columns : [[
		    {
		    	field : 'deptId',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },
		    {
		    	field : 'deptName',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },        
		    {
		    	field : 'locName',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },
		]]
	});
})