package com.example.controllers.command;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exceptions.AppException;

public abstract class CommandFactory {
	public static final String FILE_NAME = "command";
	private static final Map<String, String> COMMAND_MAP = new HashMap<String, String>();
	private static Logger logger = LoggerFactory.getLogger(CommandFactory.class);
	
	static {
		try {
			ResourceBundle reBundle = ResourceBundle.getBundle(FILE_NAME);
			Enumeration<String> keys = reBundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				COMMAND_MAP.put(key, reBundle.getString(key));
			}
			logger.info("Commandプロパティ読込成功");
		} catch (MissingResourceException e) {
			throw new AppException("Commandプロパティ読込失敗", e);
		}
	}
	
	public static Command getCommand(String path) {
		Command command = null;
		try {
			@SuppressWarnings("rawtypes")
			Class type = Class.forName(COMMAND_MAP.get(path));
			command = (Command)type.newInstance();
		} catch (ClassNotFoundException e) {
			throw new AppException("クラスロード失敗", e);
		} catch (InstantiationException e) {
			throw new AppException("インスタンス化失敗", e);
		} catch (IllegalAccessException e) {
			throw new AppException("クラスアクセス失敗", e);
		}
		return command;
	}
}
