package servlets;

import oracle.jdbc.OracleDriver;







import java.sql.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.Path;
import dao.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/home/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String un=request.getParameter("username");
		
		String pwd=request.getParameter("password");
		
		String fn=request.getParameter("firstname");
		
		String ln=request.getParameter("lastname");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		DAO d=new DAO();
		
		d.openConnection();
		
		User u=new User();
		
		u.setFirstname(fn);
		
		u.setLastname(ln);
		
		u.setPassword(pwd);
		
		u.setUsername(un);
		
		d.create(u);
		
		out.println("<br><br><br><center>Database updated successfully</center></br></br></br>");
		
		try {
			d.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File f=new File(Path.savepath+"\\"+un);
		
		f.mkdir();
		
		out.println("<a href='index.html'>Click here to go to login page</a>");
		
		out.close();

		
	}
}
