package com.ilan.control;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class IdentityServlet extends HttpServlet {

	private static char[] chars;
	private Random rnd = new Random();

	{
		chars = new char[62];
		int a = 65, A = 97, n = 48;

		for (int i = a, idx = 0; idx < 26; idx++, i++) {
			chars[idx] = (char) i;
		}
		for (int i = A, idx = 26; idx < 52; idx++, i++) {
			chars[idx] = (char) i;
		}
		for (int i = n, idx = 52; idx < 62; idx++, i++) {
			chars[idx] = (char) i;
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(chars[rnd.nextInt(chars.length)]);
		}

		int w = 100, h = 30;

		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		g.setColor(Color.black);
		g.fill3DRect(0, 0, w, h, false);
		g.setColor(Color.orange);
		g.drawString(sb.toString(), 18, 20);
		for (int i = 0, n = rnd.nextInt(100); i < n; i++) {
			g.draw3DRect(rnd.nextInt(w), rnd.nextInt(h), rnd.nextInt(2), rnd.nextInt(2), true);
		}

		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(out);

		en.encode(bi);
		out.flush();
		out.close();
		System.out.println("ss");
	}

}
