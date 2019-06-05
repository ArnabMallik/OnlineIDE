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

/**
 * Servlet implementation class RunServlet
 */
@WebServlet("/RunServlet")
public class RunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filetoRun=(String)request.getSession().getAttribute("classname");
		
		String path=(String)request.getSession().getAttribute("savepath");
		
		System.out.println(path);
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		System.out.println("java -classpath "+path+" "+filetoRun);
		
	
		
		try {
			
			Process p=Runtime.getRuntime().exec("java -classpath "+path+" "+filetoRun);
			
			p.waitFor();
			
			BufferedReader br=new  BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String read;
			
			out.println("Output:");
			
			while((read=br.readLine())!=null)
				
			{
				out.println(read);
				
				
			}
			
			
			
		}
		
		catch(IOException e1) {} 
		catch(InterruptedException e2) {} 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
