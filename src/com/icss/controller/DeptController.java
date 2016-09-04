package com.icss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icss.model.Department;
import com.icss.service.IDeptService;

@Controller
@RequestMapping("/Dept")
public class DeptController {
	@Resource
	private IDeptService deptService;
	
	@RequestMapping("listView")
	public String list(HttpServletRequest req,ModelAndView view){
		view.setViewName("Depts");
		List<Department> depts = new ArrayList<>();
		depts=deptService.getAllDept();
//		System.out.println("进入---");
		return "Depts";
	}
	
	@RequestMapping("listAll.do")
	@ResponseBody
	public Object getAllDept(HttpServletRequest req,ModelAndView view){
//		view.setViewName("Depts");
		List<Department> depts = new ArrayList<>();
		depts=deptService.getAllDept();
		
//		JSONArray json = JSONArray.fromObject(depts);
//		System.out.println("部门---"+json);
//		view.addObject("djson", json);
		return depts;
	}
	
	@RequestMapping("addDept")
	public String addDept(HttpServletRequest req){
		
		
		return "";
	}

}
