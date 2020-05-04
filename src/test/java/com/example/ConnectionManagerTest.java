package com.example;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.example.models.dbaccess.ConnectionManager;

public class ConnectionManagerTest {

	@Test
	public void connectionOpenAndCloseTest() {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection conn = null;
		
		try {
			conn = connectionManager.getConnection();
			assertTrue(!conn.isClosed());
		} catch (SQLException e) {
		} finally {
			connectionManager.closeConnection();
			try {
				assertTrue(conn.isClosed());
			} catch (SQLException e) {
			}
		}
	}
}
