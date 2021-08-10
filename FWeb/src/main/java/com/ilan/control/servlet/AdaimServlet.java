package com.ilan.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdaimServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("xx3 " + request.getRequestURI() + "<br/>");
		out.print("<form action='" + request.getRequestURI() + "' method='post'>");
		out.print("<input type='text' name='username' value='Admin'/><br/>");
		out.print("<input type='text' name='password' value='admin123'/><br/>");
		out.print("<input type='submit' value='send'/>");

		out.print("</form >");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Enumeration<?> users = this.getInitParameterNames();
		while (users.hasMoreElements()) {
			String pUsername = (String) users.nextElement();
			String pPassword = this.getInitParameter(pUsername);
			this.getServletConfig().getServletContext().getInitParameter(pPassword);
			this.getServletConfig().getInitParameter(pPassword);

			if (pUsername.equals(username) && pPassword.equals(password)) {
				request.setAttribute("user", username);
				request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
				return;
			}
			

		}
		
		this.doGet(request, response);

	}
}
