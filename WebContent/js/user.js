/**
 * 
 */
$(function(){
	$('#user').datagrid({
		url:'listAll',
		columns : [[
		    {
		    	field : 'id',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },
		    {
		    	field : 'id',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },        
		    {
		    	field : 'id',
		    	title : '自动编号',
		    	width : 100,
		    	checkbox : true,
		    },
		]]
	});
})