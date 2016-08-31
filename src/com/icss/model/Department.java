package com.icss.model;


public class Department {

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
