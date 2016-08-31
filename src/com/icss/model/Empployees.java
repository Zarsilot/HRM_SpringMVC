package com.icss.model;

import java.util.Date;

public class Empployees {

	private int employee_id;
	private String emp_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private int salary;
	private int department_id;
	
	public Empployees() {
		super();
	}

	public Empployees(String emp_name, String email, String phone_number, String hdate, String job_id,
			int salary, int department_id) {
		super();
		this.emp_name = emp_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hdate;
		this.job_id = job_id;
		this.salary = salary;
		this.department_id = department_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
}
