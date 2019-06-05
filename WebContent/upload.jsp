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
<script>

function checkupload() {
	
	
	
	var filename=document.getElementById("program").value;
	
	var ext=filename.substring(filename.lastIndexOf(".")+1);
	
	
	
	if(ext=="java" || ext=="cpp" || ext=="c") {
		
	     return true;
		

		}
		
		
	
	else if(ext=="")
		
		{
		
		 alert("please select a file");
		 
		 return false;
		
		
		}
	
	else
		{
		alert("upload .c,.java or .cpp files only");
		
		return false;
		
		
		}
		
};

function func() {
	
alert("hello");	
	
	
}
		


</script>

<body bgcolor=D0D0D0>
<div class="right"><em><%=Currenttime.getdate() %>,<%=Currenttime.getday() %></em></div>
<div class="right"><em><%=Currenttime.gettime() %> <%=Currenttime.getAMPM() %></em></div>

<form id="fileUploadform" action="UploadServlet" method="post" enctype="multipart/form-data" onsubmit="return checkupload();">

<B>SELECT FILE YOU WANT TO UPLOAD</B>

<input type="file" name="program" id="program" onselect="func();"/>


<input type="submit"  value="upload">




</form>

<center><a href='success.jsp'>Go back</a></center>


</body>
</html>