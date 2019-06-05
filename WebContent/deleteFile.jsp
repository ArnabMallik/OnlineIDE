<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*"%>
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
<form method="post" action="deleteFile2.jsp">
Select source language
<input type="radio" name="lang" value="C">C
<input type="radio" name="lang" value="Java">Java
<input type="radio" name="lang" value="C++">C++
<input type="submit" value="proceed">
</form>
</body>
</html>