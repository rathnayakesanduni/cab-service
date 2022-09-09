package com.codewithnuwanthika.cabservice.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnuwanthika.cabservice.dao.DriverDao;

import com.codewithnuwanthika.cabservice.model.Driver;

public class DriverService {
	
public  Driver getTheDriverBydriverID(int driverID) throws ClassNotFoundException, SQLException {
		
		return DriverDao.getTheDriverBydriverID(driverID);
	}
	
    public List<Driver> getAllDriver() throws ClassNotFoundException, SQLException{
		
		return DriverDao.getAllDriver();
	}
	
	public boolean adddriver(Driver driver) throws ClassNotFoundException, SQLException {
		return DriverDao.adddriver(driver);
	}
    public  boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		return DriverDao.updateDriver(driver);
	}
	
	public  boolean deleteDriver(int driverID) throws ClassNotFoundException, SQLException {
		
		return DriverDao.deleteDriver(driverID);
	}
}
