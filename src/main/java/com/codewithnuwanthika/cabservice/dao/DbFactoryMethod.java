package com.codewithnuwanthika.cabservice.dao;


public class DbFactoryMethod {
	public DbConnector getDb(String type) {
		if(type=="MySql") {
			return new DbConnectorImplMySql();
		}
		else
		{
			return null;
		}
		
	}
}
