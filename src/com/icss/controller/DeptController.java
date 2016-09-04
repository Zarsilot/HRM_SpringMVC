package com.icss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icss.model.Department;
import com.icss.service.IDeptService;

import net.sf.json.JSONArray;

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
	
	@RequestMapping("addDept.do")
	public String addDept(HttpServletRequest req){
//		System.out.println("添加用户页面");
		int deptId = Integer.parseInt(req.getParameter("deptId"));
		String deptName = req.getParameter("deptName");
		String locName = req.getParameter("locName");
		Department dept = new Department(deptId, deptName, locName);
		deptService.addDept(dept);
		
		return "success";
	}
	
	@RequestMapping(value="delOneDept.do",method=RequestMethod.POST)
	@ResponseBody
	public Object delOneDept(HttpServletRequest req){
		Integer deptId =  Integer.parseInt(req.getParameter("deptId"));
		System.out.println("进入删除");
		System.out.println(deptId);
		deptService.delOneDept(deptId);
		Map<String, Object> result = new HashMap<>();
		result.put("success", "true");
		return result;
	}

}
