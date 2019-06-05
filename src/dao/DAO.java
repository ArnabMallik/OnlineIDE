package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.servlet.http.Part;

import oracle.jdbc.OracleDriver;

public class DAO {
	
	private Connection con;

	public void openConnection() {
		// TODO Auto-generated method stub
		
		try {
			
			Driver d=new OracleDriver();
			
			DriverManager.registerDriver(d);
			
			String url="jdbc:oracle:thin:abhi/abhi123@//Abhishek-PC:1521/XE";
			
			con=DriverManager.getConnection(url);
			
		
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public User authenticate(String un, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="select * from customer where username=? and password=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, un);
		
		ps.setString(2,pwd);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
			
		{
			
			User u=new User();
			
			u.setFirstname(rs.getString("firstname"));
			
		
			
			u.setLastname(rs.getString("lastname"));
			
			u.setPassword(pwd);
			
			u.setUsername(un);
			
			return u;
			

			
		}
		
		
			
			return null;
			
			
	
		
	
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		con.close();
		
	}

	public void create(User u) {
		// TODO Auto-generated method stub
		
		try {
		
		String sql="insert into customer(username,password,firstname,lastname) values (?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,u.getUsername());
		
		ps.setString(2,u.getPassword());
		
		ps.setString(3,u.getFirstname());
		
		ps.setString(4,u.getLastname());
		
		
		
		ps.executeUpdate();
		
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
	
	
	
	public void file_add(String un,String fileName, String time,String date, String lang) {
		
        String sql1="select * from upload where filesaved=? and username=?";
		
		String sql2="delete from upload where filesaved=? and username=?";
		
String sql3="insert into upload(username,filesaved,time,upload_date,source_language) values (?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql1);
			

			ps.setString(1,fileName);
			
			ps.setString(2,un);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
                  ps=con.prepareStatement(sql2);
                  
                  ps.setString(1,fileName);
                  
                  ps.setString(2,un);
                  
                  ps.executeUpdate();
                  
			}
                  
                  ps=con.prepareStatement(sql3);
                  
                  ps.setString(1,un);
                  
                  ps.setString(2, fileName);
                  
                  ps.setString(3, time);
                  
                  ps.setString(4, date);
                  
                  ps.setString(5,lang);
                  
                  ps.executeUpdate();
                  
                 
                  
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	
		
		
		
		
	
	public ResultSet getfile(String username) {
		
		String sql="select filesaved,time,upload_date,source_language from upload where username=?";
		
		ResultSet rs=null;
		
		try {
	
			PreparedStatement ps=con.prepareStatement(sql);
			
		
			
			ps.setString(1,username);
			
			rs=ps.executeQuery();
		}
		
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
			
		
	}
	
	

	public ResultSet getfilenames(String username,String lang) {
		
		String sql="select filesaved from upload where username=? and source_language=?";
		
		ResultSet rs=null;
		
		try {
	
			PreparedStatement ps=con.prepareStatement(sql);
			
		
			ps.setString(1,username);
			
			ps.setString(2,lang);
			
			rs=ps.executeQuery();
		}
	
	
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
			
	
	}
	
	
	
	
	
	
	

	public void addfile(String filename,InputStream ios, File file) {
		// TODO Auto-generated method stub
		
		String sql="insert into filestore(filename,filetype) values(?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,filename);
			
			ps.setBinaryStream(2,ios,(int)file.length());
		
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void deRegister(String un, String pwd) {
		// TODO Auto-generated method stub
		
		String sql="delete from customer where username=? and password=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,un);
			
			ps.setString(2,pwd);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
				
		
	}

	public boolean check(String un, String pwd) {
		// TODO Auto-generated method stub
		
		
		String sql="select * from customer where username=? and password=?";
		
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,un);
			
			ps.setString(2,pwd);
			
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	public void deleteFile(String username,String filename) {
		// TODO Auto-generated method stub
		
		String sql="delete from upload where username=? and filesaved=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			
			ps.setString(2,filename);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	


