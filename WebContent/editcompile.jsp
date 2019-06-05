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
<caption><h2><u>YOUR UPLOAD HISTORY</u></h2></caption>

<th>filename</th><th>upload time</th><th>upload date</th><th>source language</th>

<%int flag=0;%>

<%



User u=(User)session.getAttribute("user");

String un=u.getUsername();

DAO d=new DAO();

d.openConnection();

ResultSet rs=d.getfile(un);


while(rs.next())
	
{
	
	flag=1;


%>

<tr><td><%=rs.getString("filesaved")%></td><td><%=rs.getString("time")%></td><td><%=rs.getString("upload_date") %></td><td><%=rs.getString("source_language") %></td></tr>


<%



}
%>





<% 

if(flag==0)
	
{

%>

<b>SORRY YOU HAVE NOT UPLOADED ANY FILE</b>

<a href="success.jsp">click here to go to home page</a>


<% 


}

else {
	
%>

<form  method="post" action="ForwardServlet" >

<center>

ENTER FILENAME(WITH EXTENSION)    <input type="text" name="filename"/><br><br><br>

CHOOSE OPTION <input type="radio" name="choice" value="edit"> EDIT
              <input type="radio" name="choice" value="compile"> COMPILE<br><br>	
              
   <input type="submit" value="Proceed">          
   
   </center> 
   </form>
	
<% 	
	
}




%>

</table>

<CENTER><a href='success.jsp'>GO BACK</a></CENTER>


</body>
</html>