package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.*;


/**
 * Servlet implementation class CompileServlet
 */
@MultipartConfig(location="",fileSizeThreshold=1024*1024,maxFileSize=5*1024*1024,maxRequestSize=25*1024*1024)
@WebServlet("/CompileServlet")
public class CompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private static final String  SAVE_DIR="uploadfiles";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String appPath=request.getServletContext().getRealPath("");
	
	String savePath = appPath + File.separator + SAVE_DIR;
	
	
	
	
	
	//System.out.println(savePath);
		
		
	 File fileSaveDir = new File(savePath);
     if (!fileSaveDir.exists()) {
         fileSaveDir.mkdir();
     }
     
     String fn=null,fn1=null;
      
     for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
        
      
         //System.out.println(savePath + File.separator + fileName);
         part.write(savePath + File.separator + fileName);
         fn=savePath + File.separator + fileName;
         fn1=fileName;
     }
     System.out.print(fn1);
   User u=(User)request.getSession().getAttribute("user");
   
  // System.out.println(u.getUsername());
     
     DAO d=new DAO();
     
     d.openConnection();
     
    // d.file_add(u.getUsername(),fn1,Currenttime.gettime(),);
     
     try {
		d.closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String class_name=fn1.substring(0,fn1.length()-5);
    
    System.out.println(class_name);
    
    response.setContentType("text/html");
    
    PrintWriter out=response.getWriter();
    
    
     
     request.getSession().setAttribute("path",fn);
     
     request.getSession().setAttribute("savepath",savePath);
     
     request.getSession().setAttribute("classname", class_name);
     
     out.println("Upload has been done successfully!");
     
     out.println("<a href='success.jsp'>Click here to go to home page</a>");

     //request.setAttribute("message", "Upload has been done successfully!");
  // request.getRequestDispatcher("success.jsp").forward( request, response);
    
}

	
 
 /**
  * Extracts file name from HTTP header content-disposition
  */
 private String extractFileName(Part part) {
     String contentDisp = part.getHeader("content-disposition");
     String[] items = contentDisp.split(";");
     for (String s : items) {
         if (s.trim().startsWith("filename")) {
             return s.substring(s.indexOf("=") + 2, s.length()-1);
         }
     }
     return "";
 }

		
		
 }


