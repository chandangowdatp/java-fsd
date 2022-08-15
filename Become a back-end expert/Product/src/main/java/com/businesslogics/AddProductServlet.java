package com.businesslogics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddProductServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int ProductID = Integer.parseInt(req.getParameter("ProductID"));
		String ProductName = req.getParameter("ProductName");
		long ProductPrice = Long.parseLong(req.getParameter("ProductPrice"));
		int ProductQuantity = Integer.parseInt(req.getParameter("ProductQuantity"));
		
		try {
			Connection con = DBConnection.getDBConnection();		//Establishing connection
			
			String querry = "Insert into ProductDetails(ProductID,ProductName,ProductPrice,ProductQuantity) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(querry);
			
			ps.setInt(1,  ProductID);
			ps.setString(2,  ProductName);
			ps.setLong(3, ProductPrice);
			ps.setInt(4, ProductQuantity);
			
			int result = ps.executeUpdate();
			
			PrintWriter out = res.getWriter();
			
			
			if(result > 0) {
				out.println("Product added successfully.");
			}
			else {
				out.println("There is some issue in adding this product, please try with different Product ID and Product Name !");
			}
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
