package com.example.models.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exceptions.AppException;

public class ConnectionManager {
	private static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
	
	static {
		try {
			Class.forName(DbPropertyLoader.getDriver());
			logger.info("DBドライバー読込成功");
		} catch (ClassNotFoundException e) {
			throw new AppException("DBドライバー読込失敗", e);
		}
	}
	
	private Connection connection;
	
	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(DbPropertyLoader.getUrl(),
														DbPropertyLoader.getUser(),
														DbPropertyLoader.getPassword());
				connection.setAutoCommit(false);
				logger.info("DBコネクション取得成功");
			}
		} catch (SQLException e) {
			throw new AppException("DBコネクション取得失敗", e);
		}
		return connection;
	}
	
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			logger.info("DBコネクション切断成功");
		} catch (SQLException e) {
			throw new AppException("DBコネクション切断失敗", e);
		}
	}
	
	public void commit() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.commit();
				logger.info("コミット成功");
			}
		} catch (SQLException e) {
			throw new AppException("コミット失敗", e);
		}
	}
	
	public void rollback() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.rollback();
				logger.info("ロールバック成功");
			}
		} catch (SQLException e) {
			throw new AppException("ロールバック失敗", e);
		}
	}
}
