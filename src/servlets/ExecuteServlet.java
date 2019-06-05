package servlets;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.*;


/**
 * Servlet implementation class ExecuteServlet
 */
@WebServlet("/ExecuteServlet")
public class ExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String filetoCompile=(String)request.getSession().getAttribute("path");
		
		System.out.println(filetoCompile);
		
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0");
		
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		
	FileOutputStream fos=new FileOutputStream("error.txt");
		

		int result=compiler.run(null, null,fos,filetoCompile);
		
		StringBuilder buffer=new StringBuilder();
		
		 response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
	
		
		
		
		if(result==0)
			
		{
           
			buffer.append("Compilation successful");
			
			out.println(buffer);
			
			out.println("<a href='RunServlet'>Click here to run</a>");
			
			
			
			
		}
		
		else
		{
			
			out.println("<font color='red'>Compilation unsuccessful</font>");
			
			BufferedReader br=new BufferedReader(new FileReader("error.txt"));
			
			String current_line;
			
			while((current_line=br.readLine())!=null)
				
			{
				
				
				out.println(current_line+"\n");
				
				
				
			}
			
			out.println("<A href='ExecuteServlet'>Recompile</a>");
			
		
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
