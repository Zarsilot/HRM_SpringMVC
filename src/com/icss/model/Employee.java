package com.icss.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

	private int empId;
	//使用Java API实现对输入的限制
	@NotNull
	@Size(min=5,max=25,message="{empName.size}")
	private String empName;
	@NotNull
	@Email(message="{email.valid}")
	private String email;
	@NotNull
	@Size(min=7,max=11,message="{phoneNumber.size}")
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private int deptId;
	private int percent;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String email, String phoneNumber, String hireDate, String jobId,
			int salary, int deptId, int percent) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.deptId = deptId;
		this.percent = percent;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
}
