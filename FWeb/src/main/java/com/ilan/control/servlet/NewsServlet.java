package com.ilan.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsServlet extends HttpServlet {
	@Resource(name = "news")
	String news;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(" <h1>");
		out.print(" news : "+news);
		out.print("<br/> query : "+request.getQueryString());
		out.print(" </h1>");
	
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		
		
	}

}
