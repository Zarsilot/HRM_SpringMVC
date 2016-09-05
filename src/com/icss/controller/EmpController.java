package com.icss.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.model.EmpData;
import com.icss.service.IEmpDataService;
@Controller
@RequestMapping("/Emp")
public class EmpController {
	@Resource
	private IEmpDataService empDataService;

	@RequestMapping("analyzeEmp.do")
	@ResponseBody
	public Object getEmpData(){
		List<EmpData> result = empDataService.getAnalyzeData();
		
		return result;
	}
}
