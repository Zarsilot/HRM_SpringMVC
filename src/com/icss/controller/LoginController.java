package com.icss.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icss.model.User;
import com.icss.service.IUserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Resource
	private IUserService userService;
	
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest req, ModelAndView view,HttpServletResponse res){
		HttpSession session = req.getSession();   
		
		view.setViewName("index");
		String uname = req.getParameter("adminName");
		String pswd = req.getParameter("adminpwd");
		int alevel = Integer.parseInt(req.getParameter("adminLevel"));
		Cookie cname = new Cookie("cname",uname);
		cname.setMaxAge(60*60*24*7);
		
		res.addCookie(cname);
		
		session.setAttribute("sname", uname);
		session.setAttribute("slevel", alevel);
		User user = this.userService.getUserById(1001);
		if(user.getAdminId() > 0){
//			System.out.println("获取到数据");
		}
		
		return view;
	}
	
	@RequestMapping("login/nav.do")
	public void getSysParam(){
		
		
	}
	
}
