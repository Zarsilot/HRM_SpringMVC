package com.icss.model;

public class EmpData {
	private int eId;
	private String name;
	private int percent;
	
	public EmpData() {
		super();
	}

	public EmpData(int eId, String name, int percent) {
		super();
		this.eId = eId;
		this.name = name;
		this.percent = percent;
	}
	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
}
