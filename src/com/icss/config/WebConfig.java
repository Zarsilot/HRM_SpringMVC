package com.icss.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;

/**
 * 基于java启用Spring MVC
 * @author wanchao
 * date 2016-11-01
 */
@Configuration 
@EnableWebMvc    //启用Spring MVC
@ComponentScan(basePackages={"com.icss.controller","com.icss.service"})    //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置JSP视图解析器
	 * 替代方案：在XML中配置<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" 
	 *                              p:prefix="/WEB-INF/back/" p:suffix=".jsp" 
	 *                              p:viewClass="org.springframework.web.servlet.view.JstlView"/>
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/back/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
	/**
	 * 使用Thymeleaf视图模板
	 */
//	@Bean
//	public ViewResolver viewResolver2(){
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		
//	}
	
	/**
	 * 国际化
	 */
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
		
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("file:///etc/messages");
//		messageSource.setCacheSeconds(10);
//		return messageSource;
	}
	
	/**
	 * Spring4.2.6已弃用
	 * @return
	 */
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{
				"/WEB-INF/layout/tiles.xml"
		});
		tiles.setCheckRefresh(true);
		return tiles;
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
