package com.icss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.model.User;
import com.icss.service.IUserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest req, Model model){
		String uname = req.getParameter("adminname");
		String pswd = req.getParameter("adminpwd");
		int alevel = Integer.parseInt(req.getParameter("adminlevel"));
		User user = this.userService.getUserById(1001);
		if(user.getAdminId() > 0){
			System.out.println("获取到数据");
		}
		
		return "index";
	}
	
	@RequestMapping("login/nav.do")
	public void getSysParam(){
		
		
	}
	
}
