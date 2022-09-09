package com.codewithnuwanthika.cabservice.model;

public class Driver {
	   private int driverID;
	   private String driverName;
	   private String branchName;
	
	   public Driver() {
		
	   }

	public Driver(int driverID, String driverName, String branchName) {
		super();
		this.driverID = driverID;
		this.driverName = driverName;
		this.branchName = branchName;
	}

	public Driver(String driverName, String branchName) {
		super();
		this.driverName = driverName;
		this.branchName = branchName;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	   
	   
	   
	   
}
