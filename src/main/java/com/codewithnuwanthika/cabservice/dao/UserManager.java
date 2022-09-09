package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codewithnuwanthika.cabservice.model.User;

public class UserManager {

	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
	public static boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		Connection connection =connector.getConnection();
		
		String query = "Insert into users (userName,address,contactNo,userPassword,roleID) values (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getAddress());
		ps.setString(3, user.getContactNo());
		ps.setString(4, user.getUserPassword());
		ps.setInt(5, user.getRoleID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
	
}
