package com.codewithnuwanthika.cabservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.codewithnuwanthika.cabservice.model.CustomerBookings;

class CustomerBookingServiceTest {

	@Test
	void testAddCustomerBooking() throws ClassNotFoundException, SQLException {
		CustomerBookingService service = new CustomerBookingService();
		CustomerBookings customerBooking = new CustomerBookings();
		boolean expected = true;
		boolean actual = service.addCustomerBooking(customerBooking);
		assertEquals(expected,actual,"The Customerbook was add");
	}

}
