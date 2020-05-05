package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.models.dao.QueryPropertyLoader;

public class QueryPropertyLoaderTest {

	@Test
	public void getQueryTest() {
		String expected = "SELECT * FROM topics";
		String actual = QueryPropertyLoader.getQuery("fetchAllTopics");
		assertEquals(expected, actual);
	}
}
