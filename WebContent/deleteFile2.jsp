<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="dao.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>  
    div { border: 3px solid; padding: 5px; }  
    div.left { text-align: left; background: #ffcccc; }  
    div.right { text-align: right; background: #ccccff; }  
   
  </style>
</head>
<body bgcolor=D0D0D0>
<div class="right"><em><%=Currenttime.getdate() %>,<%=Currenttime.getday() %></em></div>
<div class="right"><em><%=Currenttime.gettime() %> <%=Currenttime.getAMPM() %></em></div>
<table border="1">


<tr><th>Filename</th></tr>
<%
String un=((User)request.getSession().getAttribute("user")).getUsername();

String language=request.getParameter("lang");

DAO d=new DAO();

d.openConnection();

ResultSet rs=d.getfilenames(un,language);

while(rs.next())
	
{
	
	
%>

<tr><td><%=rs.getString("filesaved") %></td></tr>

<%

}

d.closeConnection();




%>

<form  method="post" action="DeleteFileServlet" >

<center>

ENTER FILENAME(WITH EXTENSION) <input type="text" name="filename"/><br>
            
   <input type="submit" value="Delete">          
   



</center>
</form>

</table>
<center><a href='success.jsp'>Go back</a></center>

</body>
</html>


