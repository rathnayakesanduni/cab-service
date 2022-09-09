package com.codewithnuwanthika.cabservice.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnuwanthika.cabservice.dao.CustomerBookingDao;
import com.codewithnuwanthika.cabservice.model.CustomerBookings;



public class CustomerBookingService {
      
    public  boolean addCustomerBooking(CustomerBookings customerBooking) throws ClassNotFoundException, SQLException {
		
		return CustomerBookingDao.addCustomerBooking(customerBooking);
	}
    
   public List<CustomerBookings> getAllCustomerBookings() throws ClassNotFoundException, SQLException{
		
		return CustomerBookingDao.getAllCustomerBookings();
	}
   
   public  boolean deleteCustomerBooking(int bookingID) throws ClassNotFoundException, SQLException {
		
		return CustomerBookingDao.deleteCustomerBooking(bookingID);
	}
   
   public List<CustomerBookings> getCustomerBookings() throws ClassNotFoundException, SQLException{
		
		return CustomerBookingDao.getCustomerBookings();
	}
}
