

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DAO;

/**
 * Servlet implementation class DataBaseUploadServlet
 */
@MultipartConfig(location="",fileSizeThreshold=1024*1024,maxFileSize=5*1024*1024,maxRequestSize=25*1024*1024)
@WebServlet("/DataBaseUploadServlet")

public class DataBaseUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataBaseUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String filename=request.getParameter("abc");
		
		Part filepart=request.getPart("uploaded");
		
		System.out.println(filename);
		
		File file=new File(filename);
		
		InputStream is=new FileInputStream(file);
		
		DAO d=new DAO();
		
		d.openConnection();
		
		d.addfile(filename,is,file);
		
		System.out.println("uploaded in database");
		
		
	}

}
