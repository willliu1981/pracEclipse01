package com.ilan.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JudgeServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CAPTCHA = request.getParameter("CAPTCHA");
		String rndString = (String) request.getSession().getAttribute("rndString");
		String insertion = request.getParameter("insertion");
		String input = request.getParameter("input");
		System.out.println("ref:" + request.getHeader("referer"));
		System.out.println("p:" + input);
		request.setAttribute("insertion", insertion);
		request.setAttribute("input", input);
		if (!CAPTCHA.equals(rndString)) {
			request.getRequestDispatcher("../rndstringerror.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../judge.jsp").forward(request, response);
		}

	}

}
