<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

User u=(User)session.getAttribute("user");

String un=u.getUsername();

DAO d=new DAO();

d.openConnection();

ResultSet rs=d.getfile(un);

if(rs!=null)
	
{
	%>
	
	SELECT FILE

<select>

<% 

	while(rs.next())
		
	{

	String filesaved=rs.getString("filesaved");
	
	
%>

<option name="savefile" value='<%=filesaved%>'><%=filesaved%></option>	
	
	<% 
	
	
	
}

%>
</select>


<%
d.closeConnection();


}

else
	
{
	%>
	
	<b>Sorry you have uploaded no file</b>
	<a href="success.jsp">go to home page</a>
	<% 
	
}






%>


</body>
</html>