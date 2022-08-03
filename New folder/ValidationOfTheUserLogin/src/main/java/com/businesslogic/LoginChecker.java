package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginChecker() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out  = response.getWriter();
		if(username.equalsIgnoreCase("Chandan") && password.equals("Chandan123")) {
			out.println("Welcome to the dashboard");
		}
		else {
			out.println("Invalid Username or password.");
		}*/
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out  = resp.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("LoginPage.html");
		
		if(username.equalsIgnoreCase("Chandan") && password.equals("Chandan123")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			
			rd = req.getRequestDispatcher("Dashboard");
			rd.forward(req, resp);
		}
		else {
			out.println("Invalid Username or password...");
			rd.include(req, resp);
		}
		
	}

}
