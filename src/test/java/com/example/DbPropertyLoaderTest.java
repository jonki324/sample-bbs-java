package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.models.dbaccess.DbPropertyLoader;

public class DbPropertyLoaderTest {

	@Test
	public void getDriverTest() {
		String expected = "org.postgresql.Driver";
		String actual = DbPropertyLoader.getDriver();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUrlTest() {
		String expected = "jdbc:postgresql://localhost:5432/sample_bbs";
		String actual = DbPropertyLoader.getUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUserTest() {
		String expected = "dbuser";
		String actual = DbPropertyLoader.getUser();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPasswordTest() {
		String expected = "dbpass";
		String actual = DbPropertyLoader.getPassword();
		assertEquals(expected, actual);
	}
}
