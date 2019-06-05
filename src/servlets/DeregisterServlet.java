package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.Path;

/**
 * Servlet implementation class DeregisterServlet
 */
@WebServlet("/DeregisterServlet")
public class DeregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeregisterServlet() {
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
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		try {
			
			DAO d=new DAO();
			
			d.openConnection();
			
			if(d.check(un,pwd))
			
			{
			d.deRegister(un,pwd);
			
			d.closeConnection();
			
			File dir=new File(Path.savepath+"\\"+un);
			
			Path.deleteDirectory(dir);		
	
			
			
			out.println("you have successfully deregistered");
			
			out.println("<a href='index.html'>Go back to log in page</a>");
			
			}
			
			else {
				
				d.closeConnection();
				
				out.println("<font color='red'>invalid username or password</font><br><br>");
				
				out.println("<a href='select3.jsp'>try again</a>");
				
			}
			
			
			
			
		}
		
		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		out.close();
		
		
		
	}

}
