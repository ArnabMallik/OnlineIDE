package servlets;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import dao.EditorFile;
import dao.Path;

/**
 * Servlet implementation class EditorcompileServlet
 */
@WebServlet("/EditorcompileServlet")
public class EditorcompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorcompileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
       String filename=EditorFile.getpath();
       
       System.out.println(filename);
       
       String ext=filename.substring(filename.lastIndexOf(".")+1);
       
       response.setContentType("text/html");
       
       PrintWriter out=response.getWriter();
       
       if(ext.equals("c"))
       {
    	   
			
			try {
				Process p=Runtime.getRuntime().exec("gcc "+filename);
				
				p.waitFor();
				
				BufferedReader input=new BufferedReader(new InputStreamReader(p.getErrorStream()));
				
				//out.println("c file compiled");
				
				String line;
				
				if((line=input.readLine())==null)
				{
					
					out.println("compilation successful");
					
					out.println("<a href='EditorCrunServlet'>click here to run</a>");
					
			
				}
				
				else {
					out.println("<font color='red'>Compilation Unsuccessful</font>");
					
					
					
					while((line=input.readLine())!=null) {
						
						out.println(line);
						
					}
					
					input.close();
						
						//out.println("<br><br><a href='CrecompileServlet'>click here to recompile</a>");
						
					out.println("<br><br><a href='NotepadServlet' target='_blank'>open the file to debug</a>");
					
					out.println("<br><br><a href='EditorcompileServlet'>Compile & run</a>");
						
					
					
				}	
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
       }
			
			else if(ext.equals("cpp"))
		       {
		    	   
					
					try {
						Process p=Runtime.getRuntime().exec("g++ "+filename);
						
						p.waitFor();
						
						BufferedReader input=new BufferedReader(new InputStreamReader(p.getErrorStream()));
						
						//out.println("c file compiled");
						
						String line;
						
						if((line=input.readLine())==null)
						{
							
							out.println("compilation successful");
							
							out.println("<a href='EditorCpprunServlet'>click here to run</a>");
							
					
						}
						
						else {
							out.println("<font color='red'>Compilation Unsuccessful</font>");
							
							
							
							while((line=input.readLine())!=null) {
								
								out.println(line);
								
							}
							
							input.close();
								
								//out.println("<br><br><a href='CrecompileServlet'>click here to recompile</a>");
								
								out.println("<br><br><a href='NotepadServlet' target='_blank'>open the file to debug</a>");
								out.println("<br><br><a href='EditorcompileServlet'>Compile & run</a>");
							
							
						}	
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
       }
       
			else {
				
				
				
				
				
				
				
				
				
				
				
          //String  class_name=filename.substring(0,filename.length()-5);
				
				
				//request.getSession().setAttribute("classname",class_name);
		
		
		
		System.setProperty("java.home","C:\\Program Files\\Java\\jdk1.7.0");
		
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		
		FileOutputStream fos=new FileOutputStream("error.txt");
		
		//System.out.println("hjdsbfjdsf");
		
		int result=compiler.run(null,null,fos,filename);
		
		
		
		StringBuilder buffer=new StringBuilder();
		
		
		
		if(result==0) {
			
			
			buffer.append("Compilation Successful");
			
			out.println(buffer);
			
			out.println("<a href='EditorJavarunServlet'>Click here to run</a>");
			
			
			
			
			
		}
		
		else {
			
			out.println("<font color='red'>Compilation Unsuccessful</font>");
			
			BufferedReader br=new BufferedReader(new FileReader("error.txt"));
			
			String current_line;
			
			while((current_line=br.readLine())!=null)
				
			{
				
				out.println(current_line);
			}
			
			br.close();
			
			
			out.println("<br><br><a href='NotepadServlet' target='_blank'>open the file to debug</a>");
			
			out.println("<br><br><a href='EditorcompileServlet'>Compile & run</a>");
			
			//out.println("<br><br><a href='JavadebugServlet'>click here to debug</a>");
			
			
			
			
			
			
		}
		
			}
			
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
       
   	
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
