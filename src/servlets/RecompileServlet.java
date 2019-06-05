package servlets;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import dao.Path;
import dao.User;

/**
 * Servlet implementation class RecompileServlet
 */
@WebServlet("/RecompileServlet")
public class RecompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecompileServlet() {
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

		String fileToCompile=Path.savepath+"\\"+un+"\\Javafiles"+"\\"+filename;	
		
		System.setProperty("java.home","C:\\Program Files\\Java\\jdk1.7.0");
		
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		
		FileOutputStream fos=new FileOutputStream("error.txt");
		
		//System.out.println("hjdsbfjdsf");
		
		int result=compiler.run(null,null,fos,fileToCompile);
		
		StringBuilder buffer=new StringBuilder();
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		if(result==0) {
			
			
			buffer.append("Compilation Successful");
			
			out.println(buffer);
			
		
			
			out.println("<a href='JavaRunServlet'>Click here to run</a>");
			
		}
			
			else {
				
				out.println("<font color='red'>Compilation Unsuccessful</font>");
				
				BufferedReader br=new BufferedReader(new FileReader("error.txt"));
				
				String current_line;
				
				while((current_line=br.readLine())!=null)
					
				{
					
					
					
					
					out.println(current_line);
				}
				//request.getSession().setAttribute("filename",filename);
				
				br.close();
				
				out.println("<br><br><A href='RecompileServlet'>Recompile</a>");
				
				//out.println("<br><br><a href='JavadebugServlet'>click here to debug</a>");
				
				
				
	
				
			}
		
		out.close();
			
			
			
			
			
		}
	  
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
