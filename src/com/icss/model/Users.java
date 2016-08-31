package com.icss.model;

public class Users {

	private String adminname;
	private String adminpwd;
	private int adminlevel;
	
	public Users() {
		super();
	}

	public Users(String adminname, String adminpwd, int adminlevel) {
		super();
		this.adminname = adminname;
		this.adminpwd = adminpwd;
		this.adminlevel = adminlevel;
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
