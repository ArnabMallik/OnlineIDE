package servlets;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Path;
import dao.User;

/**
 * Servlet implementation class CpprunServlet
 */
@WebServlet("/CpprunServlet")
public class CpprunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CpprunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
           String un=((User)request.getSession().getAttribute("user")).getUsername();
		
           java.nio.file.Path source=Paths.get("E:\\softwares\\Eclipse\\eclipse\\a.exe");
   		
   		
   		java.nio.file.Path dest=Paths.get(Path.savepath+"\\"+un+"\\C++files\\a.exe");
   		
   		Files.move(source,dest,REPLACE_EXISTING);
   		
	
		
			Process p1=Runtime.getRuntime().exec(Path.savepath+"\\"+un+"\\C++files\\a.exe");
			
			try {
				System.out.println(p1.waitFor());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BufferedReader br=new  BufferedReader(new InputStreamReader(p1.getInputStream()));
			
			
			
			
			String read;
			
			out.println("Output:");
			
			while((read=br.readLine())!=null)
				
			{
				out.println(read);
				
				
			}
			br.close();
			out.println("<a href='success.jsp'>Go back to home page</a>");
			
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
