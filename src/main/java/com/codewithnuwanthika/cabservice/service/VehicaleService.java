package com.codewithnuwanthika.cabservice.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnuwanthika.cabservice.dao.VehicaleDao;
import com.codewithnuwanthika.cabservice.model.Vehicale;

public class VehicaleService {
   public  Vehicale getTheVehicaleByvehicleID(int vehicleID) throws ClassNotFoundException, SQLException {
		
		return VehicaleDao.getTheVehicaleByvehicleID(vehicleID);
	}
	
    public List<Vehicale> getAllVehicale() throws ClassNotFoundException, SQLException{
		
		return VehicaleDao.getAllVehicale();
	}
	
	public  boolean addVehicale(Vehicale vehicale) throws ClassNotFoundException, SQLException {
		
		return VehicaleDao.addVehicale(vehicale);
	}
	
	public  boolean updateVehicale(Vehicale vehicale) throws ClassNotFoundException, SQLException {
		
		return VehicaleDao.updateVehicale(vehicale);
	}
	
	public  boolean deleteVehicale(int vehicleID) throws ClassNotFoundException, SQLException {
		
		return VehicaleDao.deleteVehicale(vehicleID);
	}
	
   
}
