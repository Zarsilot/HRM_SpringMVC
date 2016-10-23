package com.icss.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icss.model.Department;
import com.icss.model.User;
import com.icss.service.IDeptService;
import com.icss.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Resource 
	private IDeptService deptService = null;
	@Resource
	private IUserService userService = null;
	
	@Test
	public void test1(){
		Department dept = deptService.getDeptById(203);
		logger.info("***"+dept.getDeptName()+"***"+dept.getLocName());
	}
	
	@Test
	public void test2(){
		User user = userService.getUserById(1001);
		logger.info("***"+ user.getAdminname() +"***"+ user.getAdminlevel());
	}
	
	@Test
	public void testSession(){
//		Department dept1 = deptService.getDeptById(203);
//		logger.debug(dept1);
//		Department dept2 = deptService.getDeptById(203);
//		logger.debug(dept2);
		
//		SqlSessionFactory sqlSessionFactory = get;	
		
//		SqlSession sqlSession = sqlsessionFactory.openSession();

	}
	
}
