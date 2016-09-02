package com.icss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icss.model.Department;
import com.icss.service.IDeptService;

@Controller
@RequestMapping("/Dept")
public class DeptController {
	@Resource
	private IDeptService deptService;
	
	@RequestMapping("listAll")
	public ModelAndView getAllDept(HttpServletRequest req,ModelAndView view){
		view.setViewName("ListDept");
		List<Department> depts = new ArrayList<>();
		depts=deptService.getAllDept();
		view.addObject("depts", depts);
		return view;
	}
	
	@RequestMapping("addDept")
	public String addDept(HttpServletRequest req){
		
		
		return "";
	}

}
