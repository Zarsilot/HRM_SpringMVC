package com.icss.controller;
/**
 * 
 * @author wanchao
 * 2016-11-01
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller      //等同于@Component注解
@RequestMapping("/back")    //类级别的请求处理@RequestMapping({"/back", "/backs"})  
public class HomeController{
    //
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
}
