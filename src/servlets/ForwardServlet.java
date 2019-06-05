package servlets;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import dao.*;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() {
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
		
		String filename=request.getParameter("filename");
		
	    String choice=request.getParameter("choice");
	    
	    request.getSession().setAttribute("filename",filename);
		
		//System.out.println(choice);
		
		String un=((User)request.getSession().getAttribute("user")).getUsername();
		
	response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String ext=filename.substring((filename.lastIndexOf(".")+1));
		
		if(choice.equals("compile"))
		{
				
			if(ext.equals("cpp")) {
				
				//System.out.println("c++ file");
				
				String file=Path.savepath+"\\"+un+"\\C++files"+"\\"+filename;
				try {
					Process p=Runtime.getRuntime().exec("g++ "+file);
					
				p.waitFor();
					
					BufferedReader input=new BufferedReader(new InputStreamReader(p.getErrorStream()));
					
					//out.println("c file compiled");
					
					String line;
					
					if((line=input.readLine())==null)
					{
						
						out.println("compilation successful");
						
						
						
						out.println("<a href='CpprunServlet'>click here to run</a>");
						
				
					}
					
					else {
						
						out.println("<font color='red'>Compilation Unsuccessful</font>");
						
						
						while((line=input.readLine())!=null) {
							
							out.println(line);
							
						}
						
						input.close();
							
							//out.println("<br><br><a href='CpprecompileServlet'>click here to recompile</a>");
							
							out.println("<br><br><a href='CppdebugServlet'>click here to debug</a>");
							
							
						
						
						
						
					}
					
				}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

					
							
				
			}
				
				else  if(ext.equals("c")) {
					
					//System.out.println("c");
					
					String file=Path.savepath+"\\"+un+"\\Cfiles"+"\\"+filename;
				
					try {
						Process p=Runtime.getRuntime().exec("gcc "+file);
						
						p.waitFor();
						
						BufferedReader input=new BufferedReader(new InputStreamReader(p.getErrorStream()));
						
						//out.println("c file compiled");
						
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
								
							
							
							
						}
						
								
			
			
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				
			}
			
			else {
				
				System.out.println("java file");
				
				String  class_name=filename.substring(0,filename.length()-5);
				
				
				request.getSession().setAttribute("classname",class_name);
		
		String fileToCompile=Path.savepath+"\\"+un+"\\Javafiles"+"\\"+filename;	
		
		System.setProperty("java.home","C:\\Program Files\\Java\\jdk1.7.0");
		
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		
		FileOutputStream fos=new FileOutputStream("error.txt");
		
		//System.out.println("hjdsbfjdsf");
		
		int result=compiler.run(null,null,fos,fileToCompile);
		
		
		
		StringBuilder buffer=new StringBuilder();
		
		
		
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
			
			br.close();
			
			
			out.println("<br><br><A href='RecompileServlet'>Recompile</a>");
			
			//out.println("<br><br><a href='JavadebugServlet'>click here to debug</a>");
			
			
			
			
			
			
		}
		
				
			
		}
			
		}
		
		
		
		
		
		
		else
		{
			
			
			/*request.setAttribute("filename",filename);
			
			request.getRequestDispatcher("EditServlet").forward(request,response);*/
			
			//System.out.println(Path.savepath+"\\"+filename);
			
			try {
				
				if(ext.equals("cpp")){
					
				
				
				Process p=Runtime.getRuntime().exec("notepad "+Path.savepath+"\\"+un+"\\C++files\\"+filename);
				
				}
				//p.waitFor();
				
				else if(ext.equals("c")) {
					
					Process p=Runtime.getRuntime().exec("notepad "+Path.savepath+"\\"+un+"\\Cfiles\\"+filename);
				}
				
				else {
				
			Process p=Runtime.getRuntime().exec("notepad "+Path.savepath+"\\"+un+"\\Javafiles\\"+filename);
				}
				
				
				out.println("<a href='editcompile.jsp'><b>GO BACK</b></a>");
			
			}
			
			catch(IOException e1) {} 
			//catch(InterruptedException e2) {} 
			
			
			
		}
	}

}
