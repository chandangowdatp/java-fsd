package com.practice;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




@WebServlet("/ProductDAO")
public class ProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName = request.getParameter("Name");
		long pPrice = Long.parseLong(request.getParameter("Price"));
		String pFreshness = request.getParameter("Freshness");
		
		// put values in Object
		Product prod = new Product();
		prod.setpName(pName);
		prod.setpPrice(pPrice);
		prod.setpFreshness(pFreshness);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int result = (Integer) session.save(prod);
		session.getTransaction().commit();

		session.close();

		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("Product added successfully.");
		}
		else {
			out.println("Facing issue in adding this product. Please try again.");
		}
	}

}