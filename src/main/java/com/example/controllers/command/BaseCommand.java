package com.example.controllers.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseCommand implements Command {
	private static final String VIEWS_DIR = "/WEB-INF/views";
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void forward(String path) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String jspName = VIEWS_DIR + path + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
		dispatcher.forward(request, response);
	}
	
	@Override
	public void jsonResponse(String jsonString) throws ServletException, IOException {
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();
	}
}
