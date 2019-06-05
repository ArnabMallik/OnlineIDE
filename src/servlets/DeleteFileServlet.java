package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.Path;
import dao.User;

/**
 * Servlet implementation class DeleteFileServlet
 */
@WebServlet("/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFileServlet() {
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
		
		String un=((User)request.getSession().getAttribute("user")).getUsername();
		
		//System.out.println(un);
		
		String filename=request.getParameter("filename");
		
		String ext=filename.substring(filename.lastIndexOf(".")+1);
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		DAO d=new DAO();
		
		d.openConnection();
		
		d.deleteFile(un,filename);
		
		try {
			d.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ext.equals("c"))
			
		{
			
	File f=new File(Path.savepath+"\\"+un+"\\Cfiles\\"+filename);
			
			f.delete();;
			
			
	
		}
		
		else if(ext.equals("java"))
			
		{
			
	File f=new File(Path.savepath+"\\"+un+"\\Javafiles\\"+filename);
			
			f.delete();
		}
		
		else
			
		{
			
			File f=new File(Path.savepath+"\\"+un+"\\C++files\\"+filename);
			
			f.delete();
	
		}
		
		out.println("File deleted successfully");
		
		out.println("<a href='success.jsp'>Go back to home page</a>");
		
		out.close();
		
	}

}
