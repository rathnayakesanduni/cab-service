package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithnuwanthika.cabservice.model.CustomerBookings;

public class CustomerBookingDao {

	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
 public static boolean addCustomerBooking(CustomerBookings customerBooking) throws ClassNotFoundException, SQLException {
		
		Connection connection =connector.getConnection();
		
		String query = "Insert into customerBookings (customerName,pickUpLocation,dropUpLocation,vehicleType) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customerBooking.getCustomerName());
		ps.setString(2, customerBooking.getPickUpLocation());
		ps.setString(3, customerBooking.getDropUpLocation());
		ps.setString(4, customerBooking.getVehicleType());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
 
	public static List<CustomerBookings> getAllCustomerBookings() throws ClassNotFoundException, SQLException {
		 
		  Connection connection=connector.getConnection();
		
		 String query = "Select * from customerBookings"; 
		 Statement st =connection.createStatement(); ResultSet rs = st.executeQuery(query);
		  List<CustomerBookings> customerBookings = new ArrayList();
		  while(rs.next()) 
		  { 
			  CustomerBookings customerBooking = new CustomerBookings(rs.getInt("bookingID"),rs.getString("customerName"),rs.getString("pickUpLocation"),rs.getString("dropUpLocation"),rs.getString("vehicleType")); 
		    customerBookings.add(customerBooking);
           }
		  
		  st.close(); 
		  connection.close(); 
		  return customerBookings;
		
		
	}
	
	public static boolean deleteCustomerBooking(int bookingID) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Delete from customerBookings where bookingID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, bookingID);

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static List<CustomerBookings> getCustomerBookings() throws ClassNotFoundException, SQLException {
		 
		  Connection connection=connector.getConnection();
		
		 String query = "Select * from customerBookings"; 
		 Statement st =connection.createStatement(); ResultSet rs = st.executeQuery(query);
		  List<CustomerBookings> customerBookings1 = new ArrayList();
		  while(rs.next()) 
		  { 
			  CustomerBookings customerBooking1 = new CustomerBookings(rs.getInt("bookingID"),rs.getString("customerName"),rs.getString("pickUpLocation"),rs.getString("dropUpLocation"),rs.getString("vehicleType")); 
		    customerBookings1.add(customerBooking1);
         }
		  
		  st.close(); 
		  connection.close(); 
		  return customerBookings1;
		
		
	}
	

}
