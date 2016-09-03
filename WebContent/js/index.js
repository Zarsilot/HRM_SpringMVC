$(function(){
	$('#tt').tabs({    
	    border:false,    
	    onSelect:function(title){    
	        alert(title+' is selected');    
	    }    
	}); 
});

$.parser.parse();