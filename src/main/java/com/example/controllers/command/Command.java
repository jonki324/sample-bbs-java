package com.example.controllers.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public abstract void init(HttpServletRequest request, HttpServletResponse response);
	public abstract void process() throws ServletException, IOException;
	public abstract void forward(String path) throws ServletException, IOException;
	public abstract void jsonResponse(String jsonString) throws ServletException, IOException;
}
