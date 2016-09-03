$(function(){
	$("#tabs").tabs({
		fit: true,
		border:false,
	});
	
	$("#nav").tree({
		url:'nav.do',
		lines:true,
	});
});