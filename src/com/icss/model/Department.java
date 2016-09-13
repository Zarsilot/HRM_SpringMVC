package com.icss.model;

import java.io.Serializable;
/*
 * 
 * 修改2016-09-13，实现Serializable接口，增加二级缓存
 */
public class Department implements Serializable{

	private static final long serialVersionUID = 2683865058562864436L;
	
	private Integer deptId;
	private String deptName;
	private String locName;

	public Department() {
		super();
	}
	
	public Department(Integer department_id, String department_name, String location_name) {
		super();
		this.deptId = department_id;
		this.deptName = department_name;
		this.locName = location_name;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

}
