package com.icss.model;

public class EmpData {
	private int eId;
	private String eName;
	private int percents;
	
	public EmpData() {
		super();
	}

	public EmpData(int eId, String eName, int percents) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.percents = percents;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int getPercents() {
		return percents;
	}

	public void setPercents(int percents) {
		this.percents = percents;
	}
	
}
