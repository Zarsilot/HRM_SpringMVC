package com.icss.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 用来替代传统的web.xml配置方式
 * 只能部署在支持Servlet3.0规范的容器中，如>=Tomcat7.0
 * @author wanchao
 *
 */
public class HRMWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的Bean
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的Bean
		//返回的带有@Configuration注解的类将会用来配置DispatcherServlet创建的应用上下文中的Bean
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		//将DispatcherServlet映射到"/"
		return new String[] {"/"};
	}

}
