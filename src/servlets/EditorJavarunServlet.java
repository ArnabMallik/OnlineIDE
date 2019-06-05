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

import dao.EditorFile;
import dao.Path;
import dao.User;

/**
 * Servlet implementation class EditorJavarunServlet
 */
@WebServlet("/EditorJavarunServlet")
public class EditorJavarunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorJavarunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	  	   
   
        
        //String un=((User)request.getSession().getAttribute("user")).getUsername();

		
		String totalpath=EditorFile.getpath();
		
		   String compilepath=totalpath.substring(0,totalpath.lastIndexOf("\\"));
		   
		   String class_name=totalpath.substring(totalpath.lastIndexOf("\\")+1,totalpath.lastIndexOf("."));
		
		//System.out.println(class_name);
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		//System.out.println("java -classpath "+path+" "+class_name);
		
		System.out.println("java -classpath "+compilepath+" "+class_name);
		
	
			Process p=Runtime.getRuntime().exec("java -classpath "+compilepath+" "+class_name);
			
			
			BufferedReader br=new  BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String read;
			
			out.println("Output:");
			
			//System.out.println(br.readLine());
			
			while((read=br.readLine())!=null)
				
			{
				out.println(read);
				
				
			}
			
			br.close();
			
         out.println("<a href='editorlogout.jsp'>Go back to home page</a>");
			
			out.close();
			
			
			
			
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
