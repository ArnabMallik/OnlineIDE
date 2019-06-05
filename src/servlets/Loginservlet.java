package servlets;


import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import dao.User;
import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String un=request.getParameter("username");

		String pwd=request.getParameter("password");
		
		
		
		try {
			
		
		
		DAO d=new DAO();
		
		d.openConnection();
		
		User u=d.authenticate(un,pwd);
		
		d.closeConnection();
		
		if(u!=null)
		{
			
			request.getSession().setAttribute("user", u);
			
		
			
			request.getRequestDispatcher("success.jsp").forward(request,response);
			
			
			
		}
		
	
		else
			
			response.sendRedirect("wrong.jsp");
		
			
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	
		

		
		
	}
		
	}


