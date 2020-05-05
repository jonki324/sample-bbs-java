package com.example.models.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exceptions.AppException;

public class QueryPropertyLoader {
	private static final String FILE_NAME = "query";
	private static final Map<String, String> QUERY_MAP = new HashMap<String, String>();
	private static Logger logger = LoggerFactory.getLogger(QueryPropertyLoader.class);
	
	static {
		try {
			ResourceBundle reBundle = ResourceBundle.getBundle(FILE_NAME);
			Enumeration<String> keys = reBundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				QUERY_MAP.put(key, reBundle.getString(key));
			}
			logger.info("Queryプロパティ読込成功");
		} catch (MissingResourceException e) {
			throw new AppException("Queryプロパティ読込失敗", e);
		}
	}
	
	private QueryPropertyLoader() {
	}
	
	public static String getQuery(String key) {
		return QUERY_MAP.get(key);
	}
}
