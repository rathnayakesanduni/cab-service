package com.codewithnuwanthika.cabservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.codewithnuwanthika.cabservice.model.Vehicale;

class VehicaleServiceTest {

	@Test
	void testAddVehicale() throws ClassNotFoundException, SQLException {
		VehicaleService service = new VehicaleService();
		Vehicale vehicale = new Vehicale();
		boolean expected = true;
		boolean actual = service.addVehicale(vehicale);
		assertEquals(expected,actual,"The vehicle was add");
	}

}
