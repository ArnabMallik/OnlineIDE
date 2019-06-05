package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Path;
import dao.User;

/**
 * Servlet implementation class CrecompileServlet
 */
@WebServlet("/CrecompileServlet")
public class CrecompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrecompileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String filename=(String)request.getSession().getAttribute("filename");
		
		System.out.println(filename);
		
		
		String un=((User)request.getSession().getAttribute("user")).getUsername();
		
		
		String file=Path.savepath+"\\"+un+"\\Cfiles\\"+filename;
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		try {
			Process p=Runtime.getRuntime().exec("gcc "+file);
			
			p.waitFor();
		
			
			BufferedReader input=new  BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			String line;

			
			if((line=input.readLine())==null)
			{
				
				out.println("compilation successful");
				
				out.println("<a href='CrunServlet'>click here to run</a>");
				
		
			}
			
			else {
				
				out.println("<font color='red'>Compilation Unsuccessful</font>");
				
				
				while((line=input.readLine())!=null) {
					
					out.println(line);
					
				}
				
				input.close();
					
					//out.println("<br><br><a href='CrecompileServlet'>click here to recompile</a>");
					
				
			out.println("<br><br><a href='CdebugServlet'>click here to debug</a>");
			
			out.close();
			
			}	
					
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
