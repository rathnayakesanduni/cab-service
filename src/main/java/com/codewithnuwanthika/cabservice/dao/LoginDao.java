package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithnuwanthika.cabservice.dao.DbConnector;
import com.codewithnuwanthika.cabservice.dao.DbConnectorImplMySql;
import com.codewithnuwanthika.cabservice.model.User;

public class LoginDao {
	
	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
	public static User authenticateUser(User user) throws ClassNotFoundException, SQLException {
	    String userName = user.getUserName();
		String password = user.getUserPassword();
		
	
		Connection connection =connector.getConnection();
		String query ="select userName,userPassword,roleID from users where userPassword = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, password);
		
		ResultSet rs = ps.executeQuery();
		User user1 = new User();

		if(rs.next()) {
			 
			user1.setUserName(rs.getString("userName"));
			user1.setUserPassword(rs.getString("userPassword"));
			user1.setRoleID(rs.getInt("roleID"));
			
		}
		ps.close();
		connection.close();
		return user1;
	}
}
