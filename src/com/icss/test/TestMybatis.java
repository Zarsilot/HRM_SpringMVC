package com.icss.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.icss.model.Department;
import com.icss.service.IDeptService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Resource 
	private IDeptService deptService = null;
	
	@Test
	public void test1(){
		Department dept = deptService.getDeptById(203);
		logger.info("***"+dept.getDeptName()+"***"+dept.getLocName());
	}
	
}
