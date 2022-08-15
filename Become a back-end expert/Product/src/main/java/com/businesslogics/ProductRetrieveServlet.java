package com.businesslogics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductRetrieveServlet")
public class ProductRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int ProductID_Key = Integer.parseInt(req.getParameter("ProductID"));
		
		try {
			Connection con = DBConnection.getDBConnection();
			
			String querry = "Select * from ProductDetails where ProductID = ?";
			PreparedStatement ps = con.prepareStatement(querry);
			
			ps.setInt(1, ProductID_Key);
			
			ResultSet result = ps.executeQuery();	
		
			PrintWriter out = res.getWriter();
			if(result.next()) {
			
			out.println("<table border=2>");
			out.println("<tr><th>ProductID\no</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th></tr>");
			out.println("<tr>");
			out.println("<td>" + result.getInt("ProductID") + "</td>");
			out.println("<td>" + result.getString("ProductName") + "</td>");
			out.println("<td>" + result.getLong("ProductPrice") + "</td>");	
			out.println("<td>" + result.getInt("ProductQuantity") + "</td>");	
			out.println("</tr>");
			out.println("</table>");
			}
			else {
				out.println("Product with this ProductID does not exists.");
			}
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
