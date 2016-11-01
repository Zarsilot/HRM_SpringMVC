package com.icss.config;
/**
 * 
 * @author wanchao
 * 2016-11-01
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
		basePackages={""},
		excludeFilters={
			@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)	
		}
	)
public class RootConfig {

}
