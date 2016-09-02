package com.icss.dao;

import java.util.List;

import javax.annotation.Resource;

import com.icss.model.Department;

@Resource
public interface IDeptDao {
	public int delDept(int deptpartment_id);
	
	public int addDept(Department dept);
	
	public Department selectDeptById(int deptId);
	
	public List<Department> selectAllDept();
}
