package com.codewithnuwanthika.cabservice.model;

public class Feedback {
	   private String customer_Name;
	   private String descrption;
	
	   public Feedback() {
		super();
		
	   }

	public Feedback(String customer_Name, String descrption) {
		super();
		this.customer_Name = customer_Name;
		this.descrption = descrption;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	   
	   
	   
	   
}
