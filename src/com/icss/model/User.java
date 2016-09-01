package com.icss.model;

public class User {
	
	private int adminId;         //登录ID
	private String adminname;    //用户名
	private String adminpwd;     //用户登录密码
	private int adminlevel;      //用户权限
	
	public User() {
		super();
	}

	public User(String adminname, String adminpwd, int adminlevel) {
		super();
		this.adminname = adminname;
		this.adminpwd = adminpwd;
		this.adminlevel = adminlevel;
	}
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public int getAdminlevel() {
		return adminlevel;
	}

	public void setAdminlevel(int adminlevel) {
		this.adminlevel = adminlevel;
	}
	
}
