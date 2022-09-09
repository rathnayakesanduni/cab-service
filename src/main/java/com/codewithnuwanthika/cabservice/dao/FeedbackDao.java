package com.codewithnuwanthika.cabservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codewithnuwanthika.cabservice.model.Feedback;


public class FeedbackDao {
	static DbFactoryMethod factory = new DbFactoryMethod();
	static DbConnector connector = factory.getDb("MySql");
	
  public static boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		Connection connection =connector.getConnection();
		
		String query = "Insert into feedbacks (customer_Name,descrption) values (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, feedback.getCustomer_Name());
		ps.setString(2, feedback.getDescrption());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
}
