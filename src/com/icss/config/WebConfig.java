package com.icss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 基于java启用Spring MVC
 * @author wanchao
 * date 2016-11-01
 */
@Configuration 
@EnableWebMvc    //启用Spring MVC
@ComponentScan(basePackages={"com.icss.controller","com.icss.service"})    //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/back/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	//配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//
		super.configureDefaultServletHandling(configurer);
		//将对静态资源的请求转发到Servlet容器中默认的Servlet上
		configurer.enable();
	}

	
}
