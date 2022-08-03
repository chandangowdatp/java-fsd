package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Dashboard() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("Welcome to the dashboard");
		
		
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		
		out.println("Logged in at : " + new Date(session.getCreationTime()));
		
		
		out.println("<a href='Logout' style='color:red; text-align: right; margin-top: 20px;'>Logout</a>");
	}

}
