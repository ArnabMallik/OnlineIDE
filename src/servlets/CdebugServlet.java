package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Path;
import dao.User;

/**
 * Servlet implementation class CdebugServlet
 */
@WebServlet("/CdebugServlet")
public class CdebugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CdebugServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filename=(String)request.getSession().getAttribute("filename");
		
		String un=((User)request.getSession().getAttribute("user")).getUsername();
		

		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
	
		Runtime.getRuntime().exec("notepad "+Path.savepath+"\\"+un+"\\Cfiles\\"+filename);
		
			
		out.println("<br><br><a href='CrecompileServlet'>click here to recompile</a>");
		
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
