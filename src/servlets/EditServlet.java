 package servlets;




import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String language=request.getParameter("lang");
		
		if(language.equals("C"))
			
		{
			
			out.println("<b><font color='red'>Save the file in the current directory with .c extension</b></font>");
		}
		
		else if(language.equals("C++"))
			
		{
			
			
			
			out.println("<b><font color='red'>Save the file in the current directory with .cpp extension</b></font>");
			
			
		}
		
		else
		
	
		{
			
			
			
			out.println("<font color='red'>The class name must start with a capital letter and save the file in the current directory with .java extension</font>");
			
			
		}
		
		
		out.println("<br><br><br><a href='NotepadServlet' target='_blank'>Open the editor</a>");
		
   
   		
		out.println("<br><br><br><a href='EditorcompileServlet'>click here to compile & run</a>");
		
		
		
		
		
		
		
	}
	

}
