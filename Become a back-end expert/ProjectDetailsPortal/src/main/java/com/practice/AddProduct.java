package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName = request.getParameter("pName");
		long pPrice = Long.parseLong(request.getParameter("pPrice"));
		String pFreshness = request.getParameter("pFreshness");
		
		Product prod = new Product();
		prod.setpName(pName);
		prod.setpPrice(pPrice);
		prod.setpFreshness(pFreshness);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("pName", prod.getpName());
		session.setAttribute("pPrice", prod.getpPrice());
		session.setAttribute("pFreshness", prod.getpFreshness());
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<a href='showProductDetails.jsp'>Show Product Details</a>");
	}
}