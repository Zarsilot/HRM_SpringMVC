package com.icss.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("assignJob.do")
	public ModelAndView assignJob(HttpServletRequest req, ModelAndView view){
		view.setViewName("assignJob");
		
		return view;
	}
}
