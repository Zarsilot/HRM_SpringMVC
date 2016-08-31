package com.icss.dao;

import com.icss.model.Department;

public interface IDeptDao {
	public int delDept(int deptpartment_id);
	
	public int addDept(Department dept);
	
	public Department selectDeptById(int deptId);
}
