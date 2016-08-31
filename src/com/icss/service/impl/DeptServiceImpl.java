package com.icss.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icss.dao.IDeptDao;
import com.icss.model.Department;
import com.icss.service.IDeptService;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDao deptDao;

	@Override
	public Department getDeptById(Integer deptId) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptById(deptId);
	}
	
	
}
