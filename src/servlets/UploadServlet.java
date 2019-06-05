package servlets;

import java.io.File;
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

import dao.Currenttime;
import dao.DAO;
import dao.Path;
import dao.User;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig(location="",fileSizeThreshold=1024*1024,maxFileSize=5*1024*1024,maxRequestSize=25*1024*1024)
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  private static final String  SAVE_DIR="uploadfiles";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //private static final String  SAVE_DIR="uploadfiles";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//String appPath=request.getServletContext().getRealPath("");
	
	//String savePath = appPath + File.separator + SAVE_DIR;
		
		String savePath =Path.savepath;
	
	String lang_type=null;
	
	   String un=((User)request.getSession().getAttribute("user")).getUsername();
	   
	   response.setContentType("text/html");
	    
	    PrintWriter out=response.getWriter();
       
	
	//System.out.println(savePath);
		
		
	 File fileSaveDir = new File(savePath);
     if (!fileSaveDir.exists()) {
         fileSaveDir.mkdir();
     }
     
     String fn=null,fn1=null;
     
     String final_path=null;
     
    // String class_name=null;
      
     for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         
         String ext=fileName.substring(fileName.lastIndexOf(".")+1);
        
         
         if(ext.equals("c"))
         {
        	 
        	 File f=new File(savePath+"\\"+un+"\\Cfiles");
        	 
        	 if(!f.exists()) {
        		 
        		 f.mkdir();
        	 }
        		 final_path=savePath+"\\"+un+"\\Cfiles";
        	 lang_type="C";
         }
         
         
         else if(ext.equals("java"))
         {
        	 
        	 File f=new File(savePath+"\\"+un+"\\Javafiles");
        	 
        	 if(!f.exists())
        		 
        		 f.mkdir();
        	 
        	 final_path=savePath+"\\"+un+"\\Javafiles";
        	 
        	 lang_type="Java";
        	 
        	//String  class_name=fileName.substring(0,fileName.length()-5);
        	  
        	 
        	 
         }
         
         
         else
         {
        	 
        	 File f=new File(savePath+"\\"+un+"\\C++files");
        	 
        	 if(!f.exists())
        		 
        		 f.mkdir();
        	 
        	final_path=savePath+"\\"+un+"\\C++files";
        	 
        	lang_type="C++";
         }
         //System.out.println(savePath + File.separator + fileName);
        // part.write(savePath +"\\"+un+File.separator + fileName);
         part.write(final_path+File.separator + fileName);
          fn=final_path+File.separator + fileName;
         fn1=fileName;
     }
     //System.out.print(fn1);
   User u=(User)request.getSession().getAttribute("user");
   
  // System.out.println(u.getUsername());
     
     DAO d=new DAO();
     
     d.openConnection();
     
     d.file_add(u.getUsername(),fn1,Currenttime.gettime(),Currenttime.getdate(),lang_type);
     
     try {
		d.closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
    
    //System.out.println(class_name);
    
   
    
    
     
     request.getSession().setAttribute("path",fn);
     
    // request.getSession().setAttribute("savepath",savePath+"\\"+un+"\\Javafiles");
     
    // request.getSession().setAttribute("classname", Path.java_class_name);
     
     //System.out.println(class_name);
     
     out.println("Upload has been done successfully!");
     
     out.println("<a href='success.jsp'>Click here to go to home page</a>");

     //request.setAttribute("message", "Upload has been done successfully!");
  // request.getRequestDispatcher("success.jsp").forward( request, response);
     
     out.close();
     
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


