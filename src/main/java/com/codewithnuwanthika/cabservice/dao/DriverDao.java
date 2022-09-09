package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithnuwanthika.cabservice.model.Driver;

public class DriverDao {
	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
	
public static Driver getTheDriverBydriverID(int driverID) throws ClassNotFoundException, SQLException {
		
		Connection connection =connector.getConnection();
		
		String query ="Select * from drivers where driverID = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, driverID);
		
		ResultSet rs = ps.executeQuery();
		
		Driver driver = new Driver();
		if(rs.next()) {
			 
			driver.setDriverID(rs.getInt("driverID"));
			driver.setDriverName(rs.getString("driverName"));
			driver.setBranchName(rs.getString("branchName"));
			
					}
		
		ps.close();
		connection.close();
		return driver;
	}
	
	
	public static List<Driver> getAllDriver() throws ClassNotFoundException, SQLException {
 
		  Connection connection=connector.getConnection();
		
		 String query = "Select * from drivers"; 
		 Statement st =connection.createStatement(); 
		 ResultSet rs = st.executeQuery(query);
		  List<Driver> drivers = new ArrayList();
		  while(rs.next()) 
		  { Driver driver = new Driver(rs.getInt("driverID"),rs.getString("driverName"),rs.getString("branchName")); 
		    drivers.add(driver);
         }
		  
		  st.close(); 
		  connection.close(); 
		  return drivers;
		
		
	}
	
	public static boolean adddriver(Driver driver) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "INSERT into drivers(driverName,branchName) values(?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getDriverName());
		ps.setString(2, driver.getBranchName());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Update drivers set driverName=?, branchName=? where driverID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getDriverName());
		ps.setString(2, driver.getBranchName());
	    ps.setInt(3, driver.getDriverID());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	
	public static boolean deleteDriver(int driverID) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Delete from drivers where driverID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, driverID);

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
}
