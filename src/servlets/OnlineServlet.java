package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Path;

/**
 * Servlet implementation class OnlineServlet
 */
@WebServlet("/OnlineServlet")
public class OnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
        File dir=new File(Path.savepath+"\\temporary");
		
		dir.mkdir();
	
		
		
			response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			
			out.println("<font color='red'>1.Please make the first letter of the class name Capital</font><br><br>");
			
			out.println("<font color='red'>2.please save the file with .java extension</font><br><br>");
			
			out.println("<font color='red'>3.please save the file in this path:"+Path.savepath+"\\temporary</font>");
			
			out.println("<a href='NotepadServlet'>click here to build a source</a>");
			
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
