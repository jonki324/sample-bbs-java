package com.example.models.dbaccess;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exceptions.AppException;

public class DbPropertyLoader {
	private static Logger logger = LoggerFactory.getLogger(DbPropertyLoader.class);
	
	private static final String FILE_NAME = "db";
	private static final String DRIVER = "driver";
	private static final String URL = "url";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			ResourceBundle resource = ResourceBundle.getBundle(FILE_NAME);
			driver = resource.getString(DRIVER);
			url = resource.getString(URL);
			user = resource.getString(USER);
			password = resource.getString(PASSWORD);
			logger.info("DBプロパティ読込成功");
		} catch (MissingResourceException e) {
			throw new AppException("DBプロパティ読込失敗", e);
		}
	}
	
	private DbPropertyLoader() {
	}

	public static String getDriver() {
		return driver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}
}
