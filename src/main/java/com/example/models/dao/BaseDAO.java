package com.example.models.dao;

import java.sql.Connection;

public abstract class BaseDAO {
	private Connection connection;
	
	public BaseDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
