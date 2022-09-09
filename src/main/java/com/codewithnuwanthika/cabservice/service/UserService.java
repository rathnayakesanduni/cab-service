package com.codewithnuwanthika.cabservice.service;

import java.sql.SQLException;

import com.codewithnuwanthika.cabservice.dao.UserManager;
import com.codewithnuwanthika.cabservice.model.User;

public class UserService {
public  boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		return UserManager.addUser(user);
	}
}
