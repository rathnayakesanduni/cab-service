package com.codewithnuwanthika.cabservice.model;

public class Vehicale {
	   private int vehicleID;
	   private String vehicleName;
	   private String vehicaleNumber;
	   private String branchname;
	   private int price;
	
	   public Vehicale() {
		
	  }

	public Vehicale(String vehicleName, String vehicaleNumber, String branchname, int price) {
		super();
		this.vehicleName = vehicleName;
		this.vehicaleNumber = vehicaleNumber;
		this.branchname = branchname;
		this.price = price;
	}

	public Vehicale(int vehicleID, String vehicleName, String vehicaleNumber, String branchname, int price) {
		super();
		this.vehicleID = vehicleID;
		this.vehicleName = vehicleName;
		this.vehicaleNumber = vehicaleNumber;
		this.branchname = branchname;
		this.price = price;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicaleNumber() {
		return vehicaleNumber;
	}

	public void setVehicaleNumber(String vehicaleNumber) {
		this.vehicaleNumber = vehicaleNumber;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	   
	   
	   
	   
	
	   
	   
	   
	   
}
