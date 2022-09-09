package com.codewithnuwanthika.cabservice.model;

public class CustomerBookings {
	   private int bookingID;
	   private String customerName;
	   private String pickUpLocation;
	   private String dropUpLocation;
	   private String vehicleType;
	
	   public CustomerBookings() {
		super();
		
	  }

	public CustomerBookings(String customerName, String pickUpLocation, String dropUpLocation, String vehicleType) {
		super();
		this.customerName = customerName;
		this.pickUpLocation = pickUpLocation;
		this.dropUpLocation = dropUpLocation;
		this.vehicleType = vehicleType;
	}

	public CustomerBookings(int bookingID, String customerName, String pickUpLocation, String dropUpLocation,
			String vehicleType) {
		super();
		this.bookingID = bookingID;
		this.customerName = customerName;
		this.pickUpLocation = pickUpLocation;
		this.dropUpLocation = dropUpLocation;
		this.vehicleType = vehicleType;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDropUpLocation() {
		return dropUpLocation;
	}

	public void setDropUpLocation(String dropUpLocation) {
		this.dropUpLocation = dropUpLocation;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	   
	   
	   
	   
}
