package com.ph;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// for printing error message when login not successful
			PrintWriter out = response.getWriter();
			//connect to mySql database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db", "root", "password");
			
			//create parameters with names matching name in .jsp file
			String n = request.getParameter("txtName");
			String p = request.getParameter("txtPwd");
			
			//check if username and password is in database
			PreparedStatement ps = con.prepareStatement("select uname from login where uname=? and password=?"); //uname is column name, and login is table name 
			ps.setString(1,  n); //first ? replaced with n in first text box
			ps.setString(2,  p); //second ? replaced with p in second text box
			ResultSet rs = ps.executeQuery(); //query returns a resultset value
			
			// if login is successful, redirect user to welcome.jsp page
			if(rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}//if login not successful
			else {
				out.println("<font color=red size=18>Login failed, please try again<br>");
				out.println("<a href=login.jsp>Try Again</a>"); // go back to login.jsp page
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		};
	}  
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
