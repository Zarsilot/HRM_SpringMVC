package com.icss.service;

import java.util.List;

import com.icss.model.Department;
/*
 * 
 * modify 2016-09-02
 */
public interface IDeptService {
	public Department getDeptById(Integer deptId);
	
	public List<Department> getAllDept();
	
	public int addDept(Department dept);
	
	public int delOneDept(Integer deptId);
}
