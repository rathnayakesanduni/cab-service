package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithnuwanthika.cabservice.model.Vehicale;

public class VehicaleDao {
	
	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
    public static Vehicale getTheVehicaleByvehicleID(int vehicleID) throws ClassNotFoundException, SQLException {
		
		Connection connection =connector.getConnection();
		
		String query ="Select * from vehicles where vehicleID = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, vehicleID);
		
		ResultSet rs = ps.executeQuery();
		
		Vehicale vehicale = new Vehicale();
		if(rs.next()) {
			 
			vehicale.setVehicleID(rs.getInt("vehicleID"));
			vehicale.setVehicleName(rs.getString("vehicleName"));
			vehicale.setVehicaleNumber(rs.getString("vehicaleNumber"));
			vehicale.setBranchname(rs.getString("branchname"));
			vehicale.setPrice(rs.getInt("price"));
					}
		
		ps.close();
		connection.close();
		return vehicale;
	}
	
	
	public static List<Vehicale> getAllVehicale() throws ClassNotFoundException, SQLException {
 
		  Connection connection=connector.getConnection();
		
		 String query = "Select * from vehicles"; 
		 Statement st =connection.createStatement(); ResultSet rs = st.executeQuery(query);
		  List<Vehicale> vehicales = new ArrayList();
		  while(rs.next()) 
		  { Vehicale vehicale = new Vehicale(rs.getInt("vehicleID"),rs.getString("vehicleName"),rs.getString("vehicaleNumber"),rs.getString("branchname"),rs.getInt("price")); 
		     vehicales.add(vehicale);
         }
		  
		  st.close(); 
		  connection.close(); 
		  return vehicales;
		
		
	}

	public static boolean addVehicale(Vehicale vehicale) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Insert into vehicles (vehicleName,vehicaleNumber,branchname,price) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicale.getVehicleName());
		ps.setString(2, vehicale.getVehicaleNumber());
		ps.setString(3, vehicale.getVehicaleNumber());
		ps.setInt(4, vehicale.getPrice());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	public static boolean updateVehicale(Vehicale vehicale) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Update vehicles set vehicleName=?, vehicaleNumber=?, branchname=?, price=? where vehicleID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicale.getVehicleName());
		ps.setString(2, vehicale.getVehicaleNumber());
		ps.setString(3, vehicale.getVehicaleNumber());
		ps.setInt(4, vehicale.getPrice());
		ps.setInt(5, vehicale.getVehicleID());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	public static boolean deleteVehicale(int vehicleID) throws ClassNotFoundException, SQLException {

		Connection connection = connector.getConnection();

		String query = "Delete from vehicles where vehicleID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, vehicleID);

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	

	
}
