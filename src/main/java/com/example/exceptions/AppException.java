package com.example.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(AppException.class);
	
	public AppException(String msg, Throwable e) {
		super(msg, e);
		logger.error(msg + " : " + e.toString());
	}
}
