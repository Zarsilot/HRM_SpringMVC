$(function() {
	//	var chart1 = new Highcharts.Chart({
	//	    chart: {
	//	        renderTo: "container",
	//	        plotBackgroundColor: null,
	//	        plotBorderWidth: null,
	//	        plotShadow: false,
	//	    },
	//	    title: {
	//	        text: '集团分子公司人员组成'
	//	    },
	//	    tooltip: {
	//	        pointFormat: '{series.name}: <b>{point.y}</b>'
	//	    },
	//	    plotOptions: {
	//	        pie: {
	//	            allowPointSelect: true,
	//	            cursor: 'pointer',
	//	            dataLabels: {
	//	                enabled: true,
	//	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	//	                style: {
	//	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	//	                }
	//
	//	            },
	//	            //showInLegend: true
	//	        }
	//	    },
	//	    series: [{
	//	        type: 'pie',
	//	        name: 'EmpAnalyze',
	//	        data: []
	//	    }]
	//	});

	var chart = {
		renderTo : "container",
		plotBackgroundColor : null,
		plotBorderWidth : null,
		plotShadow : false,
	};
	var title = {
		text : '员工分析'
	};
	var tooltip = {
		pointFormat : '{series.name}: <b>{point.y}</b>'
	};
	var plotOptions = {
		pie : {
			allowPointSelect : true,
			cursor : 'pointer',
			dataLabels : {
				enabled : true,
				format : '<b>{point.name}</b>: {point.percentage:.1f} %',
				style : {
					color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
							|| 'black'
				}

			},
		//showInLegend: true
		}
	};
	var series = [ {
		type : 'pie',
		name : 'EmpAnalyze',
		data : [
		//					['Opera',    45.6],
		//					['Others',   54.4]
		]
	} ];

	/*
	 * 通过Ajax获取图表1数据
	 * 通过这块儿了解到自己对JSON和JS数组转换之间的问题
	 * JSON格式：
	 * JS二维数组格式：
	 */
	$.ajaxSettings.async = false;
	var data1 = [];
	$.getJSON("Emp/analyzeEmp.do", function(dict) {
		//alert("获取到数据");
//		alert(dict[0]);
		$.each(dict, function(i, item) {
//            alert(item.name);
//            alert(item.percent);
			var dd = new Array(item.name,item.percent);
            data1[i]=dd;
        });
		series[0].data = data1;
	});
	var json = {};
	json.chart = chart;
	json.title = title;
	json.tooltip = tooltip;
	json.series = series;
	json.plotOptions = plotOptions;

	$('#container').highcharts(json);

});
