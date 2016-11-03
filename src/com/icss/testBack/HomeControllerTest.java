package com.icss.testBack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.icss.controller.HomeController;

public class HomeControllerTest {

	//简单测试POJO对象，并没有站在MVC的角度测试返回值home是否是视图的名称
	@Test
	public void test() {
		HomeController controller = new HomeController();
		assertEquals("home", controller.home());
		//fail("Not yet implemented");
	}

	/**
	 * 从Spring3.2开始，Spring包含了一种mock Spring MVC 并针对控制器执行HTTP请求的机制
	 * 执行GET请求，预期得到home.jsp视图
	 * @throws Exception
	 */
	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		//搭建MockMvc
		MockMvc mockMvc = new MockMvcBuilders().standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/back")).andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
